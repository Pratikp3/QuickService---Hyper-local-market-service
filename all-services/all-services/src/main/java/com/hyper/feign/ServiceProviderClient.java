package com.hyper.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.hyper.DTO.ProviderResponseDTO;

@FeignClient(name = "service-provider")
public interface ServiceProviderClient {
	
	@GetMapping("/api/provider/{providerid}")
	ProviderResponseDTO  getProviderById(Long providerid);

}
