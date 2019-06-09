/**
 * 
 */
package com.marcio.financialScheduler.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.marcio.financialScheduler.model.User;
import com.marcio.financialScheduler.repository.UserRepository;
import com.marcio.financialScheduler.service.UserService;

/**
 * Implementation class of the interface {@link UserService}
 * 
 * @author marcio
 *
 */
@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	
	/* (non-Javadoc)
	 * @see com.marcio.financialScheduler.service.UserService#getByUserId(java.lang.Long)
	 */
	@Override
	public User getByUserId(Long id) {
		Optional<User> optUser = this.repository.findById(id);
		
		if (optUser.isPresent()) {
			return optUser.get();
			
		} else {
			return new User();
		}
	}

	/* (non-Javadoc)
	 * @see com.marcio.financialScheduler.service.UserService#saveUser(com.marcio.financialScheduler.model.User)
	 */
	@Override
	public User saveUser(User user) {
		return this.repository.save(user);
	}

	/* (non-Javadoc)
	 * @see com.marcio.financialScheduler.service.UserService#updateUser(com.marcio.financialScheduler.model.User)
	 */
	@Override
	public User updateUser(User user) {
		return this.repository.save(user);
	}

	/* (non-Javadoc)
	 * @see com.marcio.financialScheduler.service.UserService#deleteUser(com.marcio.financialScheduler.model.User)
	 */
	@Override
	public String deleteUser(User user) {
		try {
			this.repository.delete(user);
			return "ok";
			
		} catch (Exception e) {
			return "not deleted";
		}
	}

	/* (non-Javadoc)
	 * @see com.marcio.financialScheduler.service.UserService#getAll()
	 */
	@Override
	public Iterable<User> getAll() {
		return this.repository.findAll();
	}
}
