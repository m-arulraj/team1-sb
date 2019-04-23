package com.virtusa.stockbook_biller_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BillerApplication {

	public static void main(String[] args) {

		SpringApplication.run(BillerApplication.class, args);
	}
}
