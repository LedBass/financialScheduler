/**
 * 
 */
package com.marcio.financialScheduler.model;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
		User user = new User(0L, "name");
		bankAccount = new BankAccount(0L, new BigDecimal(100.00).setScale(3, RoundingMode.FLOOR), user);
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
		BankAccount account = new BankAccount(0L, new BigDecimal(100.00).setScale(3, RoundingMode.FLOOR), null);
		assertFalse(account.isValid());
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
	 * Test method for {@link com.marcio.financialScheduler.model.BankAccount#getUser()}.
	 */
	@Test
	void testGetUser() {
		assertNotNull(bankAccount.getUser());
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
