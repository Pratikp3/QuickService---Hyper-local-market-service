package com.hyper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hyper.DTO.UserLoginDTO;
import com.hyper.DTO.UserRequestDTO;
import com.hyper.DTO.UserResponseDTO;
import com.hyper.DTO.UserUpdateDTO;
import com.hyper.pojo.ApiResponse;
import com.hyper.repository.UserRepository;
import com.hyper.service.UserService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepo;

	@GetMapping("/Email/{email}")
	public UserResponseDTO getUserByMail(@PathVariable String email) {
		return userService.getUserByEmail(email);
		
	}
	@PostMapping("/User-Registration")
	public ResponseEntity<ApiResponse> UserRegistration(@RequestBody UserRequestDTO usdto){
		return ResponseEntity.ok(userService.UserRegistration(usdto));
	}
	
	@PostMapping("/User-Login")
	public ResponseEntity<UserResponseDTO> UserLogin(@RequestBody @Valid UserLoginDTO userlog){
		return ResponseEntity.ok(userService.UserLogin(userlog));
	}
	
	@PutMapping("/update-user/{userid}")
	public ResponseEntity<?> Userupdate(@RequestBody @Valid UserUpdateDTO updatedto, @PathVariable Long userid){
		return ResponseEntity.ok(userService.updateProfile(userid, updatedto));
	}
	
	@DeleteMapping("/delete-user/{userid}")
	public ResponseEntity<?> DeleteUser(@PathVariable Long userid){
		return ResponseEntity.ok(userService.deleteUserProfile(userid));
	}
	
	@GetMapping("/user-profile")
	public ResponseEntity<UserResponseDTO> getUserprofile(@PathVariable Long userid){
		return ResponseEntity.ok(userService.getUserProfile(userid));
	}
}
