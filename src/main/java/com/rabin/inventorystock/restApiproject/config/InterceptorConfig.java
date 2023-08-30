package com.rabin.inventorystock.restApiproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.rabin.inventorystock.restApiproject.interceptor.RequestInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
	
	@Autowired
	private RequestInterceptor requestInterceptor;
	
	 @Override
	   public void addInterceptors(InterceptorRegistry registry) {
	     // registry.addInterceptor(requestInterceptor);//for all
		 registry.addInterceptor(requestInterceptor)//if for particular
		           .addPathPatterns("/**")
		            .excludePathPatterns("/rabin/getAllRecords");
	      
	   }

}
