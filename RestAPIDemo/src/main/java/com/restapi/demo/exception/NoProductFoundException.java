package com.restapi.demo.exception;

import lombok.Data;

@Data
public class NoProductFoundException extends RuntimeException{
		
	String resourceName;
	String fieldName;
	long fieldValue;
	
	public NoProductFoundException(String resourceName,String fieldName, long fieldvalue) {
		super(String.format("%s not found with %s : %s", resourceName,fieldName,fieldvalue));
		this.resourceName=resourceName;
		this.fieldName=fieldName;
		this.fieldValue=fieldValue;
	}
}
	
	
		
