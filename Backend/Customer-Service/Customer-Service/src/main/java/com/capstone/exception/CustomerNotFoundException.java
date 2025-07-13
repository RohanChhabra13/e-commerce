package com.capstone.exception;

/**
 * The CustomerNotFoundException is a custom exception class that extends RuntimeException.
 * It is thrown when an attempt to retrieve a customer by custid fails because the customer does not exist in the system.
 *
 * This exception is used to handle cases where a requested customer cannot be found based on the provided custid.
 * It provides an error message that can be used to convey information about the specific error.
 *
 * @author Rohan Chhabra
 * @version 1.0
 * @since 2023-10-11
 */
public class CustomerNotFoundException extends RuntimeException {

	/**
     * Constructs a new CustomerNotFoundException with the specified detail message.
     *
     * @param message The detail message describing the exception.
     */
	public CustomerNotFoundException(String message) {
		super(message);
	}
	/**
     * Constructs a new CustomerNotFoundException with no detail message.
     */
	public CustomerNotFoundException() {
		super();
	}
	

}
