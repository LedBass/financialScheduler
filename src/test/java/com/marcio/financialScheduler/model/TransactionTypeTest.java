/**
 * 
 */
package com.marcio.financialScheduler.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author marcio
 *
 */
class TransactionTypeTest {
	
	private static TransactionType transactionType;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUp() {
		transactionType = new TransactionType("New type", "10-20", new BigDecimal(12.0), new BigDecimal(12.0), "Description of a new type", null, null);
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.model.TransactionType#TransactionType(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testTransactionType() {
		assertNotNull(new TransactionType());
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.model.TransactionType#getId()}.
	 */
	@Test
	void testGetId() {
		transactionType.setId(0L);
		assertNotNull(transactionType.getId());
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.model.TransactionType#getType()}.
	 */
	@Test
	void testGetType() {
		assertNotNull(transactionType.getType());
	}
	
	/**
	 * Test method for {@link com.marcio.financialScheduler.model.TransactionType#getDaysToTransactionInterval()}.
	 */
	@Test
	void testGetDaysToTransactionInterval() {
		assertNotNull(transactionType.getDaysToTransactionInterval());
	}
	
	/**
	 * Test method for {@link com.marcio.financialScheduler.model.TransactionType#getTransactionTax()}.
	 */
	@Test
	void testGetTransactionTax() {
		assertNotNull(transactionType.getTransactionTax());
	}
	
	/**
	 * Test method for {@link com.marcio.financialScheduler.model.TransactionType#getTransactionTaxPercentage()}.
	 */
	@Test
	void testGetTransactionTaxPercentage() {
		assertNotNull(transactionType.getTransactionTaxPercentage());
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.model.TransactionType#getDescription()}.
	 */
	@Test
	void testGetDescription() {
		assertNotNull(transactionType.getDescription());
	}
	
	/**
	 * Test method for {@link com.marcio.financialScheduler.model.TransactionType#checkTransactionRules()}.
	 */
	@Test
	void testCheckTransactionRulesShouldReturnTrue() {
		assertTrue(transactionType.checkTransactionRules(11, new BigDecimal(50.0).setScale(3, RoundingMode.FLOOR)));
	}
	
	/**
	 * Test method for {@link com.marcio.financialScheduler.model.TransactionType#checkTransactionRules()}.
	 */
	@Test
	void testCheckTransactionRulesShouldReturnFalse() {
		assertFalse(transactionType.checkTransactionRules(9, new BigDecimal(50.0).setScale(3, RoundingMode.FLOOR)));
		assertFalse(transactionType.checkTransactionRules(21, new BigDecimal(50.0).setScale(3, RoundingMode.FLOOR)));
	}
	
	/**
	 * Test method for {@link com.marcio.financialScheduler.model.TransactionType#checkTransactionRules()}.
	 */
	@Test
	void testCheckTransactionRulesWithMaxValueShouldReturnTrue() {
		transactionType.setMaxTransactionValue(new BigDecimal(100.000).setScale(3, RoundingMode.FLOOR));
		assertTrue(transactionType.checkTransactionRules(11, new BigDecimal(50.0).setScale(3, RoundingMode.FLOOR)));
	}
	
	/**
	 * Test method for {@link com.marcio.financialScheduler.model.TransactionType#checkTransactionRules()}.
	 */
	@Test
	void testCheckTransactionRulesWithMaxValueShouldReturnFalse() {
		transactionType.setMaxTransactionValue(new BigDecimal(100.000).setScale(3, RoundingMode.FLOOR));
		assertFalse(transactionType.checkTransactionRules(11, new BigDecimal(100.001).setScale(3, RoundingMode.FLOOR)));
	}
	
	/**
	 * Test method for {@link com.marcio.financialScheduler.model.TransactionType#checkTransactionRules()}.
	 */
	@Test
	void testCheckTransactionRulesWithMinValueShouldReturnTrue() {
		transactionType.setMinimalTransactionValue(new BigDecimal(100.000).setScale(3, RoundingMode.FLOOR));
		transactionType.setMaxTransactionValue(null);
		assertTrue(transactionType.checkTransactionRules(11, new BigDecimal(100.000).setScale(3, RoundingMode.FLOOR)));
	}
	
	/**
	 * Test method for {@link com.marcio.financialScheduler.model.TransactionType#checkTransactionRules()}.
	 */
	@Test
	void testCheckTransactionRulesWithMinValueShouldReturnFalse() {
		transactionType.setMinimalTransactionValue(new BigDecimal(100.000).setScale(3, RoundingMode.FLOOR));
		transactionType.setMaxTransactionValue(null);
		assertFalse(transactionType.checkTransactionRules(11, new BigDecimal(100.001).setScale(3, RoundingMode.FLOOR)));
	}
	
	/**
	 * Test method for {@link com.marcio.financialScheduler.model.TransactionType#checkTransactionRules()}.
	 */
	@Test
	void testCheckTransactionRulesWithoutEndDateShouldReturnFalse() {
		TransactionType transactionType = new TransactionType("New type", "10-", new BigDecimal(12.0),
				new BigDecimal(12.0), "Description of a new type", null, new BigDecimal(100.000).setScale(3, RoundingMode.FLOOR));
		assertFalse(transactionType.checkTransactionRules(9, new BigDecimal(50.00).setScale(3, RoundingMode.FLOOR)));
	}
	
	/**
	 * Test method for {@link com.marcio.financialScheduler.model.TransactionType#checkTransactionRules()}.
	 */
	@Test
	void testCheckTransactionRulesWithoutEndDateShouldReturnTrue() {
		TransactionType transactionType = new TransactionType("New type", "10-", new BigDecimal(12.0),
				new BigDecimal(12.0), "Description of a new type", null, new BigDecimal(100.000).setScale(3, RoundingMode.FLOOR));
		assertTrue(transactionType.checkTransactionRules(11, new BigDecimal(50.00).setScale(3, RoundingMode.FLOOR)));
	}
}
