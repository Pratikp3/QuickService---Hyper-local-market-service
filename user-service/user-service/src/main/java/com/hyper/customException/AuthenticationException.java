package com.hyper.customException;

public class AuthenticationException extends RuntimeException{
	
	private String msg;
	
	public AuthenticationException(String msg) {
		this.msg = msg;
	}

}
