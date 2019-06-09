/**
 * 
 */
package com.marcio.financialScheduler.repository;

import org.springframework.data.repository.CrudRepository;

import com.marcio.financialScheduler.model.User;

/**
 * This is a repository to work with and persist {@link User} class
 * @author marcio
 *
 */
public interface UserRepository extends CrudRepository<User, Long> {}
