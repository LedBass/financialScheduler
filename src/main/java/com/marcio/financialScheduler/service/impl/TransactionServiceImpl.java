/**
 * 
 */
package com.marcio.financialScheduler.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.marcio.financialScheduler.business.TransactionTypeBusiness;
import com.marcio.financialScheduler.dto.TransactionDTO;
import com.marcio.financialScheduler.model.BankAccount;
import com.marcio.financialScheduler.model.Transaction;
import com.marcio.financialScheduler.model.TransactionType;
import com.marcio.financialScheduler.repository.BankAccountRepository;
import com.marcio.financialScheduler.repository.TransactionRepository;
import com.marcio.financialScheduler.repository.TransactionTypeRepository;
import com.marcio.financialScheduler.service.TransactionService;
import com.marcio.financialScheduler.util.LocalDateConverterUtil;

/**
 * Implementation of the interface {@link TransactionService}
 * @author marcio
 *
 */
@Component
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	private TransactionRepository repository;
	@Autowired
	private TransactionTypeRepository typeRepository;
	@Autowired
	private BankAccountRepository bankRepository;
	
	private static final String NON_EXISTING_SOURCE_ACCOUNT = "A conta de origem não existe";
	private static final String NON_EXISTING_DEST_ACCOUNT = "A conta de destino não existe";
	
	
	/* (non-Javadoc)
	 * @see com.marcio.financialScheduler.service.TransactionService#getById(java.lang.Long)
	 */
	@Override
	public Transaction getById(Long id) {
		Optional<Transaction> optTransaction = this.repository.findById(id);
		
		if (optTransaction.isPresent()) {
			return optTransaction.get();
			
		} else {
			return new Transaction();
		}
	}

	/* (non-Javadoc)
	 * @see com.marcio.financialScheduler.service.TransactionService#save(com.marcio.financialScheduler.dto.TransactionDTO)
	 */
	@Override
	public Object save(TransactionDTO transactionDTO) {
		
		Optional<BankAccount> sourceAccountOpt = this.bankRepository.findById(transactionDTO.getSourceAccountId());
		Optional<BankAccount> destAccountOpt = this.bankRepository.findById(transactionDTO.getDestinationAccountId());
		
		if (!sourceAccountOpt.isPresent()) {
			return NON_EXISTING_SOURCE_ACCOUNT;
		}
		
		if (!destAccountOpt.isPresent()) {
			return NON_EXISTING_DEST_ACCOUNT;
		}
		
		BankAccount sourceAccount = sourceAccountOpt.get();
		BankAccount destAccount = destAccountOpt.get();
		BigDecimal transactionValue = transactionDTO.getTransactionValueAsBigDecimal();
		LocalDate submitDate = LocalDate.now();
		LocalDate scheduleDate = transactionDTO.getScheduleDate();
		
		TransactionTypeBusiness business = new TransactionTypeBusiness();
		List<TransactionType> transactionTypes = (List<TransactionType>) typeRepository.findAll();
		
		Object object = business.createTransaction(sourceAccount, destAccount, transactionValue, submitDate, scheduleDate, transactionTypes);
		
		if (object instanceof Transaction) {
			return this.repository.save((Transaction) object);
				
		} else {
			return object;
		}
	}

	/* (non-Javadoc)
	 * @see com.marcio.financialScheduler.service.TransactionService#update(com.marcio.financialScheduler.model.Transaction)
	 */
	@Override
	public Object update(Transaction transaction) {
		TransactionTypeBusiness business = new TransactionTypeBusiness();
		List<TransactionType> transactionTypes = (List<TransactionType>) this.typeRepository.findAll();
		
		LocalDateConverterUtil converterUtil = new LocalDateConverterUtil();
		LocalDate submitDate = converterUtil.convertToEntityAttribute(transaction.getTransactionSubmitDate());
		LocalDate scheduleDate = converterUtil.convertToEntityAttribute(transaction.getTransactionScheduleDate());
		
		Object object = business.createTransaction(transaction.getSourceAccount(), transaction.getDestinationAccount(), transaction.getTransactionValue(), submitDate, scheduleDate, transactionTypes);
		
		if (object instanceof Transaction) {
			return this.repository.save((Transaction) object);
			
		} else {
			return object;
		}
	}

	/* (non-Javadoc)
	 * @see com.marcio.financialScheduler.service.TransactionService#getAll()
	 */
	@Override
	public List<Transaction> getAll() {
		return (List<Transaction>) this.repository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.marcio.financialScheduler.service.TransactionService#getByUserId(java.lang.Long)
	 */
	@Override
	public List<Transaction> getByUserId(Long userId) {
		return this.repository.findByUser_id(userId);
	}

	/* (non-Javadoc)
	 * @see com.marcio.financialScheduler.service.TransactionService#getByLocalDate(java.lang.Boolean, java.time.LocalDate)
	 */
	@Override
	public List<Transaction> getByLocalDate(Boolean isScheduleDate, LocalDate localDate) {
		LocalDateConverterUtil converterUtil = new LocalDateConverterUtil();
		Date date = converterUtil.convertToDatabaseColumn(localDate);
		
		if (isScheduleDate) {
			return this.repository.findByTransactionScheduleDate(date);
			
		} else {
			return this.repository.findByTransactionSubmitDate(date);
		}
	}

	/* (non-Javadoc)
	 * @see com.marcio.financialScheduler.service.TransactionService#getBySourceAccountId(java.lang.Long)
	 */
	@Override
	public List<Transaction> getBySourceAccountId(Long sourceAccountId) {
		return this.repository.findBySourceAccount_id(sourceAccountId);
	}

	/* (non-Javadoc)
	 * @see com.marcio.financialScheduler.service.TransactionService#getByDestinationAccountId(java.lang.Long)
	 */
	@Override
	public List<Transaction> getByDestinationAccountId(Long destinationAccountId) {
		return this.repository.findByDestinationAccount_id(destinationAccountId);
	}

	/* (non-Javadoc)
	 * @see com.marcio.financialScheduler.service.TransactionService#getByTransactionTypeId(java.lang.Long)
	 */
	@Override
	public List<Transaction> getByTransactionTypeId(Long transactionTypeId) {
		return this.repository.findByTransactionType_id(transactionTypeId);
	}
}
