package com.hyper.service;

import java.util.List;

import com.hyper.DTO.ServiceRequestDTO;
import com.hyper.DTO.ServiceResponseDTO;
import com.hyper.pojo.ApiResponse;

public interface ServicesI {
	public ApiResponse addService(ServiceRequestDTO servdto,Long providerid);
	public List<ServiceResponseDTO> getListOfServices();
	public List<ServiceResponseDTO> getServicesByCategory(String category);
	public ApiResponse DeleteService(Long serviceid);
	public List<ServiceResponseDTO> getServiceByServiceName(String servicename);
	public ApiResponse DeleteByServiceName(String servicename);

}