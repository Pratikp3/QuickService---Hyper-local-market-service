package com.hyper.service;

import java.util.List;

import com.hyper.DTO.ProviderRequestDTO;
import com.hyper.DTO.ProviderResponseDTO;
import com.hyper.pojo.ApiResponse;

public interface ProviderService {
	ApiResponse AddServiceProvider(ProviderRequestDTO prodto);
	public List<ProviderResponseDTO> getAllServices();
	public List<ProviderResponseDTO> searchServiceProviders(String serviceType, String Location);
	public ProviderResponseDTO viewServiceproviderDetails(Long providerId);
	public ProviderResponseDTO getProviderById(Long Providerid);

}
