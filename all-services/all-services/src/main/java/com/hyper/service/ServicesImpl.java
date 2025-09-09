package com.hyper.service;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyper.DTO.ProviderResponseDTO;
import com.hyper.DTO.ServiceRequestDTO;
import com.hyper.DTO.ServiceResponseDTO;
import com.hyper.Exception.ApiException;
import com.hyper.feign.ServiceProviderClient;
import com.hyper.pojo.ApiResponse;
import com.hyper.pojo.Services;
import com.hyper.repository.ServiceRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ServicesImpl implements ServicesI {
	
	@Autowired
	private ServiceRepository serepo;
	
	@Autowired
	private ServiceProviderClient serviceclient;
	

	@Override
	public ApiResponse addService(ServiceRequestDTO servdto, Long providerId) {
		ProviderResponseDTO Provider = serviceclient.getProviderById(providerId);
		Services service = new Services();
		service.setServicename(servdto.getServicename());
		service.setPrice(servdto.getPrice());
		service.setApproved(true);
		service.setDescription(servdto.getDescription());
		service.setCategory(servdto.getCategory());
		service.setProviderid(providerId);
		
		serepo.save(service);
		return new ApiResponse("Your Service is Added!!");
	}

	@Override
	public List<ServiceResponseDTO> getListOfServices() {
		
		List<Services> AllServices = serepo.findAll();
		return AllServices.stream()
				.map(this::ConverToDTO)
				.collect(Collectors.toList());
		
	}
	
	private ServiceResponseDTO ConverToDTO(Services service) {
		ServiceResponseDTO seresponse = new ServiceResponseDTO();
		seresponse.setApproved(true);
		seresponse.setCategory(service.getCategory());
		seresponse.setDescription(service.getDescription());
		seresponse.setPrice(service.getPrice());
		seresponse.setServicename(service.getServicename());
		seresponse.setProviderid(service.getUserId());
		
		return seresponse;
		
	}

	@Override
	public List<ServiceResponseDTO> getServicesByCategory(String category) {
		List<Services> services = serepo.findByCategoryIgnoreCase(category);
		return services.stream()
				.map(this::ConverToDTO)
				.collect(Collectors.toList());
	}

	@Override
	public ApiResponse DeleteService(Long serviceid) {
		Services ser = serepo.findById(serviceid).orElseThrow(() -> new ApiException("No Service Exists!"));
		serepo.delete(ser);
		return new ApiResponse("Service is Deleted!!");
	}

	@Override
	public List<ServiceResponseDTO> getServiceByServiceName(String servicename) {
		List<Services> AllServicesByName = serepo.findByServicename(servicename);
		return AllServicesByName.stream()
				.map(this::ConverToDTO)
				.collect(Collectors.toList());
	}

	@Override
	public ApiResponse DeleteByServiceName(String servicename) {
		serepo.deleteByServicename(servicename);
		return new ApiResponse("Service is Deleted!!");
	}
	

}
