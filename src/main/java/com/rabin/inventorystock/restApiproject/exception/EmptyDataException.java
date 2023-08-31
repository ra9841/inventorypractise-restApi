package com.rabin.inventorystock.restApiproject.exception;

public class EmptyDataException extends RuntimeException{
	
	public  EmptyDataException(String message) {//constructor
		super(message);
	}

}
