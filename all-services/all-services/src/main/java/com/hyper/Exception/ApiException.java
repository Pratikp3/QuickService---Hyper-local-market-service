package com.hyper.Exception;

public class ApiException extends RuntimeException {
	String message;
	
	public ApiException(String msg) {
		this.message = msg;
	}

}
