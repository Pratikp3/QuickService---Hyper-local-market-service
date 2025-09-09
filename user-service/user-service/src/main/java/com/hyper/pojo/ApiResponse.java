package com.hyper.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class ApiResponse {
	
	private String msg;
	
	public ApiResponse(String msg) {
		this.msg = msg;
	}

}
