package com.criszheng.springbootexception.exception;

/**
 * @author Cris
 * @date 10 Apr 2021
 * @version 1.0
 */

public class NullOrEmptyException extends Exception {
	private String message;

    public NullOrEmptyException(){
        setMessage("null or empty exception");
    }

    public NullOrEmptyException(String message) {
        this.message = message;
        setMessage(String.format("Prop: %s is null or empty!", message));
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
