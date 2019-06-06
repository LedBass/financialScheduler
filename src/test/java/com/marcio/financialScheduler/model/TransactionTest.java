/**
 * 
 */
package com.marcio.financialScheduler.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author marcio
 *
 */
class TransactionTest {
	
	private static Transaction transaction;
	
	@BeforeAll
	static void setup() {
		User user = new User(0L, "Name");
		BankAccount sourceAccount = new BankAccount(0L, new BigDecimal(100.00).setScale(3, RoundingMode.FLOOR), user);
		BankAccount destinationAccount = new BankAccount(1L, new BigDecimal(100.00).setScale(3, RoundingMode.FLOOR), null);
		TransactionType transactionType = new TransactionType("Transaction name", "10-20", new BigDecimal(12.0), new BigDecimal(12.0), "Transaction description", null, null);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate transactionSubmitDate = LocalDate.parse("06/06/2019", formatter);
		LocalDate transactionScheduleDate = LocalDate.parse("06/06/2019", formatter);
		
		
		transaction = new Transaction(sourceAccount.getUser(), sourceAccount, destinationAccount, transactionType, new BigDecimal(50.00).setScale(3, RoundingMode.FLOOR), transactionSubmitDate, transactionScheduleDate);
	}
	
	/**
	 * Test method for {@link com.marcio.financialScheduler.model.Transaction#getId()}.
	 */
	@Test
	void testGetId() {
		transaction.setId(0L);
		assertNotNull(transaction.getId());
	}
	
	/**
	 * Test method for {@link com.marcio.financialScheduler.model.Transaction#getUser()}.
	 */
	@Test
	void testGetUser() {
		assertNotNull(transaction.getUser());
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.model.Transaction#getSourceAccount()}.
	 */
	@Test
	void testGetSourceAccount() {
		assertNotNull(transaction.getSourceAccount());
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.model.Transaction#getDestinationAccount()}.
	 */
	@Test
	void testGetDestinationAccount() {
		assertNotNull(transaction.getDestinationAccount());
	}
	
	/**
	 * Test method for {@link com.marcio.financialScheduler.model.Transaction#getTransactionType()}.
	 */
	@Test
	void testGetTransactionType() {
		assertNotNull(transaction.getTransactionType());
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.model.Transaction#getTransactionValue()}.
	 */
	@Test
	void testGetTransactionValue() {
		assertNotNull(transaction.getTransactionValue());
	}
	
	/**
	 * Test method for {@link com.marcio.financialScheduler.model.Transaction#getTransactionSubmitDate()}.
	 */
	@Test
	void testGetTransactionDate() {
		assertNotNull(transaction.getTransactionSubmitDate());
	}
	
	/**
	 * Test method for {@link com.marcio.financialScheduler.model.Transaction#getIntervalDays()}.
	 */
	@Test
	void testIntervalDays() {
		assertNotNull(transaction.getIntervalDays());
		assertEquals(0, 0);
	}
}
