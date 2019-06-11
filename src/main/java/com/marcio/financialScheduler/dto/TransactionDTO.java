/**
 * 
 */
package com.marcio.financialScheduler.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.marcio.financialScheduler.util.LocalDateConverterUtil;

import io.swagger.annotations.ApiModelProperty;

/**
 * A DTO class used mainly to create a new transaction in the system
 * @author marcio
 *
 */
public class TransactionDTO {
	
	@ApiModelProperty(notes="The user id of the transaction sender")
	private Long sourceAccountId;
	@ApiModelProperty(notes="The destination account id")
	private Long destinationAccountId;
	@ApiModelProperty(notes="The date that this transaction will be realized")
	@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
	private Date scheduleDate;
	@ApiModelProperty(notes="The value of the transaction")
	private String transactionValue;
	
	/**
	 * Default class constructor, it will be used by Spring Framework
	 */
	public TransactionDTO() {}
	
	/**
	 * Class constructor
	 * @param sourceAccountId a {@link Long} with the source account id
	 * @param destinationAccountId a {@link Long} with the destination account id
	 * @param scheduleDate a {@link Date} with the day that the operation will be realized
	 * @param transactionValue a {@link String} with the transaction value
	 */
	public TransactionDTO(Long sourceAccountId, Long destinationAccountId, Date scheduleDate, String transactionValue) {
		this.setSourceAccountId(sourceAccountId);
		this.setDestinationAccountId(destinationAccountId);
		this.setScheduleDate(scheduleDate);
		this.setTransactionValue(transactionValue);
	}
	
	/**
	 * Class constructor
	 * @param sourceAccountId a {@link Long} with the source account id
	 * @param destinationAccountId a {@link Long} with the destination account id
	 * @param scheduleDate a {@link String} with the day that the operation will be realized
	 * @param transactionValue a {@link String} with the transaction value
	 */
	public TransactionDTO(Long sourceAccountId, Long destinationAccountId, String scheduleDate, String transactionValue) {
		this.setSourceAccountId(sourceAccountId);
		this.setDestinationAccountId(destinationAccountId);
		LocalDate date = LocalDate.parse(scheduleDate);
		LocalDateConverterUtil converterUtil = new LocalDateConverterUtil();
		this.setScheduleDate(converterUtil.convertToDatabaseColumn(date));
		this.setTransactionValue(transactionValue);
	}
	
	/**
	 * Class constructor
	 * @param sourceAccountId a {@link Long} with the source account id
	 * @param destinationAccountId a {@link Long} with the destination account id
	 * @param scheduleDate a {@link LocalDate} with the day that the operation will be realized
	 * @param transactionValue a {@link String} with the transaction value
	 */
	public TransactionDTO(Long sourceAccountId, Long destinationAccountId, LocalDate scheduleDate, String transactionValue) {
		this.setSourceAccountId(sourceAccountId);
		this.setDestinationAccountId(destinationAccountId);
		LocalDateConverterUtil converterUtil = new LocalDateConverterUtil();
		this.setScheduleDate(converterUtil.convertToDatabaseColumn(scheduleDate));
		this.setTransactionValue(transactionValue);
	}

	/**
	 * @return the userId
	 */
	public Long getSourceAccountId() {
		return sourceAccountId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setSourceAccountId(Long userId) {
		this.sourceAccountId = userId;
	}

	/**
	 * @return the destinationAccountId
	 */
	public Long getDestinationAccountId() {
		return destinationAccountId;
	}

	/**
	 * @param destinationAccountId the destinationAccountId to set
	 */
	public void setDestinationAccountId(Long destinationAccountId) {
		this.destinationAccountId = destinationAccountId;
	}

	/**
	 * @return the scheduleDate
	 */
	public LocalDate getScheduleDate() {
		LocalDateConverterUtil converterUtil = new LocalDateConverterUtil();
		return converterUtil.convertToEntityAttribute(scheduleDate);
	}

	/**
	 * @param scheduleDate the scheduleDate to set
	 */
	public void setScheduleDate(Date scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	/**
	 * @return the transactionValue
	 */
	public String getTransactionValue() {
		return transactionValue;
	}
	
	/**
	 * Use this method to get the {@link TransactionDTO#getTransactionValue()} as a {@link BigDecimal}
	 * @return a {@link BigDecimal} with the {@link TransactionDTO#getTransactionValue()}
	 */
	@ApiModelProperty(hidden=true)
	public BigDecimal getTransactionValueAsBigDecimal() {
		return new BigDecimal(this.getTransactionValue()).setScale(3, RoundingMode.FLOOR);
	}

	/**
	 * @param transactionValue the transactionValue to set
	 */
	public void setTransactionValue(String transactionValue) {
		this.transactionValue = transactionValue;
	}
}
