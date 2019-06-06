package com.marcio.financialScheduler.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This class represents a model of user that may have or not a {@link BankAccount} linked to it
 * @author marcio
 *
 */
@Entity
public class User implements Serializable {
	
	private static final long serialVersionUID = 4285613886958029908L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private BankAccount bankAccount;
	
	/**
	 * Default class constructor (to be used by spring framework)
	 */
	public User() {}
	
	/**
	 * Class constructor use this constructor if you already have 
	 * all {@link BankAccount} object instance ready
	 * @param id a {@link Long} with the id of the user
	 * @param name a {@link String} with the name of the user
	 * @param bankAccount a {@link BankAccount} instance - it will only set the BankAccount object if it's valid (if the object has at least a balance value)
	 */
	public User(Long id, String name, BankAccount bankAccount) {
		this.setId(id);
		this.setName(name);
		this.setBankAccount(bankAccount);
	}
	
	/**
	 * Class constructor use this constructor to create an User instance 
	 * without the need to have a {@link BankAccount} object instance 
	 * @param id a {@link Long} with the id of the user
	 * @param name a {@link String} with the name of the user
	 */
	public User(Long id, String name) {
		this.setId(id);
		this.setName(name);
	}
	
	/**
	 * Get the id
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * set the id
	 * @param id the id to be set
	 */
	private void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * Get the name
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name
	 * @param name the name to be set
	 */
	private void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the {@link BankAccount}
	 * @return the {@link BankAccount}
	 */
	public BankAccount getBankAccount() {
		return bankAccount;
	}

	/**
	 * Set the {@link BankAccount}
	 * @param bankAccount the {@link BankAccount}
	 */
	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	/**
	 * Use this method to check if the object is in a valid state or not
	 * @return <code>true</code> if, and only if, the {@link User#name} isn't null or empty, <code>false</code> otherwise
	 */
	public boolean isValid() {
		if (null == this.getName() || this.getName().isEmpty()) {
			return false;
			
		} else {
			return true;
		}
	}
}
