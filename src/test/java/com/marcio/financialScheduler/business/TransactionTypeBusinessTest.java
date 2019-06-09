/**
 * 
 */
package com.marcio.financialScheduler.business;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.marcio.financialScheduler.model.BankAccount;
import com.marcio.financialScheduler.model.TransactionType;
import com.marcio.financialScheduler.repository.BankAccountRepository;
import com.marcio.financialScheduler.repository.TransactionTypeRepository;

/**
 * @author marcio
 *
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
class TransactionTypeBusinessTest {
	
	@Autowired
	private BankAccountRepository bankRepository;
	@Autowired
	private TransactionTypeRepository transactionRepository;
	/**
	 * Test method for {@link com.marcio.financialScheduler.business.TransactionTypeBusiness#createTransaction(com.marcio.financialScheduler.model.BankAccount, com.marcio.financialScheduler.model.BankAccount, java.math.BigDecimal, java.time.LocalDate, java.time.LocalDate, java.util.List)}.
	 */
	@Test
	void testCreateTransaction() {
		BankAccount sourceAccount = this.bankRepository.findById(0L).get();
		BankAccount destAccount = this.bankRepository.findById(1L).get();
		BigDecimal transactionValue = new BigDecimal(30.00).setScale(3, RoundingMode.FLOOR);
		LocalDate submitDate = LocalDate.now();
		LocalDate scheduleDate = LocalDate.now();
		List<TransactionType> transactionTypes = (List<TransactionType>) this.transactionRepository.findAll();
		
		TransactionTypeBusiness business = new TransactionTypeBusiness();
		assertNotNull(business.createTransaction(sourceAccount, destAccount, transactionValue, submitDate, scheduleDate, transactionTypes));
	}

}
