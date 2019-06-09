/**
 * 
 */
package com.marcio.financialScheduler.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.marcio.financialScheduler.dto.TransactionDTO;
import com.marcio.financialScheduler.model.Transaction;

/**
 * @author marcio
 *
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
class TransactionServiceTest {
	
	@Autowired
	private TransactionService service;
	
	private Transaction transaction;
	
	@BeforeEach
	void setUp() {
		TransactionDTO transactionDTO = new TransactionDTO(0L, 1L, LocalDate.now(), "100.000");
		transaction = (Transaction) service.save(transactionDTO);
	}
	
	/**
	 * Test method for {@link com.marcio.financialScheduler.service.TransactionService#getById(java.lang.Long)}.
	 */
	@Test
	void testGetById() {
		assertNotNull(this.service.getById(0L));
	}
	
	/**
	 * Test method for {@link com.marcio.financialScheduler.service.TransactionService#getById(java.lang.Long)}.
	 */
	@Test
	void testGetByIdShouldRetunAnInvalidTransaction() {
		assertNull(this.service.getById(10000L).getId());
	}
	
	/**
	 * Test method for {@link com.marcio.financialScheduler.service.TransactionService#getById(java.lang.Long)}.
	 */
	@Test
	void testGetByIdShouldReturnInvalidTransaction() {
		assertNull(this.service.getById(1000L).getDestinationAccount());
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.service.TransactionService#update(com.marcio.financialScheduler.model.Transaction)}.
	 */
	@Test
	void testUpdate() {
		this.transaction.setTransactionScheduleDate(LocalDate.now().plusDays(10));
		assertTrue(this.service.update(transaction) instanceof Transaction);
	}
	
	/**
	 * Test method for {@link com.marcio.financialScheduler.service.TransactionService#update(com.marcio.financialScheduler.model.Transaction)}.
	 */
	@Test
	void testUpdateShouldReturnAnErrorMessage() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate transactionScheduleDate = LocalDate.parse("2019-06-07", formatter);
		LocalDate transactionSubmitDate = LocalDate.parse("2019-09-07", formatter);
		BigDecimal newValue = new BigDecimal(89.000).setScale(3, RoundingMode.FLOOR);
		transaction.setTransactionScheduleDate(transactionScheduleDate);
		transaction.setTransactionValue(newValue);
		transaction.setTransactionSubmitDate(transactionSubmitDate);

		assertTrue(this.service.update(transaction) instanceof String);
	}
	
	/**
	 * Test method for {@link com.marcio.financialScheduler.service.TransactionService#save(com.marcio.financialScheduler.model.Transaction)}.
	 */
	@Test
	void testSaveShouldReturnAnErrorMessage() {
		TransactionDTO transactionDTO = new TransactionDTO(0L, 1L, LocalDate.now().minusDays(5), "50.000");
		assertTrue(this.service.save(transactionDTO) instanceof String);
	}
	
	/**
	 * Test method for {@link com.marcio.financialScheduler.service.TransactionService#save(com.marcio.financialScheduler.model.Transaction)}.
	 */
	@Test
	void testSaveShouldReturnATransactionOfTypeA() {
		BigDecimal taxPercentage = new BigDecimal(3.00).setScale(3, RoundingMode.FLOOR);
		BigDecimal fixedTax = new BigDecimal(3.00).setScale(3, RoundingMode.FLOOR);
		
		TransactionDTO transactionDTO = new TransactionDTO(0L, 1L, LocalDate.now(), "100.000");
		Transaction result = (Transaction) this.service.save(transactionDTO);
		
		assertEquals(taxPercentage, result.getTransactionType().getTransactionTaxPercentage().setScale(3, RoundingMode.FLOOR));
		assertEquals(fixedTax, result.getTransactionType().getTransactionTax().setScale(3, RoundingMode.FLOOR));
	}
	
	/**
	 * Test method for {@link com.marcio.financialScheduler.service.TransactionService#save(com.marcio.financialScheduler.model.Transaction)}.
	 */
	@Test
	void testSaveShouldReturnATransactionOfTypeB() {
		Long days = 5L;
		BigDecimal paidValue = new BigDecimal(days).setScale(3, RoundingMode.FLOOR)
				.multiply(new BigDecimal(12.000).setScale(3, RoundingMode.FLOOR))
				.setScale(3, RoundingMode.FLOOR);
		
		TransactionDTO transactionDTO = new TransactionDTO(0L, 1L, LocalDate.now().plusDays(days), "50.000");
		Transaction result = (Transaction) this.service.save(transactionDTO);
		
		assertEquals(paidValue, result.getPaidTransactionTax());
	}
	
	/**
	 * Test method for {@link com.marcio.financialScheduler.service.TransactionService#save(com.marcio.financialScheduler.model.Transaction)}.
	 */
	@Test
	void testSaveShouldReturnATransactionOfTypeC8() {
		String transactionValue = "50.000";
		
		BigDecimal paidValue = new BigDecimal(transactionValue)
				.multiply(new BigDecimal(8.000).setScale(3, RoundingMode.FLOOR))
				.divide(new BigDecimal(100.00).setScale(3, RoundingMode.FLOOR))
				.setScale(3, RoundingMode.FLOOR);
		
		TransactionDTO transactionDTO = new TransactionDTO(0L, 1L, LocalDate.now().plusDays(15), transactionValue);
		Transaction result = (Transaction) this.service.save(transactionDTO);
		
		assertEquals(paidValue, result.getPaidTransactionTax());
	}
	
	/**
	 * Test method for {@link com.marcio.financialScheduler.service.TransactionService#save(com.marcio.financialScheduler.model.Transaction)}.
	 */
	@Test
	void testSaveShouldReturnATransactionOfTypeC6() {
		String transactionValue = "50.000";
		BigDecimal paidValue = new BigDecimal(transactionValue)
				.multiply(new BigDecimal(6.000).setScale(3, RoundingMode.FLOOR))
				.divide(new BigDecimal(100.00).setScale(3, RoundingMode.FLOOR))
				.setScale(3, RoundingMode.FLOOR);
		
		TransactionDTO transactionDTO = new TransactionDTO(0L, 1L, LocalDate.now().plusDays(25), transactionValue);
		Transaction result = (Transaction) this.service.save(transactionDTO);
		
		assertEquals(paidValue, result.getPaidTransactionTax());
	}
	
	/**
	 * Test method for {@link com.marcio.financialScheduler.service.TransactionService#save(com.marcio.financialScheduler.model.Transaction)}.
	 */
	@Test
	void testSaveShouldReturnATransactionOfTypeC4() {
		String transactionValue = "50.000";
		BigDecimal paidValue = new BigDecimal(transactionValue)
				.multiply(new BigDecimal(4.000).setScale(3, RoundingMode.FLOOR))
				.divide(new BigDecimal(100.00).setScale(3, RoundingMode.FLOOR))
				.setScale(3, RoundingMode.FLOOR);
		
		TransactionDTO transactionDTO = new TransactionDTO(0L, 1L, LocalDate.now().plusDays(35), transactionValue);
		Transaction result = (Transaction) this.service.save(transactionDTO);
		
		assertEquals(paidValue, result.getPaidTransactionTax());
	}
	
	/**
	 * Test method for {@link com.marcio.financialScheduler.service.TransactionService#save(com.marcio.financialScheduler.model.Transaction)}.
	 */
	@Test
	void testSaveShouldReturnATransactionOfTypeC2() {
		String transactionValue = "100.001";
		BigDecimal paidValue = new BigDecimal(transactionValue)
				.multiply(new BigDecimal(2.000).setScale(3, RoundingMode.FLOOR))
				.divide(new BigDecimal(100.00).setScale(3, RoundingMode.FLOOR))
				.setScale(3, RoundingMode.FLOOR);
		
		TransactionDTO transactionDTO = new TransactionDTO(0L, 1L, LocalDate.now().plusDays(45), transactionValue);
		Transaction result = (Transaction) this.service.save(transactionDTO);
		
		assertEquals(paidValue, result.getPaidTransactionTax());
	}
	
	/**
	 * Test method for {@link com.marcio.financialScheduler.service.TransactionService#save(com.marcio.financialScheduler.model.Transaction)}.
	 */
	@Test
	void testSaveShouldReturnATransactionOfTypeC4MinVal() {
		
		String transactionValue = "50.001";
		BigDecimal paidValue = new BigDecimal(transactionValue)
				.multiply(new BigDecimal(4.000).setScale(3, RoundingMode.FLOOR))
				.divide(new BigDecimal(100.00).setScale(3, RoundingMode.FLOOR))
				.setScale(3, RoundingMode.FLOOR);
		
		TransactionDTO transactionDTO = new TransactionDTO(0L, 1L, LocalDate.now().plusDays(45), transactionValue);
		Transaction result = (Transaction) this.service.save(transactionDTO);
		
		assertEquals(paidValue, result.getPaidTransactionTax());
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.service.TransactionService#getAll()}.
	 */
	@Test
	void testGetAll() {
		assertNotNull(this.service.getAll());
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.service.TransactionService#getByUserId(java.lang.String, java.lang.Long)}.
	 */
	@Test
	void testGetByUserId() {
		assertNotNull(this.service.getByUserId(0L));
	}
	
	/**
	 * Test method for {@link com.marcio.financialScheduler.service.TransactionService#getBySourceAccountId(java.lang.Long)}.
	 */
	@Test
	void testGetBySourceAccountId() {
		assertNotNull(this.service.getBySourceAccountId(0L));
	}
	
	/**
	 * Test method for {@link com.marcio.financialScheduler.service.TransactionService#getByDestinationAccountId(java.lang.Long)}.
	 */
	@Test
	void testGetByDestinationAccountId() {
		assertNotNull(this.service.getByDestinationAccountId(1L));
	}
	
	/**
	 * Test method for {@link com.marcio.financialScheduler.service.TransactionService#getByTransactionTypeId(java.lang.Long)}.
	 */
	@Test
	void testGetByTransactionTypeId() {
		assertNotNull(this.service.getByTransactionTypeId(0L));
	}

	/**
	 * Test method for {@link com.marcio.financialScheduler.service.TransactionService#getByLocalDate(java.lang.Boolean, java.time.LocalDate)}.
	 */
	@Test
	void testGetByLocalDate() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate transactionScheduleDate = LocalDate.parse("2019-06-07", formatter);
		LocalDate transactionSubmitDate = LocalDate.parse("2019-06-07", formatter);
		assertNotNull(this.service.getByLocalDate(false, transactionSubmitDate));
		assertNotNull(this.service.getByLocalDate(true, transactionScheduleDate));
	}

}
