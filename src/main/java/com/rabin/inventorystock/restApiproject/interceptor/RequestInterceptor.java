package com.rabin.inventorystock.restApiproject.interceptor;

import java.util.logging.LogManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.rabin.inventorystock.restApiproject.exception.EmptyDataException;

import io.micrometer.core.instrument.util.StringUtils;
@Component
public class RequestInterceptor implements HandlerInterceptor{
	
private static final Logger log=LoggerFactory.getLogger(RequestInterceptor.class);
	
	
	//perform operation before sending the request to the controller
	@Override
	   public boolean preHandle(
	      HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	
		//if we add this we need to provide security for this
		//that is:in postman,in Header inside key:emp-auth-key   & in value:
//		if(StringUtils.isBlank(response.getHeader("emp-auth-key"))) {
//			throw new EmptyDataException("Invalid request");
//		}
		 
		log.info("pre handle method calling");
	      return true;
	   }
	//perform operations before sending the response to the client
	   @Override
	   public void postHandle(
	      HttpServletRequest request, HttpServletResponse response, Object handler, 
	      ModelAndView modelAndView) throws Exception {
		   log.info("post handle method calling");
	   }
	   
	   //perform operations after completing the request and response
	   @Override
	   public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
	      Object handler, Exception exception) throws Exception {
		   log.info("request and response is completed");
	   }

}
