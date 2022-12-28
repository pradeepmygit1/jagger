/*
 * 2022-12-27
 */
package com.jagger.one.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.RestClientException;

/**
 * @author Pradeep
 *
 */

@ControllerAdvice
public class MyGlobalException {
	
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> getExceptionResponse(Exception exp){
		System.out.println("---- "+exp.getMessage());
		exp.printStackTrace();
		return new ResponseEntity<>(exp.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = RestClientException.class)
	public ResponseEntity<?> getExceptionResponse(RestClientException exp){
		System.out.println("---- "+exp.getMessage());
		exp.printStackTrace();
		return new ResponseEntity<>(exp.getMessage(),HttpStatus.SERVICE_UNAVAILABLE);
	}

}
