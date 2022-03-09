package com.springboot.sprint1.exception;

public class UserNotFoundException extends RuntimeException{
	
	public UserNotFoundException(String msg) {

		super(msg);

	}

}
