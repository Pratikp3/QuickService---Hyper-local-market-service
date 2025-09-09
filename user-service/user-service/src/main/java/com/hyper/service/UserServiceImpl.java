package com.hyper.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hyper.DTO.UserLoginDTO;
import com.hyper.DTO.UserRequestDTO;
import com.hyper.DTO.UserResponseDTO;
import com.hyper.DTO.UserUpdateDTO;
import com.hyper.customException.ApiException;
import com.hyper.customException.AuthenticationException;
import com.hyper.pojo.ApiResponse;
import com.hyper.pojo.Role;
import com.hyper.pojo.User;
import com.hyper.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userepo;
	
	
	@Override
	public UserResponseDTO UserLogin(UserLoginDTO userlogin) {
		User user = userepo.findByEmailAndPassword(userlogin.getEmail(), userlogin.getPassword());
		if(user == null) {
			throw new AuthenticationException("Invalid Email or password!");
		}
		
		UserResponseDTO usdto = new UserResponseDTO();
		usdto.setEmail(user.getEmail());
		usdto.setAddress(user.getAddress());
		usdto.setContact(user.getContact());
		usdto.setRole(user.getRole().toString());
		usdto.setUsername(user.getUsername());
		usdto.setId(user.getId());
		return usdto;
	}

	@Override
	public UserResponseDTO getUserProfile(Long userid) {
		User user = userepo.findById(userid).orElseThrow(() -> new ApiException("user is not found!!"));
		UserResponseDTO usdto = new UserResponseDTO();
		usdto.setEmail(user.getEmail());
		usdto.setUsername(user.getUsername());
		usdto.setAddress(user.getAddress());
		usdto.setContact(usdto.getAddress());
		usdto.setRole(user.getRole().toString());
		usdto.setId(user.getId());
		
		return usdto;
	}

	@Override
	public ApiResponse updateProfile(Long userid, UserUpdateDTO usdto) {
		User updateuser = userepo.findById(userid).orElseThrow(() -> new ApiException("user not found!!"));
		
		if(!updateuser.getUsername().equals(usdto.getUsername()) && userepo.existsByUsername(usdto.getUsername())) {
			throw new ApiException("username already Exists!!");
		}
		
		if(!updateuser.getEmail().equals(usdto.getEmail()) && userepo.existsByemail(usdto.getEmail())) {
			throw new ApiException("Email Already Exists!!");
		}
		
		if(!updateuser.getContact().equals(usdto.getContact()) && userepo.existsByContact(usdto.getContact())) {
			throw new ApiException("Contact Already Exists!!");
		}
		
		updateuser.setUsername(usdto.getUsername());
		updateuser.setEmail(usdto.getEmail());
		updateuser.setContact(usdto.getContact());
		
		if(usdto.getPassword() != null && !usdto.getPassword().isEmpty()) {
			usdto.setPassword(usdto.getPassword());
		}
		
		userepo.save(updateuser);
		
		return new ApiResponse("User Profile updated Succesfully!!");
	}

	@Override
	public ApiResponse deleteUserProfile(Long userid) {
		User DeleteUser = userepo.findById(userid).orElseThrow(() -> new ApiException("User Doesnt Exists!!"));
		userepo.delete(DeleteUser);
		return new ApiResponse("User is Deleted from the Records!!");
	}

	@Override
	public ApiResponse UserRegistration(UserRequestDTO userdto) {
		if(userepo.existsByemail(userdto.getEmail())) {
			return new ApiResponse("Email already Exists!!");
			
		}
		
		User user = new User();
		user.setEmail(userdto.getEmail());
		user.setPassword(new BCryptPasswordEncoder().encode(userdto.getPassword()));
		user.setAddress(userdto.getAddress());
		user.setUsername(userdto.getUsername());
		user.setContact(userdto.getContact());
		Role roleEnum = Role.valueOf(userdto.getRole().toUpperCase());
		user.setRole(roleEnum);
		
		User savedUser = userepo.save(user);
		
		return new ApiResponse("User is Registered");
	}

	@Override
	public UserResponseDTO getUserByEmail(String Email) {
		User founduser =  userepo.findByEmail(Email);
		if(founduser == null) {
			throw new ApiException("User is not found!!");
		}
		
		UserResponseDTO userdto = new UserResponseDTO();
		userdto.setEmail(founduser.getEmail());
		userdto.setContact(userdto.getContact());
		userdto.setAddress(founduser.getAddress());
		userdto.setUsername(founduser.getUsername());
		userdto.setRole(founduser.getRole().toString().toUpperCase());
		userdto.setId(founduser.getId());
		
		
		return userdto;
	}

}
