/**
 * 
 */
package com.marcio.financialScheduler.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author marcio
 *
 */
class TransactionDTOTest {
	
	private static TransactionDTO transaction;
	
	@BeforeAll
	static void setUp() {
		transaction = new TransactionDTO(0L, 0L, LocalDate.now(), "50.00");
	}
	
	/**
	 * Test method for {@link com.marcio.financialScheduler.dto.TransactionDTO#TransactionDTO()}.
	 */
	@Test
	void testTransactionDTO() {
		assertNotNull(new TransactionDTO());
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.dto.TransactionDTO#TransactionDTO(java.lang.Long, java.lang.Long, java.lang.String)}.
	 */
	@Test
	void testTransactionDTOLongLongString() {
		assertNotNull(new TransactionDTO(0L, 0L, LocalDate.now(), "50.00"));
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.dto.TransactionDTO#getSourceAccountId()}.
	 */
	@Test
	void testGetUserId() {
		assertNotNull(transaction.getSourceAccountId());
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.dto.TransactionDTO#getDestinationAccountId()}.
	 */
	@Test
	void testGetDestinationAccountId() {
		assertNotNull(transaction.getDestinationAccountId());
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.dto.TransactionDTO#getScheduleDate()}.
	 */
	@Test
	void testGetScheduleDate() {
		assertNotNull(transaction.getScheduleDate());
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.dto.TransactionDTO#getTransactionValue()}.
	 */
	@Test
	void testGetTransactionValue() {
		assertTrue(transaction.getTransactionValue() instanceof String);
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.dto.TransactionDTO#getTransactionValueAsBigDecimal()}.
	 */
	@Test
	void testGetTransactionValueAsBigDecimal() {
		assertTrue(transaction.getTransactionValueAsBigDecimal() instanceof BigDecimal);
	}
}
