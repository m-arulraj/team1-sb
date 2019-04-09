package com.virtusa.clientapplication;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StockBookApplication {
	private static Logger logger=Logger.getLogger(StockBookApplication.class);
	public static void main( String[] args )
    {
		logger.info("Application staretd");
		PropertyConfigurator.configure("src//main//resources//logging.properties");
        SpringApplication.run(StockBookApplication.class, args);
    }
}
