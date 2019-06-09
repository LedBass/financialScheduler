/**
 * 
 */
package com.marcio.financialScheduler.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.marcio.financialScheduler.model.User;

/**
 * @author marcio
 *
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserServiceTest {
	
	@Autowired
	private UserService service;

	/**
	 * Test method for {@link com.marcio.financialScheduler.service.UserService#getByUserId(java.lang.Long)}.
	 */
	@Test
	void testGetByUserId() {
		assertNotNull(this.service.getByUserId(0L));
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.service.UserService#saveUser(com.marcio.financialScheduler.model.User)}.
	 */
	@Test
	void testSaveUser() {
		User user = new User();
		user.setName("new user");
		assertNotNull(this.service.saveUser(user));
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.service.UserService#updateUser(com.marcio.financialScheduler.model.User)}.
	 */
	@Test
	void testUpdateUser() {
		String otherName = "Test Name Other";
		User user = new User(1L, otherName);
		assertEquals(otherName, this.service.updateUser(user).getName());
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.service.UserService#deleteUser(com.marcio.financialScheduler.model.User)}.
	 */
	@Test
	void testDeleteUser() {
		User user = new User();
		user.setName("yet another user");
		user = this.service.saveUser(user);
		assertEquals("ok", this.service.deleteUser(user));
	}
	
	/**
	 * Test method for {@link com.marcio.financialScheduler.service.UserService#deleteUser(com.marcio.financialScheduler.model.User)}.
	 */
	@Test
	void testDeleteUserShouldFail() {
		User user = new User(1L, "other user");
		assertEquals("not deleted", this.service.deleteUser(user));
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.service.UserService#getAll()}.
	 */
	@Test
	void testGetAll() {
		assertNotNull(this.service.getAll());
	}

}
