package com.hyper.DTO;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProviderRequestDTO {

	private String providerName;
	private String providerMail;
	private String password;
	private String phone;
	private String description;
	private String serviceType;
	private boolean availability;
	public String Location;
	private BigDecimal hourlyRate;
	
}
