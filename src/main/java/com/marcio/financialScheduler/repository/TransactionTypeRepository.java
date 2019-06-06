/**
 * 
 */
package com.marcio.financialScheduler.repository;

import org.springframework.data.repository.Repository;

import com.marcio.financialScheduler.model.TransactionType;

/**
 * This is a repository to work with and persist {@link TransactionType} class
 * @author marcio
 *
 */
public interface TransactionTypeRepository extends Repository<TransactionType, Long> {
	public TransactionType getById(Long id);
	
	public TransactionType getByTransactionType(String type);
}
