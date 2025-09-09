package com.hyper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hyper.DTO.ProviderRequestDTO;
import com.hyper.DTO.ProviderResponseDTO;
import com.hyper.pojo.ApiResponse;
import com.hyper.service.ProviderService;

@RestController
@RequestMapping("/api/provider")
public class ServiceProviderController {
	
	@Autowired
	private ProviderService proservice;
	
	@GetMapping("/test")
	public String test() {
	    return "Controller is working";
	}
	
	@GetMapping("/{providerid}")
	public ProviderResponseDTO getProviderById(Long providerid) {
		return proservice.getProviderById(providerid);
		
	}
	
	@PostMapping("/Registration")
	public ResponseEntity<ApiResponse> AddServiceProvider(@RequestBody ProviderRequestDTO prodto){
		System.out.println("Name: " + prodto.getProviderName());
		return ResponseEntity.ok(proservice.AddServiceProvider(prodto));
	}
	
	@GetMapping("/get-all-services")
	public ResponseEntity<List<ProviderResponseDTO>> getAllServices(){
		return ResponseEntity.ok(proservice.getAllServices());
	}
	
	@GetMapping("/search-service-providers")
	public ResponseEntity<List<ProviderResponseDTO>> searchServiceProviders(@RequestParam String ServiceType, @RequestParam String Location){
		return ResponseEntity.ok(proservice.searchServiceProviders(ServiceType, Location));
	}
	
	public ResponseEntity<ProviderResponseDTO> viewServiceProviderDetails(@PathVariable Long providerid){
		return ResponseEntity.ok(proservice.viewServiceproviderDetails(providerid));
	}

}
