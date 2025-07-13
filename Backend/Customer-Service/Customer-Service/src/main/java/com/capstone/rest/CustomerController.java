package com.capstone.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.entity.Customer;
import com.capstone.service.CustomerService;

/**
 * The CustomerController class handles HTTP requests related to customers.
 * It provides RESTful endpoints for adding, retrieving, listing, and authenticating customers.
 * This controller class is responsible for interacting with the CustomerService.
 *
 * @author Your Name
 * @version 1.0
 * @since 2023-10-11
 */

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/customer")
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	/**
     * Adds a new customer to the system.
     *
     * @param c The Customer object to be added.
     * @return The added Customer object.
     */

	@PostMapping(value="/add",consumes="application/json")
	public Customer add(@RequestBody Customer c) {
		return service.add(c);
	}
	
	/**
     * Retrieves a customer by their unique identifier (custid).
     *
     * @param custid The unique identifier of the customer.
     * @return The Customer object with the specified custid.
     */
	@GetMapping(value="/{id}",produces="application/json")
	public Customer find(@PathVariable String custid) {
		return service.find(custid);
	}
	/**
     * Retrieves a list of all customers in the system.
     *
     * @return A list of Customer objects.
     */
	@GetMapping(value="/all",produces="application/json")
	public List<Customer> list(){
		return service.list();
	}
	 /**
     * Authenticates a customer based on their custid and password.
     *
     * @param custid   The custid of the customer.
     * @param password The password of the customer.
     * @return The authenticated Customer object.
     */
	@GetMapping(value="/login",produces="application/json")
	public Customer authenticate(@RequestParam String custid,@RequestParam String password) {
		return service.authenticate(custid, password);
	}
	
}
