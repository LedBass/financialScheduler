/**
 * 
 */
package com.marcio.financialScheduler.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.marcio.financialScheduler.model.BankAccount;
import com.marcio.financialScheduler.model.User;

/**
 * @author marcio
 *
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
class BankAccountServiceTest {

	@Autowired
	private BankAccountService service;
	/**
	 * Test method for {@link com.marcio.financialScheduler.service.BankAccountService#getById(java.lang.Long)}.
	 */
	@Test
	void testGetById() {
		assertNotNull(this.service.getById(0L));
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.service.BankAccountService#getByUserId(java.lang.Long)}.
	 */
	@Test
	void testGetByUserId() {
		assertNotNull(this.service.getByUserId(0L));
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.service.BankAccountService#save(com.marcio.financialScheduler.model.BankAccount)}.
	 */
	@Test
	void testSave() {
		User user = new User();
		user.setName("New user");
		BankAccount bankAccount = new BankAccount();
		bankAccount.setBalance(new BigDecimal(100.00).setScale(3, RoundingMode.FLOOR));
		assertNotNull(this.service.save(bankAccount, user));
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.service.BankAccountService#update(com.marcio.financialScheduler.model.BankAccount)}.
	 */
	@Test
	void testUpdate() {
		User user = new User();
		user.setName("New user");
		BankAccount bankAccount = new BankAccount();
		bankAccount.setBalance(new BigDecimal(100.00).setScale(3, RoundingMode.FLOOR));
		bankAccount = this.service.save(bankAccount, user);
		
		bankAccount.setBalance(new BigDecimal(150.00).setScale(3, RoundingMode.FLOOR));
		
		BankAccount newBankAccount = this.service.update(bankAccount);
		
		assertEquals(new BigDecimal(150.00).setScale(3, RoundingMode.FLOOR), newBankAccount.getBalance());
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.service.BankAccountService#delete(com.marcio.financialScheduler.model.BankAccount)}.
	 */
	@Test
	void testDelete() {
		User user = new User();
		user.setName("New user");
		BankAccount bankAccount = new BankAccount();
		bankAccount.setBalance(new BigDecimal(100.00).setScale(3, RoundingMode.FLOOR));
		bankAccount = this.service.save(bankAccount, user);
		assertEquals("ok", this.service.delete(bankAccount));
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.service.BankAccountService#getAll()}.
	 */
	@Test
	void testGetAll() {
		assertNotNull(this.service.getAll());
	}

}
