package com.hyper.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerUpdateDTO {
	
	private String fullName;
	private String email;
	private String phone;
	private String address;
	
	private String City;
	private String specificaddress;
	private String state;

}
