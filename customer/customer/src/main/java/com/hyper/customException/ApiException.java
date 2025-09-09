package com.hyper.customException;

public class ApiException extends RuntimeException {
	private String msg;
	
	public ApiException(String msg) {
		this.msg = msg;
	}

}
