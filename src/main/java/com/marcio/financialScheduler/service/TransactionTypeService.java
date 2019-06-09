/**
 * 
 */
package com.marcio.financialScheduler.service;

import java.util.List;

import com.marcio.financialScheduler.model.TransactionType;

/**
 * This is a service layer for {@link TransactionTypeService} model class
 * 
 * @author marcio
 *
 */
public interface TransactionTypeService {
	
	/**
	 * Use this method to retrieve a {@link TransactionType} using it's type (or name)
	 * @param type a String with the {@link TransactionType} name
	 * @return a {@link TransactionType} for the given type (name)
	 */
	public abstract TransactionType getByTransactionType(String type);
	
	/**
	 * Use this method to retrieve a {@link TransactionType} using it's id
	 * @param id a Long with the id of the {@link TransactionType}
	 * @return a {@link TransactionType} instance
	 */
	public abstract TransactionType getById(Long id);
	
	/**
	 * Use this method to retrieve all {@link TransactionType} in the system
	 * @return a {@link List} of {@link TransactionType}
	 */
	public abstract List<TransactionType> getAll();
	
	/**
	 * Use this method to save a new {@link TransactionType} into the database
	 * @param transactionType a {@link TransactionType} to be saved
	 * @return the new {@link TransactionType} saved
	 */
	public abstract TransactionType save(TransactionType transactionType);
	
	/**
	 * Use this method to update a {@link TransactionType} into the database
	 * @param transactionType a {@link TransactionType} to be updated
	 * @return the new {@link TransactionType} updated
	 */
	public abstract TransactionType update(TransactionType transactionType);
}
