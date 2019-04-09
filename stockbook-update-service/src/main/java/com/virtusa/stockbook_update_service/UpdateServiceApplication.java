package com.virtusa.stockbook_update_service;



import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UpdateServiceApplication {

	final static Logger logger = Logger.getLogger(UpdateServiceApplication.class);
	
	public static void main(String[] args) {
	 PropertyConfigurator.configure("src/main/resources/log4j.properties");
		logger.debug("Running UpdateService Apllication");
		SpringApplication.run(UpdateServiceApplication.class, args);
	}
}
