package com.marcio.financialScheduler.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;

/**
 * This class represents a model of BankAccount 
 * @author marcio
 *
 */
@Entity(name="bank_account")
public class BankAccount implements Serializable {
	
	private static final long serialVersionUID = -6925520542499981371L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	@Digits(integer=9, fraction=3)
	private BigDecimal balance;
	
	/**
	 * Default class constructor (it will be used by spring framework)
	 */
	public BankAccount() {}
	
	/**
	 * Class constructor
	 * @param id
	 * @param balance
	 * @param user
	 */
	public BankAccount(Long id, BigDecimal balance, User user) {
		this.setId(id);
		this.setBalance(balance);
		this.setUser(user);
	}
	
	/**
	 * User this method to certify that this instance is valid
	 * @return <code>true</code> if, and only if, this instance has a valid {@link BankAccount#balance}, <code>false</code> otherwise
	 */
	public boolean isValid() {
		return ((this.getBalance() == null ? false : true) && (this.getUser() != null));
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
	 * @return the balance
	 */
	public BigDecimal getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
}