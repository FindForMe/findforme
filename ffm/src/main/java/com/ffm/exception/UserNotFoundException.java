package com.ffm.exception;

public class UserNotFoundException extends Exception {

	
	private String message;
	
	public UserNotFoundException() {
		this("User is not available");
	}
	public UserNotFoundException(String message) {
		this.message = System.currentTimeMillis()+" "+message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
