/**
 * 
 */
package com.marcio.financialScheduler.controller.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.marcio.financialScheduler.controller.rest.BankAccountRestController;
import com.marcio.financialScheduler.model.BankAccount;
import com.marcio.financialScheduler.model.User;

/**
 * @author marcio
 *
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class BankAccountRestControllerTest {
	
	@Autowired
	private BankAccountRestController restController;
	
	/**
	 * Test method for {@link com.marcio.financialScheduler.controller.rest.BankAccountRestController#getBankAccountList()}.
	 */
	@Test
	void testGetBankAccountList() {
		assertNotNull(this.restController.getBankAccountList());
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.controller.rest.BankAccountRestController#getBankAccountByUser(java.lang.Long)}.
	 */
	@Test
	void testGetBankAccountByUser() {
		assertNotNull(this.restController.getBankAccountByUser(0L));
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.controller.rest.BankAccountRestController#saveNew(com.marcio.financialScheduler.model.BankAccount, com.marcio.financialScheduler.model.User)}.
	 */
	@Test
	void testSaveNew() {
		User user = new User();
		user.setName("New user");
		BankAccount bankAccount = new BankAccount();
		bankAccount.setBalance(new BigDecimal(100.00).setScale(3, RoundingMode.FLOOR));
		assertNotNull(this.restController.saveNew(bankAccount, user));
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.controller.rest.BankAccountRestController#update(com.marcio.financialScheduler.model.BankAccount)}.
	 */
	@Test
	void testUpdate() {
		User user = new User();
		user.setName("New user");
		BankAccount bankAccount = new BankAccount();
		bankAccount.setBalance(new BigDecimal(100.00).setScale(3, RoundingMode.FLOOR));
		BankAccount newBankAccount = this.restController.saveNew(bankAccount, user);
		newBankAccount.setBalance(new BigDecimal(150.000).setScale(3, RoundingMode.FLOOR));
		
		assertEquals(new BigDecimal(150.000).setScale(3, RoundingMode.FLOOR), this.restController.update(newBankAccount, newBankAccount.getId()).getBalance());
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.controller.rest.BankAccountRestController#delete(com.marcio.financialScheduler.model.BankAccount)}.
	 */
	@Test
	void testDelete() {
		User user = new User();
		user.setName("New user");
		BankAccount bankAccount = new BankAccount();
		bankAccount.setBalance(new BigDecimal(100.00).setScale(3, RoundingMode.FLOOR));
		bankAccount = this.restController.saveNew(bankAccount, user);
		assertEquals("ok", this.restController.delete(bankAccount));
	}

}
