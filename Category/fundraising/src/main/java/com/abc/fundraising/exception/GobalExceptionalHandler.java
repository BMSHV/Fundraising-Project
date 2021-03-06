package com.abc.fundraising.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GobalExceptionalHandler {

	@ExceptionHandler(CategoryNotFoundException.class)
	public ResponseEntity<String> handleProductNotExistingException(Exception e){
		
		ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		return responseEntity;
	}
}
