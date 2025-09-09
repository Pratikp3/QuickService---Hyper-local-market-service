package com.hyper.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Service_Provider")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ServiceProvider extends BaseEntity implements Serializable {
	
	@Column(length = 700, nullable = false)
	private String providerName;
	
	@Column(length = 70, nullable = false, unique = true)
	@Email
	private String providerMail;
	
	@Column(length = 700, nullable = false)
	private String password;
	
	@Column(length = 80, nullable = false)
	private String phone;
	
	@Column(length = 90, nullable = false)
	private String serviceType;
	
	@Column(length = 80, nullable = false)
	private String location;
	
	@Column(length = 80, nullable = false)
	private BigDecimal hourlyRate;
	
	@Column(length = 900)
	private String description;
	
	@Column
	private boolean availibility;
	
	
	
	

}
