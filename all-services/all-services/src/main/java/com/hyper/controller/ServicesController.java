package com.hyper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hyper.DTO.ServiceRequestDTO;
import com.hyper.DTO.ServiceResponseDTO;
import com.hyper.pojo.ApiResponse;
import com.hyper.service.ServicesI;

@RestController
@RequestMapping("/api/services")
public class ServicesController {
	
	@Autowired
	private ServicesI serv;
	
	@PostMapping("/add-service/{ProviderId}")
	public ResponseEntity<ApiResponse> addService(@RequestBody ServiceRequestDTO servdto, @PathVariable Long ProviderId){
		return ResponseEntity.ok(serv.addService(servdto, ProviderId));
		
	}
	
	@GetMapping("/get-All-Services")
	public ResponseEntity<List<ServiceResponseDTO>> getAllServices(){
		return ResponseEntity.ok(serv.getListOfServices());
	}
	
	@GetMapping("/Get-Service-ByCategory")
	public ResponseEntity<List<ServiceResponseDTO>> getServicesByCategory(@RequestParam String Category){
		return ResponseEntity.ok(serv.getListOfServices());
	}
	
	@DeleteMapping("/Delete-Service/{serviceid}")
	public ResponseEntity<ApiResponse> deleService(@PathVariable Long ServiceId){
		return ResponseEntity.ok(serv.DeleteService(ServiceId));
		
	}
	
	@DeleteMapping("/Delete-Service-ByName")
	public ResponseEntity<ApiResponse> DeleteServiceByName(@RequestParam String ServiceName){
		return ResponseEntity.ok(serv.DeleteByServiceName(ServiceName));
	}
	
	@GetMapping("/Get-Service-By-ServiceName")
	public ResponseEntity<List<ServiceResponseDTO>> getServiceByName(@RequestParam String ServiceName){
		return ResponseEntity.ok(serv.getServiceByServiceName(ServiceName));
	}
	
	

}
