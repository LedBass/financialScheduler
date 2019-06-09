/**
 * 
 */
package com.marcio.financialScheduler.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.marcio.financialScheduler.model.TransactionType;

/**
 * @author marcio
 *
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
class TransactionTypeServiceTest {
	
	@Autowired
	private TransactionTypeService service;
	
	/**
	 * Test method for {@link com.marcio.financialScheduler.service.TransactionTypeService#getByTransactionType(java.lang.String)}.
	 */
	@Test
	void testGetByTransactionType() {
		assertNotNull(this.service.getByTransactionType("TYPE_C Up to 20 days"));
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.service.TransactionTypeService#getById(java.lang.Long)}.
	 */
	@Test
	void testGetbyId() {
		assertNotNull(this.service.getById(0L));
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.service.TransactionTypeService#getAll()}.
	 */
	@Test
	void testGetAll() {
		assertNotNull(this.service.getAll());
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.service.TransactionTypeService#save(com.marcio.financialScheduler.model.TransactionType)}.
	 */
	@Test
	void testSave() {
		BigDecimal newTransactionTax = new BigDecimal(9.00).setScale(3, RoundingMode.FLOOR);
		TransactionType type = new TransactionType("test", "50-60", newTransactionTax, true, newTransactionTax, true, "description", newTransactionTax, newTransactionTax);
		assertNotNull(this.service.save(type));
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.service.TransactionTypeService#update(com.marcio.financialScheduler.model.TransactionType)}.
	 */
	@Test
	void testUpdate() {
		BigDecimal newTransactionTax = new BigDecimal(9.00).setScale(3, RoundingMode.FLOOR);
		TransactionType type = new TransactionType("test", "50-60", newTransactionTax, true, newTransactionTax, true, "description", newTransactionTax, newTransactionTax);
		type = this.service.save(type);
		type.setDescription("another description");
		assertEquals("another description", this.service.update(type).getDescription());
	}
}
