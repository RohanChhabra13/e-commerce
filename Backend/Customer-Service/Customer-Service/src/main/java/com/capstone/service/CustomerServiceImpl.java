package com.capstone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.entity.Customer;
import com.capstone.exception.CustomerAlreadyExistsException;
import com.capstone.exception.CustomerNotFoundException;
import com.capstone.repo.CustomerRepository;

/**
 * The CustomerServiceImpl class implements the CustomerService interface and provides
 * the concrete implementation of methods for managing customer data in the system.
 * It interacts with the database (via CustomerRepository) to perform CRUD operations on customers.
 * This service class handles exceptions such as CustomerNotFoundException and CustomerAlreadyExistsException.
 *
 * @author Rohan Chhabra
 * @version 1.0
 * @since 2023-10-11
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repo;
	//(DAO) responsible for interacting with the database to perform CRUD 
	
	/**
     * Adds a new customer to the system.
     *
     * @param c The Customer object to be added.
     * @return The added Customer object.
     * @throws CustomerAlreadyExistsException If a customer with the same custid already exists in the system.
     */
	@Override
	public Customer add(Customer c) throws CustomerAlreadyExistsException{	
		  if (repo.existsById(c.getCustid())) {
	            throw new CustomerAlreadyExistsException("Customer with custid: " + c.getCustid() + " already exists");
	        } else {
	            return repo.save(c);
	        }
	}
	/**
     * Retrieves a customer by their unique identifier (custid).
     *
     * @param custid The unique identifier of the customer.
     * @return The Customer object with the specified custid.
     * @throws CustomerNotFoundException If no customer with the given custid is found.
     */
	@Override
	public Customer find(String custid) {
		return repo.findById(custid).orElseThrow(()-> new CustomerNotFoundException("Customer does not Exist !!!!"));
	}
	/**
     * Retrieves a list of all customers in the system.
     *
     * @return A list of Customer objects.
     */

	@Override
	public List<Customer> list() {
		return repo.findAll();
	}
	/**
     * Authenticates a customer based on their custid and password.
     *
     * @param custid   The custid of the customer.
     * @param password The password of the customer.
     * @return The authenticated Customer object.
     * @throws CustomerNotFoundException If the provided custid and password do not match any customer.
     */
	@Override
	public Customer authenticate(String custid,String password) {
		return repo.findByCustidAndPassword(custid, password).orElseThrow(()->new CustomerNotFoundException("Invalid Login Credentials"));
	}

}
