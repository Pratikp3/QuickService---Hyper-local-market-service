package com.hyper.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class ServiceRequestDTO {
	public String servicename;
	public String category;
	public String description;
	public boolean isApproved;
	public Double price;

}
