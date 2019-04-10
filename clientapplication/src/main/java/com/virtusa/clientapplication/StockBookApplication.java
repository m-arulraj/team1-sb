package com.virtusa.clientapplication;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StockBookApplication {
	
	public static void main( String[] args )
    {
		 Logger logger=Logger.getLogger(StockBookApplication.class);
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		logger.debug("Application staretd");
        SpringApplication.run(StockBookApplication.class, args);
    }
}
