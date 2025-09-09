package com.hyper.service;

import com.hyper.DTO.UserLoginDTO;
import com.hyper.DTO.UserRequestDTO;
import com.hyper.DTO.UserResponseDTO;
import com.hyper.DTO.UserUpdateDTO;
import com.hyper.pojo.ApiResponse;
import com.hyper.pojo.User;

public interface UserService {
	
	UserResponseDTO UserLogin(UserLoginDTO userlogin);
	UserResponseDTO getUserProfile(Long userid);
	ApiResponse updateProfile(Long userid, UserUpdateDTO usdto);
	ApiResponse deleteUserProfile(Long userid);
	ApiResponse UserRegistration(UserRequestDTO userdto);
	UserResponseDTO  getUserByEmail(String Email);

}
