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

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

/**
 * This class is a representation of a model of a transaction type
 * 
 * @author marcio
 *
 */
@Entity(name="transaction_type")
public class TransactionType implements Serializable {
	@JsonIgnore
	private static final long serialVersionUID = 40490208217290670L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(notes="The database generated id, don't bother setting it when creating a"
			+ " new type of transaction nor change it when updating an existing one. Better not touch.")
	private Long id;
	
	@ApiModelProperty(notes="The name of type of transaction.")
	private String transactionType;
	
	@ApiModelProperty(notes="This shows how many days exist in the interval between the submit and the "
			+ "schedule of a transaction that the type will apply it's rules")
	private String daysToTransactionInterval;
	
	@ApiModelProperty(notes="A monetary tax value that will be applied to the type of transaction")
	private BigDecimal transactionTax;
	
	@ApiModelProperty(notes="a flag that indicates if the fixed tax is billed per day or not")
	private Boolean perDayFixedTax;
	
	@ApiModelProperty(notes="A percentage tax calculated over the transaction value that will be applied to the type of transaction")
	private BigDecimal transactionTaxPercentage;
	
	@ApiModelProperty(notes="a flag that indicates if the percentage tax is billed per day or not")
	private Boolean perDayPercentageTax;
	
	@Digits(integer=9, fraction=3)
	@Column(nullable=true)
	@ApiModelProperty(notes="A minimal transaction value accepted by the type of transaction")
	private BigDecimal minimalTransactionValue;
	
	@Digits(integer=9, fraction=3)
	@Column(nullable=true)
	@ApiModelProperty(notes="A maximum transaction value accepted by the type of transaction")
	private BigDecimal maxTransactionValue;
	
	@ApiModelProperty(notes="A description of the type of transaction, IT MUST contain the transaction rules explained")
	private String description;
	
	/**
	 * Default class constructor, it will be used by Spring framework
	 */
	public TransactionType() {}
	
	/**
	 * 
	 * Class constructor, use this to save new transaction type into the database, the id will be set automatically
	 * @param type A {@link String} with the type of the transaction
	 * @param daysToTransactionInterval A {@link String} with the notation {@code "[start]-[end]"} where {@code [start]} is the number of days of the start and {@code [end]} is the limit of days of this transaction
	 * @param perDayFixedTax a {@link Boolean} indicating if the transactionTax is billed per day
	 * @param transactionTax a BigDecimal with the tax value of the transaction
	 * @param perDayPercentageTax a {@link Boolean} indicating if the transactionPercentage is billed per day
	 * @param transactionPercentage a {@link BigDecimal} with the percentage value
	 * @param minimalTransactionValue a {@link BigDecimal} with the minimal value of the transaction
	 * @param maxTransactionValue A {@link BigDecimal} with the maximum allowed value for this transaction
	 * @param description A {@link String} with the description of the description
	 */
	public TransactionType(String type, String daysToTransactionInterval, BigDecimal transactionTax, Boolean perDayFixedTax,
			BigDecimal transactionPercentage, Boolean perDayPercentageTax,String description, BigDecimal minimalTransactionValue,
			BigDecimal maxTransactionValue) {
		this.setType(type);
		this.setDaysToTransactionInterval(daysToTransactionInterval);
		this.setPerDayFixedTax(perDayFixedTax);
		this.setTransactionTax(transactionTax);
		this.setPerDayPercentageTax(perDayPercentageTax);
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
	 * @return the perDayFixedTax
	 */
	public Boolean getPerDayFixedTax() {
		return perDayFixedTax;
	}

	/**
	 * @param perDayFixedTax the perDayFixedTax to set
	 */
	public void setPerDayFixedTax(Boolean perDayFixedTax) {
		this.perDayFixedTax = perDayFixedTax;
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
	
	public boolean isValid() {
		if (null != this.getId()) {
			return true;
			
		} else {
			return false;
		}
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

	/**
	 * @return the perDayPercentageTax
	 */
	public Boolean getPerDayPercentageTax() {
		return perDayPercentageTax;
	}

	/**
	 * @param perDayPercentageTax the perDayPercentageTax to set
	 */
	public void setPerDayPercentageTax(Boolean perDayPercentageTax) {
		this.perDayPercentageTax = perDayPercentageTax;
	}
}
