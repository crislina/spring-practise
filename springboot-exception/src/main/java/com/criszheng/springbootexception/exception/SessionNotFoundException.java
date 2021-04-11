package com.criszheng.springbootexception.exception;

/**
 * @author Cris
 * @date 10 Apr 2021
 * @version 1.0
 */

public class SessionNotFoundException extends Exception {
	private String message;

    public SessionNotFoundException(){
        setMessage("session not found");
    }

    public SessionNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
