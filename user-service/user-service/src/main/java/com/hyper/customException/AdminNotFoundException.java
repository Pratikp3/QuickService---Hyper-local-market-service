package com.hyper.customException;

public class AdminNotFoundException extends RuntimeException {
	
	private String message;
	
	public AdminNotFoundException(String msg) {
		this.message = msg;
	}

}
