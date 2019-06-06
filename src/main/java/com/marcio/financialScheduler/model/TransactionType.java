/**
 * 
 */
package com.marcio.financialScheduler.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;

/**
 * This class is a representation of a model of a transaction type
 * 
 * @author marcio
 *
 */
@Entity(name="transaction_type")
public class TransactionType implements Serializable {
	private static final long serialVersionUID = 40490208217290670L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String transactionType;
	private String daysToTransactionInterval;
	private BigDecimal transactionTax;
	private BigDecimal transactionTaxPercentage;
	@Digits(integer=9, fraction=3)
	@Column(nullable=true)
	private BigDecimal minimalTransactionValue;
	@Digits(integer=9, fraction=3)
	@Column(nullable=true)
	private BigDecimal maxTransactionValue;
	private String description;
	
	/**
	 * Default class constructor, it will be used by Spring framework
	 */
	public TransactionType() {}
	
	/**
	 * 
	 * Class constructor, use this to save new transaction type into the database, the id will be set automatically
	 * @param type A {@link String} with the type of the transaction
	 * @param daysToTransactionInterval
	 * @param transactionTax a BigDecimal with the tax value of the transaction
	 * @param transactionPercentage
	 * @param minimalTransactionValue
	 * @param maxTransactionVaue
	 * @param description A {@link String} with the description of the description
	 */
	public TransactionType(String type, String daysToTransactionInterval, BigDecimal transactionTax,
			BigDecimal transactionPercentage, String description, BigDecimal minimalTransactionValue,
			BigDecimal maxTransactionVaue) {
		this.setType(type);
		this.setTransactionTax(transactionTax);
		this.setDaysToTransactionInterval(daysToTransactionInterval);
		this.setTransactionTaxPercentage(transactionPercentage);
		this.setMinimalTransactionValue(minimalTransactionValue);
		this.setMaxTransactionValue(maxTransactionValue);
		this.setDescription(description);
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
	 * @return the type
	 */
	public String getType() {
		return transactionType;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.transactionType = type;
	}

	/**
	 * @return the daysToTransaction
	 */
	public String getDaysToTransactionInterval() {
		return daysToTransactionInterval;
	}

	/**
	 * @param daysToTransactionInterval the daysToTransaction to set
	 */
	public void setDaysToTransactionInterval(String daysToTransactionInterval) {
		this.daysToTransactionInterval = daysToTransactionInterval;
	}

	/**
	 * @return the transactioTax
	 */
	public BigDecimal getTransactionTax() {
		return transactionTax;
	}

	/**
	 * @param transactioTax the transactioTax to set
	 */
	public void setTransactionTax(BigDecimal transactioTax) {
		this.transactionTax = transactioTax;
	}

	/**
	 * @return the transactionTaxPercentage
	 */
	public BigDecimal getTransactionTaxPercentage() {
		return transactionTaxPercentage;
	}

	/**
	 * @param transactionTaxPercentage the transactionTaxPercentage to set
	 */
	public void setTransactionTaxPercentage(BigDecimal transactionTaxPercentage) {
		this.transactionTaxPercentage = transactionTaxPercentage;
	}

	/**
	 * @return the minimalTransactionValue
	 */
	public BigDecimal getMinimalTransactionValue() {
		return minimalTransactionValue;
	}

	/**
	 * @param minimalTransactionValue the minimalTransactionValue to set
	 */
	public void setMinimalTransactionValue(BigDecimal minimalTransactionValue) {
		this.minimalTransactionValue = minimalTransactionValue;
	}

	/**
	 * @return the maxTransactionValue
	 */
	public BigDecimal getMaxTransactionValue() {
		return maxTransactionValue;
	}

	/**
	 * @param maxTransactionValue the maxTransactionValue to set
	 */
	public void setMaxTransactionValue(BigDecimal maxTransactionValue) {
		this.maxTransactionValue = maxTransactionValue;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * 
	 * @param daysBetweenSubmitAndSchedule
	 * @param transactionValue
	 * @return
	 */
	public boolean checkTransactionRules(int daysBetweenSubmitAndSchedule, BigDecimal transactionValue) {
		boolean daysRule = false;
		boolean transactionValueRule = true;
		String[] stringArray = this.getDaysToTransactionInterval().split("-");
		Integer start = Integer.parseInt(stringArray[0]);
		
		if (stringArray.length <= 1) {			
			daysRule = daysBetweenSubmitAndSchedule >= start;
			
		} else {
			Integer end = Integer.parseInt(stringArray[1]);
			daysRule = (daysBetweenSubmitAndSchedule >= start && daysBetweenSubmitAndSchedule <= end);
		}
		
		Integer diference;
		if (this.getMaxTransactionValue() != null) {
			diference = transactionValue.compareTo(this.getMaxTransactionValue());
			transactionValueRule = (diference <= 0 ? true : false);
			
		} else if (this.getMinimalTransactionValue() != null) {
			diference = this.getMinimalTransactionValue().compareTo(transactionValue);
			transactionValueRule = (diference >= 0 ? true : false);
			
		}
		
		return (daysRule && transactionValueRule);
	}
}
