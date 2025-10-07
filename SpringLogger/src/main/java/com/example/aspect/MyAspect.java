package com.example.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	
	private static final String CLASS_NAME=MyAspect.class.getName();
	private static Logger logger=Logger.getLogger(CLASS_NAME);
	
	@Before("execution(* com.example.service.MyService.myServiceTest(..))")
	public void welcome() {
		logger.entering(CLASS_NAME, "entering sell shoe method...");
		System.out.println("Welcom to shoe shop.....");
	}
	
	@AfterReturning("execution(* com.example.service.MyService.myServiceTest(..))")
	public void thankyou() {
		logger.info("sell shoe method finished and now it will exit...");
		System.out.println("Thank you.....For purchase..come again....");
	}
	
	@Around("execution(* com.example.service.MyService.myServiceTest(..))")
	public void duringPurchase(ProceedingJoinPoint jointpoint) throws Throwable{
		logger.info("now the Logger method is getting executed.....");
		System.out.println("during the execution of sell shoe method...");
		jointpoint.proceed();
		logger.info("the return value of sell shoe logic is...:");
//		return shoe;
	}
	
	@AfterThrowing(pointcut = "execution(* com.example.service.MyService.myServiceTest(..))")
	 public void handleException(IllegalArgumentException ex) {
	  System.out.println("Exception handling done.");
	  
	 }
}