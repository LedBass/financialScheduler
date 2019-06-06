/**
 * 
 */
package com.marcio.financialScheduler.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author marcio
 *
 */
class BankAccountTest {
	
	private static BankAccount bankAccount;
	
	@BeforeAll
	static void setup() {
		bankAccount = new BankAccount(0L, 100.00);
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.model.BankAccount#BankAccount()}.
	 */
	@Test
	void testBankAccount() {
		assertNotNull(new BankAccount());
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.model.BankAccount#isValid()}.
	 */
	@Test
	void testIsValidShouldReturnTrue() {
		assertTrue(bankAccount.isValid());
	}
	
	/**
	 * Test method for {@link com.marcio.financialScheduler.model.BankAccount#isValid()}.
	 */
	@Test
	void testIsValidShouldReturnFalse() {
		assertFalse(new BankAccount().isValid());
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.model.BankAccount#getId()}.
	 */
	@Test
	void testGetId() {
		assertNotNull(bankAccount.getId());
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.model.BankAccount#getBalance()}.
	 */
	@Test
	void testGetBalance() {
		assertNotNull(bankAccount.getBalance());
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.model.BankAccount#setBalance(java.lang.Double)}.
	 */
	@Test
	void testSetBalance() {
		bankAccount.setBalance(null);
		assertNull(bankAccount.getBalance());
	}

}
