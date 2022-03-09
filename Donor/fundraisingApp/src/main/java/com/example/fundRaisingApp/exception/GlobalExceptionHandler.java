package com.example.fundRaisingApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<String> IdNotFoundExceptionHandler(Exception e) {

		ResponseEntity<String> responseEntityId = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		return responseEntityId;

	}

}
