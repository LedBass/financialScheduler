/**
 * 
 */
package com.marcio.financialScheduler.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.marcio.financialScheduler.model.BankAccount;
import com.marcio.financialScheduler.model.Transaction;
import com.marcio.financialScheduler.model.TransactionType;
import com.marcio.financialScheduler.model.User;

/**
 * This is a repository to work with and persist {@link Transaction} class
 * @author marcio
 *
 */
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
	
	/**
	 * Use this method to retrieve a {@link List} of {@link Transaction} using the id of the owner {@link User}
	 * @param userId a {@link Long} with the user id
	 * @return a {@link List} of {@link Transaction}
	 */
	public List<Transaction> findByUser_id(Long userId);
	
	/**
	 * Use this method to retrieve a {@link List} od {@link Transaction} based on source account id
	 * @param sourceAccountId a {@link Long} with the {@link BankAccount} id
	 * @return a {@link List} of {@link Transaction}
	 */
	public List<Transaction> findBySourceAccount_id(Long sourceAccountId);
	
	/**
	 * Use this method to retrieve a {@link List} od {@link Transaction} based on the destination account id
	 * @param destinationAccountId a {@link Long} with the {@link BankAccount} id
	 * @return a {@link List} of {@link Transaction}
	 */
	public List<Transaction> findByDestinationAccount_id(Long destinationAccountId);
	
	/**
	 * Use this method to retrieve a {@link List} od {@link Transaction} based on the type of the transaction
	 * @param transactionTypeId a {@link Long} with the {@link TransactionType} id
	 * @return a {@link List} of {@link Transaction}
	 */
	public List<Transaction> findByTransactionType_id(Long transactionTypeId);
	
	/**
	 * Use this method to retrieve a {@link List} of {@link Transaction} based upon the Transaction submit date
	 * @param transactionDate  A {@link Date} with the submit date
	 * @return a {@link List} of {@link Transaction}
	 */
	public List<Transaction> findByTransactionSubmitDate(Date transactionSubmitDate);
	
	/**
	 * Use this method to retrieve a {@link List} of {@link Transaction} based upon the Transaction schedule date
	 * @param transactionDate A {@link Date} with the schedule date
	 * @return a {@link List} of {@link Transaction}
	 */
	public List<Transaction> findByTransactionScheduleDate(Date transactionScheculeDate);
}
