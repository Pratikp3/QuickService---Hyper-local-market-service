package com.hyper.DTO;

import lombok.Data;

@Data
public class ServiceResponseDTO {
	private String servicename;
	private String category;
	private String description;
	private boolean isApproved;
	private double price;
	private Long providerid;

}
