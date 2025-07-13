package com.capstone.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The Customer class represents a customer entity in the system.
 * It is used to store customer information in the database.
 *
 * This class is annotated with the @Entity annotation to indicate
 * that it is an entity class that can be persisted in a database table.
 *
 * @author Rohan Chhabra
 * @version 1.0
 * @since 2023-10-11
 */

@Entity
public class Customer {
	
	@Id
	String custid;
	String name;
	String mobile;
	String password;
	String email;
	
	/**
     * Gets the customer's unique identifier (custid).
     *
     * @return The custid of the customer.
     */
	public String getCustid() {
		return custid;
	}
	
	/**
     * Sets the customer's unique identifier (custid).
     *
     * @param custid The custid to set for the customer.
     */
	public void setCustid(String custid) {
		this.custid = custid;
	}
	/**
     * Gets the name of the customer.
     *
     * @return The name of the customer.
     */
	public String getName() {
		return name;
	}
	/**
     * Sets the name of the customer.
     *
     * @param name The name to set for the customer.
     */
	public void setName(String name) {
		this.name = name;
	}
	/**
     * Gets the mobile number of the customer.
     *
     * @return The mobile number of the customer.
     */
	public String getMobile() {
		return mobile;
	}
	/**
     * Sets the mobile number of the customer.
     *
     * @param mobile The mobile number to set for the customer.
     */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
     * Gets the password of the customer.
     *
     * @return The password of the customer.
     */
	public String getPassword() {
		return password;
	}
	/**
     * Sets the password of the customer.
     *
     * @param password The password to set for the customer.
     */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
     * Gets the email address of the customer.
     *
     * @return The email address of the customer.
     */
	public String getEmail() {
		return email;
	}
	/**
     * Sets the email address of the customer.
     *
     * @param email The email address to set for the customer.
     */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
