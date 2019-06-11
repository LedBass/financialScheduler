/**
 * 
 */
package com.marcio.financialScheduler.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.marcio.financialScheduler.util.LocalDateConverterUtil;

import io.swagger.annotations.ApiModelProperty;

/**
 * This class represents a model of a transfer transaction
 * 
 * All of it's set methods are private, so YOU SHOULD have all 
 * information available at the instantiation of this class
 * @author marcio
 *
 */
@Entity(name="transaction")
public class Transaction implements Serializable {
	@JsonIgnore
	private static final long serialVersionUID = -5398868929829076969L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(notes="The database generated id, don't bother setting it when creating a"
			+ " new user nor change it when updating an existing user. Better not touch")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	@ApiModelProperty(notes="The user that is the owner of the transaction")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="source_Account_id")
	@ApiModelProperty(notes="The bank account that originated the transaction")
	private BankAccount sourceAccount;
	
	@ManyToOne
	@JoinColumn(name="dest_Account_id")
	@ApiModelProperty(notes="The bank account that will receive the transaction value in the scheduled date")
	private BankAccount destinationAccount;
	
	@ManyToOne
	@JoinColumn(name="transaction_type_id")
	@ApiModelProperty(notes="The type of transaction based on the value and the interval between the submit and scheduled days")
	private TransactionType transactionType;
	
	@Digits(integer=9, fraction=3)
	@ApiModelProperty(notes="The transaction value")
	private BigDecimal transactionValue;
	
	@Digits(integer=9, fraction=3)
	@ApiModelProperty(notes="The tax paid by the owner of the source account for the transaction")
	private BigDecimal paidTransactionTax;
	
	@Temporal(TemporalType.TIMESTAMP)
	@ApiModelProperty(notes="The day of the submit of the transaction")
	@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
	private Date transactionSubmitDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@ApiModelProperty(notes="The day that the transaction were scheduled")
	@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
	private Date transactionScheduleDate;
	
	@ApiModelProperty(notes="the interval between the submit and the scheduled days")
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
	public void setUser(User user) {
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
	public void setSourceAccount(BankAccount sourceAccount) {
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
	public void setDestinationAccount(BankAccount destinationAccount) {
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
	public void setTransactionValue(BigDecimal transactionValue) {
		this.transactionValue = transactionValue;
	}

	/**
	 * @return the transactionDate
	 */
	public Date getTransactionSubmitDate() {
		return this.transactionSubmitDate;
	}

	/**
	 * @param transactionDate the transactionDate to set
	 */
	public void setTransactionSubmitDate(LocalDate transactionDate) {
		LocalDateConverterUtil converterUtil = new LocalDateConverterUtil();
		this.transactionSubmitDate = converterUtil.convertToDatabaseColumn(transactionDate);
	}

	/**
	 * @return the transactionScheduleDate
	 */
	public Date getTransactionScheduleDate() {
		return transactionScheduleDate;
	}

	/**
	 * @param transactionScheduleDate the transactionScheduleDate to set
	 */
	public void setTransactionScheduleDate(LocalDate transactionScheduleDate) {
		LocalDateConverterUtil converterUtil = new LocalDateConverterUtil();
		this.transactionScheduleDate = converterUtil.convertToDatabaseColumn(transactionScheduleDate);
	}
	
	public void setIntervalDays() {
		LocalDateConverterUtil converterUtil = new LocalDateConverterUtil();
		this.daysInterval = converterUtil.getDifferneceInDaysBetweenTwoDates(getTransactionSubmitDate(), getTransactionScheduleDate()).intValue();
	}
	
	public Integer getIntervalDays() {
		return this.daysInterval;
	}

	/**
	 * @return the paidTransactionTax
	 */
	public BigDecimal getPaidTransactionTax() {
		return paidTransactionTax;
	}

	/**
	 * @param paidTransactionTax the paidTransactionTax to set
	 */
	public void setPaidTransactionTax(BigDecimal paidTransactionTax) {
		this.paidTransactionTax = paidTransactionTax;
	}
}
