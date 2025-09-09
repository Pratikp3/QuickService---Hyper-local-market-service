package com.hyper.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.hyper.pojo.User;

import com.hyper.DTO.UserResponseDTO;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	public  User findByEmailAndPassword(String email, String password);
	public boolean existsByUsername(String username);
	public boolean existsByemail(String mail);
	public boolean existsByContact(String contact);
	public User findByUsername(String username);
	public User findByEmail(String email);

}
