package com.rabin.inventorystock.restApiproject.advice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rabin.inventorystock.restApiproject.exception.EmptyDataException;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	
	
	    @ResponseStatus(HttpStatus.NOT_FOUND)
	    @ExceptionHandler(EmptyDataException.class)
	    public ResponseEntity<Map<String, String>> handleBusinessException(EmptyDataException ex) {
	        Map<String, String> errorMap = new HashMap<>();
	        errorMap.put("errorMessage", ex.getMessage());
	        errorMap.put("status", HttpStatus.NOT_FOUND.toString());
	     
	        return ResponseEntity.ok(errorMap);
	    }

}
