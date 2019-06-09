/**
 * 
 */
package com.marcio.financialScheduler.service;

import java.util.List;

import com.marcio.financialScheduler.model.BankAccount;
import com.marcio.financialScheduler.model.User;

/**
 * This is a service layer for {@link BankAccount} model class
 * @author marcio
 *
 */
public interface BankAccountService {
	
	/**
	 * Use this method to retrieve a {@link BankAccount} by it's id
	 * @param id a {@link Long} with the {@link BankAccount} id
	 * @return a {@link BankAccount} instance
	 */
	public abstract BankAccount getById(Long id);
	
	/**
	 * Use this method retrieve a {@link BankAccount} {@link List} owned by a certain {@link User}
	 * @param userId a {@link Long} with the {@link User}'s id
	 * @return a {@link List} of {@link BankAccount} owned by the given {@link User}'s id
	 */
	public abstract List<BankAccount> getByUserId(Long userId);
	
	/**
	 * Use this method to save a new {@link BankAccount} into the system
	 * @param bankAccount A {@link BankAccount} to be saved
	 * @param user A owner {@link User} of the account 
	 */
	public abstract BankAccount save(BankAccount bankAccount, User user);
	
	/**
	 * Use this method to update an existing {@link BankAccount} in the system
	 * @param bankAccount A {@link BankAccount} to be updated
	 */
	public abstract BankAccount update(BankAccount bankAccount);
	
	/**
	 * Use this method to delete a {@link BankAccount} instance off the system
	 * @param bankAccount A {@link BankAccount} to be deleted
	 */
	public abstract String delete(BankAccount bankAccount);
	
	/**
	 * Use this method to retrieve all {@link BankAccount}s in the system
	 * @return a {@link List} of {@link BankAccount} with all bank accounts in the system
	 */
	public abstract List<BankAccount> getAll();
}
