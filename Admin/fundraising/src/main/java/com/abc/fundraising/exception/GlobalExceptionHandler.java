package com.abc.fundraising.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> handleUsertNotExistingException(Exception e) {		
		ResponseEntity<String> responseEntity= new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		return responseEntity;
	}	
	
	@ExceptionHandler(PostNotFoundException.class)
	public ResponseEntity<String> handlePostNotExistingException(Exception e) {		
		ResponseEntity<String> responseEntity= new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		return responseEntity;
	}	
	
	@ExceptionHandler(DonorNotFoundException.class)
	public ResponseEntity<String> handleDonorNotExistingException(Exception e) {		
		ResponseEntity<String> responseEntity= new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		return responseEntity;
	}	
	
	@ExceptionHandler(AdminNotFoundException.class)
	public ResponseEntity<String> handleAdminNotExistingException(Exception e) {		
		ResponseEntity<String> responseEntity= new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		return responseEntity;
	}	
	
}