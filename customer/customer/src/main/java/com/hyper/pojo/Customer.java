package com.hyper.pojo;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Customers")
@Data
@Getter
@Setter
public class Customer extends BaseEntity implements Serializable {
	
	@Column(nullable = false, unique = true)
	private Long userId;
	
	@NotBlank
	@Column(length = 80, nullable = false)
	private String City;
	
	@NotBlank
	@Column(length = 90, nullable = false)
	private String state;
	
	@NotBlank
	@Column(length = 355, nullable = false)
	private String specificAddress;
	
	

}
