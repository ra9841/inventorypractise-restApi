package com.rabin.inventorystock.restApiproject.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
//too many logger in service layer and other class is not good so Aop aspect came up
//centralizing our log statement
@Aspect
@Component
public class LoggingAdvice {
	
	Logger log=LoggerFactory.getLogger(LoggingAdvice.class);
	
	//@Pointcut(value="execution(* com.rabin.inventorystock.restApiproject.*.*.*(..))")//package/class/method---for all
	//for particular method then use down one
	@Pointcut(value="execution(* com.rabin.inventorystock.restApiproject.controller.InventoryController.getAllListOfRecord(..))")
	public void myPointCut() {
		
	}
	
	@Around("myPointCut()")
	public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
		ObjectMapper mapper=new ObjectMapper();
		String methodName=pjp.getSignature().getName();
		String className=pjp.getTarget().getClass().toString();
		Object[] array=pjp.getArgs();
		log.info("method invoked " + className +":"+ methodName +":"+"()" + "arguments :" 
				+ mapper.writeValueAsString(array));//before method invoked.which end point using
		long stratTime=System.currentTimeMillis();//tracking time
		Object object=pjp.proceed();
		long endTime=System.currentTimeMillis();
		log.info( className +":"+ methodName +":"+"()"+" "+" time taken to execute : "+(endTime-stratTime)+"millisecond"+" " + "response :" 
				+ mapper.writeValueAsString(object));//capturing response after proceed
		return object;
	}

}
