package com.stockbook.adminservice.logging;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	private static Logger logger = Logger.getLogger(LoggingAspect.class);

	@Before("execution(* com.stockbook.adminservice.service.*.*(..))")
	public void logBeforeAllMethods(JoinPoint joinPoint) {

		logger.info("::LoggingAspect.logBeforeAllMethods() : " + joinPoint.getSignature().getName());

	}

	@After("execution(* com.stockbook.adminservice.service.*.*(..))")
	public void logAfterAllMethods(JoinPoint joinPoint) {

		logger.info("::LoggingAspect.logAfterAllMethods() : " + joinPoint.getSignature().getName());

	}
}
