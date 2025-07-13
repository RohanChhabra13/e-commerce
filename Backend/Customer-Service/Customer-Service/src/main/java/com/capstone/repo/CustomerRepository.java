package com.capstone.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.entity.Customer;

/**
 * The CustomerRepository interface extends JpaRepository and provides data access
 * methods for managing customer data in the system. It is used to perform CRUD operations
 * on customer entities stored in a database.
 *
 * This repository also includes a custom query method for finding a customer by custid and password.
 *
 * @author Rohan Chhabra
 * @version 1.0
 * @since 2023-10-11
 */
public interface CustomerRepository extends JpaRepository<Customer, String> {
			
	/**
     * Finds a customer by their custid and password.
     *
     * @param custid   The custid of the customer.
     * @param password The password of the customer.
     * @return An Optional containing the Customer object if found, or an empty Optional if not found.
     */
	Optional <Customer> findByCustidAndPassword(String custid, String password);

}
