/**
 * 
 */
package com.marcio.financialScheduler.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.marcio.financialScheduler.model.BankAccount;
import com.marcio.financialScheduler.model.User;
import com.marcio.financialScheduler.repository.BankAccountRepository;
import com.marcio.financialScheduler.repository.UserRepository;
import com.marcio.financialScheduler.service.BankAccountService;

/**
 * Implementation class of {@link BankAccountService} interface
 * @author marcio
 *
 */
@Component
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	private BankAccountRepository repository;
	
	@Autowired
	private UserRepository userRepository;
	
	/* (non-Javadoc)
	 * @see com.marcio.financialScheduler.service.BankAccountService#getById(java.lang.Long)
	 */
	@Override
	public BankAccount getById(Long id) {
		Optional<BankAccount> optBankAccount = this.repository.findById(id);
		if (optBankAccount.isPresent()) {
			return optBankAccount.get();
			
		} else {
			return new BankAccount();
		}
	}

	/* (non-Javadoc)
	 * @see com.marcio.financialScheduler.service.BankAccountService#getByUserId(java.lang.Long)
	 */
	@Override
	public List<BankAccount> getByUserId(Long userId) {
		return this.repository.findByUser_id(userId);
	}

	/*
	 * (non-Javadoc)
	 * @see com.marcio.financialScheduler.service.BankAccountService#save(com.marcio.financialScheduler.model.BankAccount)
	 */
	@Override
	public BankAccount save(BankAccount bankAccount, User user) {
		user = this.userRepository.save(user);
		bankAccount.setUser(user);
		return this.repository.save(bankAccount);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.marcio.financialScheduler.service.BankAccountService#update(com.marcio.financialScheduler.model.BankAccount)
	 */
	@Override
	public BankAccount update(BankAccount bankAccount) {
		return this.repository.save(bankAccount);
	}

	/*
	 * (non-Javadoc)
	 * @see com.marcio.financialScheduler.service.BankAccountService#delete(com.marcio.financialScheduler.model.BankAccount)
	 */
	@Override
	public String delete(BankAccount bankAccount) {
		try {
			this.repository.delete(bankAccount);
			return "ok";
			
		} catch (Exception e) {
			return "not deleted";
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.marcio.financialScheduler.service.BankAccountService#getAll()
	 */
	@Override
	public List<BankAccount> getAll() {
		return (List<BankAccount>) this.repository.findAll();
	}
}
