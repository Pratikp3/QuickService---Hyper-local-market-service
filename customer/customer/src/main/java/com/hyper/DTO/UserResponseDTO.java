package com.hyper.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
	
	private Long id;
	private String username;
	private String email;
	private String contact;
	private String role;
	private String address;

}
