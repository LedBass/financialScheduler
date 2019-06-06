package com.marcio.financialScheduler.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This class represents a model of BankAccount 
 * @author marcio
 *
 */
@Entity
public class BankAccount implements Serializable {
	
	private static final long serialVersionUID = -6925520542499981371L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Double balance;
	
	/**
	 * Default class constructor (it will be used by spring framework)
	 */
	public BankAccount() {}
	
	/**
	 * Class constructor
	 * @param id
	 * @param balance
	 */
	public BankAccount(Long id, Double balance) {
		this.setId(id);
		this.setBalance(balance);
	}
	
	/**
	 * User this method to certify that this instance is valid
	 * @return <code>true</code> if, and only if, this instance has a valid {@link BankAccount#balance}, <code>false</code> otherwise
	 */
	public boolean isValid() {
		return (this.getBalance() == null ? false : true);
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
	 * @return the balance
	 */
	public Double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(Double balance) {
		this.balance = balance;
	}
}