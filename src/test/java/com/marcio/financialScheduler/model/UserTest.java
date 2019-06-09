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
		user = new User(0L, "name");
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
	void testIsValidShouldReturnFalseWithEmptyName() {
		User user = new User(0L, "");
		assertFalse(user.isValid());
	}
	
	/**
	 * Test method for {@link com.marcio.financialScheduler.model.User#isValid()}
	 */
	@Test
	void testIsValidShouldReturnFalseWithNullName() {
		User user = new User(0L, null);
		assertFalse(user.isValid());
	}
	
	/**
	 * Test method for {@link com.marcio.financialScheduler.model.User#isValid()}
	 */
	@Test
	void testIsValidShouldReturnFalseWithEmptyInstance() {
		assertFalse(new User().isValid());
	}
}
