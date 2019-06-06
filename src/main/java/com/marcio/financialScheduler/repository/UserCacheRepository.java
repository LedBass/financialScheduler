/**
 * 
 */
package com.marcio.financialScheduler.repository;

import org.springframework.data.repository.Repository;

import com.marcio.financialScheduler.model.User;

/**
 * This is a repository to work with and persist {@link User} class
 * @author marcio
 *
 */
//@RepositoryConfig(cacheName = "UserCache")
public interface UserCacheRepository extends Repository<User, Long> {
	
	/**
	 * Use this method to retrieve a {@link User} instance by it's id
	 * @param id a {@link Long} with the id of the instance to retrieve
	 * @return a {@link User} instance
	 */
	public User getUserById(Long id);
}
