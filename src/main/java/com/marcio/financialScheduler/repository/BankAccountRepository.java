/**
 * 
 */
package com.marcio.financialScheduler.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.marcio.financialScheduler.model.BankAccount;
import com.marcio.financialScheduler.model.User;

/**
 * This is a repository to work with and persist {@link BankAccount} class
 * @author marcio
 *
 */
public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {
	
	/**
	 * Use this method to retrieve a {@link BankAccount} owned by a certain {@link User}
	 * @param userId a Long with the {@link User}'s id
	 * @return a {@link BankAccount} instance
	 */
//	@Query(value="select (id, user_id, balance) from bank_account ba where ba.user_id=%?1%")
	public List<BankAccount> findByUser_id(Long userId);
}
