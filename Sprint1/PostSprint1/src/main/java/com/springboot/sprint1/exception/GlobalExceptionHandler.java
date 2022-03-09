package com.springboot.sprint1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(PostNotFoundException.class)
	public ResponseEntity<String> handlePostNotExistingException(Exception e){

		return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	
}
