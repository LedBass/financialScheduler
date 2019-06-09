/**
 * 
 */
package com.marcio.financialScheduler.repository;

import org.springframework.data.repository.CrudRepository;

import com.marcio.financialScheduler.model.TransactionType;

/**
 * This is a repository to work with and persist {@link TransactionType} class
 * @author marcio
 *
 */
public interface TransactionTypeRepository extends CrudRepository<TransactionType, Long> {
	public TransactionType getByTransactionType(String type);
}
