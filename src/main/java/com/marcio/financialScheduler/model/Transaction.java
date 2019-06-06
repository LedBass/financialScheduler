/**
 * 
 */
package com.marcio.financialScheduler.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;

/**
 * This class represents a model of a transfer transaction
 * 
 * All of it's set methods are private, so YOU SHOULD have all 
 * information available at the instantiation of this class
 * @author marcio
 *
 */
@Entity(name="transaction")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	@ManyToOne
	@JoinColumn(name="source_Account_id")
	private BankAccount sourceAccount;
	@ManyToOne
	@JoinColumn(name="dest_Account_id")
	private BankAccount destinationAccount;
	@ManyToOne
	@JoinColumn(name="transaction_type_id")
	private TransactionType transactionType;
	@Digits(integer=9, fraction=3)
	private BigDecimal transactionValue;
	private LocalDate transactionSubmitDate;
	private LocalDate transactionScheduleDate;
	private Integer daysInterval;
	
	/**
	 * Default class constructor, it will be used by Spring framework
	 */
	public Transaction() {}
	
	/**
	 * 
	 * @param user
	 * @param sourceAccount
	 * @param destinationAccount
	 * @param transactionValue
	 * @param transactionSubmitDate
	 * @param transactionScheduleDate
	 */
	public Transaction(User user, BankAccount sourceAccount, BankAccount destinationAccount,
			TransactionType transactionType, BigDecimal transactionValue, LocalDate transactionSubmitDate,
			LocalDate transactionScheduleDate) {
		this.setUser(user);
		this.setSourceAccount(sourceAccount);
		this.setDestinationAccount(destinationAccount);
		this.setTransactionType(transactionType);
		this.setTransactionValue(transactionValue);
		this.setTransactionSubmitDate(transactionSubmitDate);
		this.setTransactionScheduleDate(transactionScheduleDate);
		this.setIntervalDays();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	private void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the sourceAccount
	 */
	public BankAccount getSourceAccount() {
		return sourceAccount;
	}

	/**
	 * @param sourceAccount the sourceAccount to set
	 */
	private void setSourceAccount(BankAccount sourceAccount) {
		this.sourceAccount = sourceAccount;
	}

	/**
	 * @return the destinationAccount
	 */
	public BankAccount getDestinationAccount() {
		return destinationAccount;
	}

	/**
	 * @param destinationAccount the destinationAccount to set
	 */
	private void setDestinationAccount(BankAccount destinationAccount) {
		this.destinationAccount = destinationAccount;
	}

	/**
	 * @return the transactionType
	 */
	public TransactionType getTransactionType() {
		return transactionType;
	}

	/**
	 * @param transactionType the transactionType to set
	 */
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	/**
	 * @return the transactionValue
	 */
	public BigDecimal getTransactionValue() {
		return transactionValue;
	}

	/**
	 * @param transactionValue the transactionValue to set
	 */
	private void setTransactionValue(BigDecimal transactionValue) {
		this.transactionValue = transactionValue;
	}

	/**
	 * @return the transactionDate
	 */
	public LocalDate getTransactionSubmitDate() {
		return transactionSubmitDate;
	}

	/**
	 * @param transactionDate the transactionDate to set
	 */
	private void setTransactionSubmitDate(LocalDate transactionDate) {
		this.transactionSubmitDate = transactionDate;
	}

	/**
	 * @return the transactionScheduleDate
	 */
	public LocalDate getTransactionScheduleDate() {
		return transactionScheduleDate;
	}

	/**
	 * @param transactionScheduleDate the transactionScheduleDate to set
	 */
	public void setTransactionScheduleDate(LocalDate transactionScheduleDate) {
		this.transactionScheduleDate = transactionScheduleDate;
	}
	
	private void setIntervalDays() {
		this.daysInterval = this.getTransactionSubmitDate().compareTo(getTransactionScheduleDate());
	}
	
	public Integer getIntervalDays() {
		return this.daysInterval;
	}
}
