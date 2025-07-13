package com.capstone.shoppinggateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ShoppingGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingGatewayApplication.class, args);
	}

}
//The purpose of the registry discovery service is to discover services for which the IP is not known and to monitor them.
//The purpose of the API Gateway is to serve as an entry point for the client
