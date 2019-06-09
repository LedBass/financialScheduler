/**
 * 
 */
package com.marcio.financialScheduler.controller.rest;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.marcio.financialScheduler.controller.rest.TransactionTypeRestController;
import com.marcio.financialScheduler.model.TransactionType;

/**
 * @author marcio
 *
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class TransactionTypeRestControllerTest {
	
	@Autowired
	private TransactionTypeRestController restController;

	/**
	 * Test method for {@link com.marcio.financialScheduler.controller.rest.TransactionTypeRestController#getByTransactionType(java.lang.String)}.
	 */
	@Test
	void testGetByTransactionType() {
		assertNotNull(this.restController.getByTransactionType("TYPE_C Up to 20 days"));
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.controller.rest.TransactionTypeRestController#getById(java.lang.Long)}.
	 */
	@Test
	void testGetById() {
		assertNotNull(this.restController.getById(0L));
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.controller.rest.TransactionTypeRestController#getAll()}.
	 */
	@Test
	void testGetAll() {
		assertNotNull(this.restController.getAll());
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.controller.rest.TransactionTypeRestController#save(com.marcio.financialScheduler.model.TransactionType)}.
	 */
	@Test
	void testSave() {
		BigDecimal newTransactionTax = new BigDecimal(9.00).setScale(3, RoundingMode.FLOOR);
		TransactionType type = new TransactionType("test", "50-60", newTransactionTax, false, newTransactionTax, false, "description", newTransactionTax, newTransactionTax);
		assertNotNull(this.restController.save(type));
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.controller.rest.TransactionTypeRestController#update(com.marcio.financialScheduler.model.TransactionType)}.
	 */
	@Test
	void testUpdate() {
		BigDecimal newTransactionTax = new BigDecimal(9.00).setScale(3, RoundingMode.FLOOR);
		TransactionType type = new TransactionType("test", "50-60", newTransactionTax, false, newTransactionTax, false, "description", newTransactionTax, newTransactionTax);
		type = this.restController.save(type);
		type.setDescription("another description");
		assertEquals("another description", this.restController.update(type, type.getId()).getDescription());
	}
}
