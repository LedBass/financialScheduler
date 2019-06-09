/**
 * 
 */
package com.marcio.financialScheduler.service;

import java.time.LocalDate;
import java.util.List;

import com.marcio.financialScheduler.dto.TransactionDTO;
import com.marcio.financialScheduler.model.Transaction;

/**
 * This is a service layer for {@link Transaction} model class
 * 
 * @author marcio
 *
 */
public interface TransactionService {
	
	/**
	 * Use this method to retrieve a {@link Transaction} using it's id
	 * @param id a {@link Long} with the id
	 * @return a {@link Transaction} instance
	 */
	public abstract Transaction getById(Long id);
	
	/**
	 * Use this method to save a new {@link Transaction} into the database
	 * This method will use it's parameters to determine which type of transaction is being 
	 * submitted TODO - insert the rules of the transactions here
	 * 
	 * @param transactionDTO A {@link TransactionDTO} with the all parameters needed
	 * @return a {@link Object} instance with either the new saved {@link Transaction} or a {@link String} with the error message
	 */
	public abstract Object save(TransactionDTO transactionDTO);
	
	/**
	 * Use this method to update a given transaction
	 * <strong>IMPORTANT!</strong> Keep in mind that this method will also update the rules based on the new information
	 * 
	 * @param transaction the {@link Transaction} to be updated
	 * @return the updated {@link Transaction}
	 */
	public abstract Object update(Transaction transaction);
	
	/**
	 * Use this method to retrieve all transactions made in the system
	 * @return a {@link List} of {@link Transaction}
	 */
	public abstract List<Transaction> getAll();
	
	/**
	 * Use this method to retrieve a {@link List} of {@link Transaction} based upon the property needed
	 * @param userId a {@link Long} with the id
	 * @return a {@link List} of {@link Transaction}
	 */
	public abstract List<Transaction> getByUserId(Long userId);
	
	/**
	 * Use this method to retrieve a {@link List} of {@link Transaction} based upon the property needed
	 * @param sourceAccountId a {@link Long} with the id
	 * @return a {@link List} of {@link Transaction}
	 */
	public abstract List<Transaction> getBySourceAccountId(Long sourceAccountId);
	
	/**
	 * Use this method to retrieve a {@link List} of {@link Transaction} based upon the property needed
	 * @param sourceAccountId a {@link Long} with the id
	 * @return a {@link List} of {@link Transaction}
	 */
	public abstract List<Transaction> getByDestinationAccountId(Long destinationAccountId);
	
	/**
	 * Use this method to retrieve a {@link List} of {@link Transaction} based upon the property needed
	 * @param sourceAccountId a {@link Long} with the id
	 * @return a {@link List} of {@link Transaction}
	 */
	public abstract List<Transaction> getByTransactionTypeId(Long transactionTypeId);
	
	
	/**
	 * Use this method to retrieve a {@link List} of {@link Transaction} based on either schedule date or submit date 
	 * @param isScheduleDate a {@link Boolean} that determine if this date is a schedule one or not
	 * @param date a {@link LocalDate} with the date to be used in the search
	 * @return a {@link List} of {@link Transaction}
	 */
	public abstract List<Transaction> getByLocalDate(Boolean isScheduleDate, LocalDate date);
}
