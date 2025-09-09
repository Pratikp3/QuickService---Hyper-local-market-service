package com.hyper.DTO;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProviderResponseDTO {
	
	public Long providerid;
	public String providerName;
	public String phone;
	public String serviceType;
	public String location;
	public boolean availability;
	public BigDecimal houlyRate;

}
