package com.abc.fundraising.exception;

public class AdminNotFoundException extends RuntimeException {
	public AdminNotFoundException(String msg) {
		super(msg);
	}
}