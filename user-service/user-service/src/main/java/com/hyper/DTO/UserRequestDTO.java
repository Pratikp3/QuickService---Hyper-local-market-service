package com.hyper.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {
	
	private String username;
	private String email;
	private String password;
	private String contact;
	private String role;
	private String address;

}

///http://localhost:8081/api/users/User-Registration