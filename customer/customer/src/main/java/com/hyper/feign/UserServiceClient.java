package com.hyper.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.hyper.DTO.UserResponseDTO;
import com.hyper.pojo.ApiResponse;

@FeignClient(name = "user-service")
public interface UserServiceClient {
	
	@GetMapping("/api/users/{userId}")
	 UserResponseDTO getUserById(@PathVariable Long userId);
	
	@DeleteMapping("/api/users/{userId}")
	ApiResponse DeleteUserById(@PathVariable long UserId);
	
	@GetMapping("/api/users/Email/{email}")
	UserResponseDTO getUserByMail(@PathVariable String email);
	



}
