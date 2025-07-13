package com.capstone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * The CustomerServiceApplication class is the entry point for the customer service application.
 * It is a Spring Boot application that is enabled as a Eureka client for service discovery.
 * This class contains the main method to start the Spring Boot application.
 *
 * @author Rohan Chhabra
 * @version 1.0
 * @since 2023-10-11
 */

@SpringBootApplication
@EnableEurekaClient
public class CustomerServiceApplication {
	
	/**
     * The main method that starts the Spring Boot application.
     *
     * @param args Command-line arguments passed to the application (not used in this case).
     */
	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

}
