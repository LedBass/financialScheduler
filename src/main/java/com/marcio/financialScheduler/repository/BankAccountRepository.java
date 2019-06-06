/**
 * 
 */
package com.marcio.financialScheduler.repository;

import org.springframework.data.repository.Repository;

import com.marcio.financialScheduler.model.BankAccount;
import com.marcio.financialScheduler.model.User;

/**
 * This is a repository to work with and persist {@link User} class
 * @author marcio
 *
 */
public interface BankAccountRepository extends Repository<BankAccount, Long> {
	
	/**
	 * Use this method to retrieve a {@link BankAccount} instance by it's id
	 * @param id a {@link Long} with the id of the instance to retrieve
	 * @return a {@link BankAccount} instance
	 */
	public BankAccount getById(Long id);
}
