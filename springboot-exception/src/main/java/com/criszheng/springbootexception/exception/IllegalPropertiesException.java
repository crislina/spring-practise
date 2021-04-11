package com.criszheng.springbootexception.exception;

/**
 * @author Cris
 * @date 10 Apr 2021
 * @version 1.0
 */

public class IllegalPropertiesException extends Exception {

	private String message;

	public IllegalPropertiesException(String message) {
		this.message = message;
		setMessage(String.format("Prop: %s is illegal!", message));
	}

	public IllegalPropertiesException() {
		setMessage("illegal properties exception");
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
