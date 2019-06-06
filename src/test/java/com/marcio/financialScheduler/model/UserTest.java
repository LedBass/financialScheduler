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
class UserTest {
	
	private static User user;
	
	@BeforeAll
	static void setup() {
		BankAccount bankAccount = new BankAccount(0L, 100.00);
		user = new User(0L, "name", bankAccount);
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.model.User#User()}.
	 */
	@Test
	void testUser() {
		assertNotNull(new User());
	}
	
	/**
	 * Test method for {@link com.marcio.financialScheduler.model.User#getId()}.
	 */
	@Test
	void testGetId() {
		assertNotNull(user.getId());
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.model.User#getName()}.
	 */
	@Test
	void testGetName() {
		assertNotNull(user.getName());
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.model.User#getBankAccount()}.
	 */
	@Test
	void testGetBankAccount() {
		assertNotNull(user.getBankAccount());
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.model.User#setBankAccount(com.marcio.financialScheduler.model.BankAccount)}.
	 */
	@Test
	void testSetBankAccount() {
		User user = new User(0l, "name");
		user.setBankAccount(null);
		assertNull(user.getBankAccount());
	}
	
	/**
	 * Test method for {@link com.marcio.financialScheduler.model.User#isValid()}
	 */
	@Test
	void testIsValidShouldReturnTrue() {
		User user = new User(0L, "name");
		assertTrue(user.isValid());
	}
	
	/**
	 * Test method for {@link com.marcio.financialScheduler.model.User#isValid()}
	 */
	@Test
	void testIsValidShouldReturnfalse() {
		User user = new User(0L, "");
		assertFalse(user.isValid());
		assertFalse(new User().isValid());
	}
}
