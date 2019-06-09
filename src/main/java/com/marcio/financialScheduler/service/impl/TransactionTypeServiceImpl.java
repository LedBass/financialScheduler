/**
 * 
 */
package com.marcio.financialScheduler.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.marcio.financialScheduler.model.TransactionType;
import com.marcio.financialScheduler.repository.TransactionTypeRepository;
import com.marcio.financialScheduler.service.TransactionTypeService;

/**
 * Implementation of the interface {@link TransactionTypeService}
 * @author marcio
 *
 */
@Component
public class TransactionTypeServiceImpl implements TransactionTypeService {
	
	@Autowired
	private TransactionTypeRepository repository;
	/* (non-Javadoc)
	 * @see com.marcio.financialScheduler.service.TransactionTypeService#getByTransactionType(java.lang.String)
	 */
	@Override
	public TransactionType getByTransactionType(String type) {
		return this.repository.getByTransactionType(type);
	}

	/* (non-Javadoc)
	 * @see com.marcio.financialScheduler.service.TransactionTypeService#getbyId(java.lang.Long)
	 */
	@Override
	public TransactionType getById(Long id) {
		Optional<TransactionType> optTransactionType = this.repository.findById(id);
		
		if (optTransactionType.isPresent()) {
			return optTransactionType.get();
			
		} else {
			return new TransactionType();
		}
	}

	/* (non-Javadoc)
	 * @see com.marcio.financialScheduler.service.TransactionTypeService#getAll()
	 */
	@Override
	public List<TransactionType> getAll() {
		return (List<TransactionType>) this.repository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.marcio.financialScheduler.service.TransactionTypeService#save(com.marcio.financialScheduler.model.TransactionType)
	 */
	@Override
	public TransactionType save(TransactionType transactionType) {
		return this.repository.save(transactionType);
	}

	/* (non-Javadoc)
	 * @see com.marcio.financialScheduler.service.TransactionTypeService#update(com.marcio.financialScheduler.model.TransactionType)
	 */
	@Override
	public TransactionType update(TransactionType transactionType) {
		return this.repository.save(transactionType);
	}

}
