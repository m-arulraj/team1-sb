package com.virtusa.stockbook_biller_service.logging;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	private static Logger logger=Logger.getLogger(LoggingAspect.class);
	
	@Before("execution(* com.virtusa.stockbook_biller_service.service.*.*(..))")
	public void loggingMessageBeforMethods(JoinPoint joinPoint) {
		logger.info("Before Method Execution Class :-"+joinPoint.getTarget().getClass()+" Method :-"+joinPoint.getSignature().getName());
	}
	
	@After("execution(* com.virtusa.stockbook_biller_service.service.*.*(..))")
	public void loggingMessageAfterMethods(JoinPoint joinPoint) {
		logger.info("Afetr Method Execution Class :-"+joinPoint.getTarget().getClass()+" Method :-"+joinPoint.getSignature().getName());
	}
}
