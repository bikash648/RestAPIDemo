package com.restapi.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = NoProductFoundException.class)
	public ResponseEntity<ApiResponse> handleNoProductFoundException(NoProductFoundException ex) {

		String message = ex.getMessage();

		ApiResponse apiResponse = new ApiResponse(message,false);

		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
	}

}
