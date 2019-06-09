/**
 * 
 */
package com.marcio.financialScheduler.service;

import java.util.List;

import com.marcio.financialScheduler.model.User;

/**
 * Service layer for {@link User} model class
 * 
 * @author marcio
 *
 */
public interface UserService {
	
	/**
	 * Use this method to retrieve an {@link User} instance using it's id
	 * @param id a {@link Long} with the user's id
	 * @return an {@link User} instance
	 */
	public abstract User getByUserId(Long id);
	
	/**
	 * Use this method to save a new {@link User} to the system
	 * @param user a {@link User} instance to be saved
	 */
	public abstract User saveUser(User user);
	
	/**
	 * Use this method to update a {@link User} in the system
	 * @param user a {@link User} instance to be updated
	 */
	public abstract User updateUser(User user);
	
	/**
	 * Use this method to delete {@link User} off the system
	 * @param user a {@link User} instance to be deleted
	 */
	public abstract String deleteUser(User user);
	
	/**
	 * Use this method to retrieve a {@link User} {@link List} available in the system
	 * @param user a {@link User} {@link List} of all users in the system
	 */
	public abstract Iterable<User> getAll();
}
