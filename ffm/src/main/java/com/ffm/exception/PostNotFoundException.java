package com.ffm.exception;

import java.io.Serializable;

public class PostNotFoundException extends Exception implements Serializable {

	private String message;
	
	public PostNotFoundException(){
		this("Post is not available !");
	}
	public PostNotFoundException(String message){
		this.message = System.currentTimeMillis()+" : "+message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
