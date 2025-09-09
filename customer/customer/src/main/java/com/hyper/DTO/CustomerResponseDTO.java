package com.hyper.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponseDTO {
	
	   
    private String fullName;         // from user-service
    private String email;            // from user-service
    private String phone;            // from user-service
    private String address;          // from user-service
    
    private String city;             // from customer-service
    private String state;            // from customer-service
    private String specificAddress;  // from customer-service
}
