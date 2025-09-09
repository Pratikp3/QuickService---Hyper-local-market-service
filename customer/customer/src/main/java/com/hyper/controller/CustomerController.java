package com.hyper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hyper.DTO.CustomerRequestDTO;
import com.hyper.DTO.CustomerResponseDTO;
import com.hyper.DTO.CustomerUpdateDTO;
import com.hyper.pojo.ApiResponse;
import com.hyper.service.CustomerService;

@RestController
@RequestMapping("/api/Customers")
public class CustomerController {
	
	@Autowired
	private CustomerService custservice;
	
	@GetMapping("/get-customer-profiles/{userId}")
	public ResponseEntity<CustomerResponseDTO> getCustomerProfiles(@PathVariable Long userId) {
		return ResponseEntity.ok(custservice.getCustomerprofile(userId));	
		
	}
	
	@PutMapping("/Update-Customer/{userId}")
	public ResponseEntity<ApiResponse> updateCustomerProfile(@PathVariable Long userId, @RequestBody CustomerUpdateDTO custdto){
		return ResponseEntity.ok(custservice.updateCustomerProfile(userId, custdto));
	}

	@DeleteMapping("/Delete-Customer/{userId}")
	public ResponseEntity<ApiResponse> deleteCustomerProfile(@PathVariable Long userId){
		return ResponseEntity.ok(custservice.deleteCustomerAccount(userId));
	}
	
	@PostMapping("/Add-Customer")
	public ResponseEntity<ApiResponse> addCustomerProfile(@RequestBody CustomerRequestDTO custdto){
		return ResponseEntity.ok(custservice.addCustomer(custdto));
	}
}