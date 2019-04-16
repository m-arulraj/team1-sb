package com.virtusa.clientapplication;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class StockBookApplication {
	private static Logger logger = Logger.getLogger(StockBookApplication.class);

	@Bean
	public RestTemplate restTemplate() {

		return new RestTemplate();
	}

	public static void main(String[] args) {
		logger.info("Application staretd");
		PropertyConfigurator.configure("src/main/resources/logging.properties");
		SpringApplication.run(StockBookApplication.class, args);
	}
}
