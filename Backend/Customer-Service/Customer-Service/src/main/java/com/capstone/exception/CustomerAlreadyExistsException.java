package com.capstone.exception;

/**
 * The CustomerAlreadyExistsException is a custom exception class that extends RuntimeException.
 * It is thrown when an attempt is made to add a customer with a custid that already exists in the system.
 *
 * This exception is used to handle cases where the addition of a customer fails due to a duplicate custid.
 * It provides an error message that can be used to convey information about the specific error.
 *
 * @author Rohan Chhabra
 * @version 1.0
 * @since 2023-10-11
 */
public class CustomerAlreadyExistsException extends RuntimeException {

	/**
     * Constructs a new CustomerAlreadyExistsException with no detail message.
     */
	public CustomerAlreadyExistsException() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
     * Constructs a new CustomerAlreadyExistsException with the specified detail message.
     *
     * @param message The detail message describing the exception.
     */
	public CustomerAlreadyExistsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
