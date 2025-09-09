package com.hyper.exception;

public class ApiException extends RuntimeException{
	private String message;
	
	public ApiException(String message) {
		this.message = message;
	}

}
