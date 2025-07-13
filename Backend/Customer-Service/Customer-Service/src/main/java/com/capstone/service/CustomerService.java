package com.capstone.service;

import java.util.List;

import com.capstone.entity.Customer;

/**
 * The CustomerService interface defines the contract for managing customer data in the system.
 * Implementations of this interface provide methods for adding, retrieving, listing, and authenticating customers.
 *
 * @author Rohan Chhabra
 * @version 1.0
 * @since 2023-10-11
 */

public interface CustomerService {
	/**
     * Adds a new customer to the system.
     *
     * @param c The Customer object to be added.
     * @return The added Customer object.
     */
		Customer add(Customer c);
		/**
	     * Retrieves a list of all customers in the system.
	     *
	     * @return A list of Customer objects.
	     */
		List<Customer> list();
		/**
	     * Authenticates a customer based on their custid and password.
	     *
	     * @param custid   The custid of the customer.
	     * @param password The password of the customer.
	     * @return The authenticated Customer object.
	     */
		Customer authenticate(String custid,String password);
		 /**
	     * Retrieves a customer by their unique identifier (custid).
	     *
	     * @param custid The unique identifier of the customer.
	     * @return The Customer object with the specified custid.
	     */
		Customer find(String custid);
		
}
