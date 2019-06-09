/**
 * 
 */
package com.marcio.financialScheduler.controller.rest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.marcio.financialScheduler.controller.rest.TransactionRestController;
import com.marcio.financialScheduler.dto.TransactionDTO;
import com.marcio.financialScheduler.model.Transaction;
import com.marcio.financialScheduler.util.LocalDateConverterUtil;

/**
 * @author marcio
 *
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class TransactionRestControllerTest {
	
	@Autowired
	private TransactionRestController restController;
	
	private Transaction transaction;
	
	@BeforeEach
	void setUp() {
		String transactionValue = "000000100.000";
		TransactionDTO transactionDTO = new TransactionDTO(0L, 1L, LocalDate.now(), transactionValue);
		transaction = (Transaction) restController.save(transactionDTO);
	}
	
	/**
	 * Test method for {@link com.marcio.financialScheduler.controller.rest.TransactionRestController#getAll()}.
	 */
	@Test
	void testGetAll() {
		assertNotNull(this.restController.getAll());
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.controller.rest.TransactionRestController#getByUserId(java.lang.Long)}.
	 */
	@Test
	void testGetByUserId() {
		assertNotNull(this.restController.getByUserId(0L));
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.controller.rest.TransactionRestController#getBySourceAccountId(java.lang.Long)}.
	 */
	@Test
	void testGetBySourceAccountId() {
		assertNotNull(this.restController.getBySourceAccountId(0L));
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.controller.rest.TransactionRestController#getByDestinationAccountId(java.lang.Long)}.
	 */
	@Test
	void testGetByDestinationAccountId() {
		assertNotNull(this.restController.getByDestinationAccountId(0L));
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.controller.rest.TransactionRestController#getByTransactionTypeId(java.lang.Long)}.
	 */
	@Test
	void testGetByTransactionTypeId() {
		assertNotNull(this.restController.getByTransactionTypeId(0L));
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.controller.rest.TransactionRestController#update(com.marcio.financialScheduler.model.Transaction)}.
	 */
	@Test
	void testUpdate() {
		this.transaction.setTransactionScheduleDate(LocalDate.now().plusDays(45));
		
		assertTrue(this.restController.update(transaction, transaction.getId()) instanceof Transaction);
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.controller.rest.TransactionRestController#getBySubmitDate(java.time.LocalDate)}.
	 */
	@Test
	void testGetBySubmitDate() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate transactionSubmitDate = LocalDate.parse("2019-06-07", formatter);
		LocalDateConverterUtil converterUtil = new LocalDateConverterUtil();
		assertNotNull(this.restController.getBySubmitDate(converterUtil.convertToDatabaseColumn(transactionSubmitDate)));
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.controller.rest.TransactionRestController#getByScheduleDate(java.time.LocalDate)}.
	 */
	@Test
	void testGetByScheduleDate() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate transactionScheduleDate = LocalDate.parse("2019-06-07", formatter);
		LocalDateConverterUtil converterUtil = new LocalDateConverterUtil();
		assertNotNull(this.restController.getByScheduleDate(converterUtil.convertToDatabaseColumn(transactionScheduleDate)));
	}

}
