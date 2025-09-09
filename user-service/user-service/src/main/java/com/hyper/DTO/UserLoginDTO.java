package com.hyper.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class UserLoginDTO {
	private String email;
	private String password;

}
