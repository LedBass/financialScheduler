/**
 * 
 */
package com.marcio.financialScheduler.business;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.marcio.financialScheduler.model.BankAccount;
import com.marcio.financialScheduler.model.Transaction;
import com.marcio.financialScheduler.model.TransactionType;

/**
 * This class has methods to verify the type of a given transaction that needs to be done
 * @author marcio
 *
 */
public class TransactionTypeBusiness {
	
	private static final BigDecimal ONE_HUNDRED = new BigDecimal(100);
	private static final String ERROR_MESSAGE = "Não foi possível salvar essa transação, a transação não se encaixa nas regras determinadas de transações válidas";
	
	public Object createTransaction(BankAccount sourceAccount, BankAccount destAccount, BigDecimal transactionValue,
			LocalDate submitDate, LocalDate scheduleDate, List<TransactionType> transactionTypes) {
		Transaction transaction = new Transaction(sourceAccount.getUser(), sourceAccount, destAccount,
				null, transactionValue, submitDate, scheduleDate);
		
		Optional<TransactionType> transactionType = transactionTypes.stream().filter(
			toReturn -> {
				return toReturn.checkTransactionRules(transaction.getIntervalDays(), transactionValue);
			}
		).findFirst();
			
		if (transactionType.isPresent()) {
			transaction.setTransactionType(transactionType.get());
			BigDecimal paidTransactionTax = this.getTaxValueForTransaction(transactionType.get(), transactionValue, transaction.getIntervalDays());
			transaction.setPaidTransactionTax(paidTransactionTax);
			return transaction;
				
		} else {
			return ERROR_MESSAGE;
		}
	}
	
	/**
	 * Use this method to calculate the transaction tax value
	 * @param transactionType A {@link TransactionType} with the transaction rules
	 * @param transactionValue A {@link BigDecimal} with the value of the transaction
	 * @param daysInBetween An {@link Integer} with the days between in the submit and the schedule dates
	 * @return A {@link BigDecimal} with the calculated value 
	 */
	private BigDecimal getTaxValueForTransaction(TransactionType transactionType, BigDecimal transactionValue, Integer daysInBetween) {
		BigDecimal taxToPay = new BigDecimal(0).setScale(3, RoundingMode.FLOOR);
		
		if (transactionType.getPerDayFixedTax()) {
			BigDecimal days = new BigDecimal(daysInBetween).setScale(3, RoundingMode.FLOOR);
			taxToPay = transactionType.getTransactionTax().multiply(days).setScale(3, RoundingMode.FLOOR);
			
		} else {
			taxToPay = transactionType.getTransactionTax() != null ? taxToPay = taxToPay.add(transactionType.getTransactionTax()).setScale(3, RoundingMode.FLOOR) : taxToPay;
		}
		
		if (transactionType.getPerDayPercentageTax()) {
			BigDecimal days = new BigDecimal(daysInBetween).setScale(3, RoundingMode.FLOOR);
			taxToPay = percentage(transactionValue, transactionType.getTransactionTaxPercentage()).multiply(days).setScale(3, RoundingMode.FLOOR);
			
		} else {
			taxToPay = transactionType.getTransactionTax() != null ? 
					taxToPay = taxToPay.add(
							percentage(transactionValue, transactionType.getTransactionTaxPercentage()).setScale(3, RoundingMode.FLOOR)).setScale(3, RoundingMode.FLOOR) : taxToPay;
		}
		
		return taxToPay;
	}
	
	private BigDecimal percentage(BigDecimal value, BigDecimal percentage) {
		return value.multiply(percentage).divide(ONE_HUNDRED).setScale(3, RoundingMode.FLOOR);
	}
	
}