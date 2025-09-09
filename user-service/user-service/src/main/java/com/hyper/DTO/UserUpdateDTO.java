package com.hyper.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "password")
public class UserUpdateDTO {
	
	 @NotBlank(message = "Username is required")
	    @Size(min = 3, max = 25, message = "Username must be between 3 to 25 characters")
	    private String username;

	    @NotBlank(message = "Email is required")
	    @Email(message = "Invalid email format")
	    private String email;

	    @NotBlank(message = "Password is required")
	    @JsonProperty(access = Access.WRITE_ONLY)
	    private String password;

	    @NotBlank(message = "Contact is required")
	    private String contact;

}
