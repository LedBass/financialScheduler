/**
 * 
 */
package com.marcio.financialScheduler.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.marcio.financialScheduler.model.Transaction;

/**
 * This is a repository to work with and persist {@link Transaction} class
 * @author marcio
 *
 */
public interface TransactionRepository extends Repository<Transaction, Long>{
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Transaction getById(Long id);
	
	/**
	 * 
	 * @param userId
	 * @return
	 */
	@Query(value="select count t.* from transaction t "
			+ "where t.user_id = %?1% order by t.user_id \n#pageable\n",
			nativeQuery=true)
	public List<Transaction> findByUser(Long userId);
	
	/**
	 * 
	 * @param sourceAccountId
	 * @return
	 */
	@Query(value="select count t.* from transaction t "
			+ "where t.source_account = %?1% order by t.user_id \n#pageable\n",
			nativeQuery=true)
	public List<Transaction> findBySourceAccount(Long sourceAccountId);
	
	/**
	 * 
	 * @param destinationAccountId
	 * @return
	 */
	@Query(value="select count t.* from transaction t "
			+ "where t.dest_account = %?1% order by t.user_id \n#pageable\n",
			nativeQuery=true)
	public List<Transaction> findByDestinationAccount(Long destinationAccountId);
	
	/**
	 * 
	 * @param transactionTypeId
	 * @return
	 */
	@Query(value="select count t.* from transaction t "
			+ "where t.transaction_type_id = %?1% order by t.transaction_type_id \n#pageable\n",
			nativeQuery=true)
	public List<Transaction> findByTransactionType(Long transactionTypeId);
	
	/**
	 * 
	 * @param transactionDate
	 * @return
	 */
	@Query(value="select count t.* from transaction t "
			+ "where t.submit_date = %?1% order by t.submit_date \n#pageable\n",
			nativeQuery=true)
	public List<Transaction> findByTransactionSubmitDate(LocalDate transactionSubmitDate);
	
	/**
	 * 
	 * @param transactionDate
	 * @return
	 */
	@Query(value="select count t.* from transaction t "
			+ "where t.schedule_date = %?1% order by t.schedule_date \n#pageable\n",
			nativeQuery=true)
	public List<Transaction> findByTransactionSchefuleDate(LocalDate transactionScheculeDate);
}
