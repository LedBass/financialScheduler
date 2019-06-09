/**
 * 
 */
package com.marcio.financialScheduler.controller.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.marcio.financialScheduler.controller.rest.UserRestController;
import com.marcio.financialScheduler.model.User;

/**
 * @author marcio
 *
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class UserRestControllerTest {

	@Autowired
	private UserRestController restController;
	
	/**
	 * Test method for {@link com.marcio.financialScheduler.controller.rest.UserRestController#getUserList()}.
	 */
	@Test
	void testGetUserList() {
		assertNotNull(this.restController.getUserList());
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.controller.rest.UserRestController#getUserByd(java.lang.Long)}.
	 */
	@Test
	void testGetUserByd() {
		assertNotNull(this.restController.getUserByd(0L).getName());
	}
	
	/**
	 * Test method for {@link com.marcio.financialScheduler.controller.rest.UserRestController#getUserByd(java.lang.Long)}.
	 */
	@Test
	void testGetUserBydShouldReturnANewUser() {
		assertNull(this.restController.getUserByd(10L).getName());
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.controller.rest.UserRestController#saveUser(com.marcio.financialScheduler.model.User)}.
	 */
	@Test
	void testSaveUser() {
		User user = new User();
		String userName = "Test Name";
		user.setName(userName);
		assertEquals(userName, this.restController.saveUser(user).getName());
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.controller.rest.UserRestController#updateUser(com.marcio.financialScheduler.model.User)}.
	 */
	@Test
	void testUpdateUser() {
		User user = this.restController.getUserByd(0L);
		String userName = "changed Name";
		user.setName(userName);
		User changedUser = this.restController.updateUser(user, user.getId());
		assertEquals(userName, changedUser.getName());
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.controller.rest.UserRestController#deleteUser(com.marcio.financialScheduler.model.User)}.
	 */
	@Test
	void testDeleteUser() {
		User user = new User();
		user.setName("Test Name");
		assertEquals("ok", this.restController.deleteUser(user));
	}

}
