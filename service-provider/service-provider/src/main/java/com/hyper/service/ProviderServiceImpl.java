package com.hyper.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hyper.DTO.ProviderRequestDTO;
import com.hyper.DTO.ProviderResponseDTO;
import com.hyper.exception.ApiException;
import com.hyper.pojo.ApiResponse;
import com.hyper.pojo.ServiceProvider;
import com.hyper.repository.ServiceproviderRepository;

@Service
public class ProviderServiceImpl implements ProviderService {
	
	@Autowired
	private ServiceproviderRepository proservice;
	
	

	@Override
	public ApiResponse AddServiceProvider(ProviderRequestDTO prodto) {
	
		ServiceProvider serprovider = proservice.findByProviderMail(prodto.getProviderMail());
		if(serprovider != null) {
			return new ApiResponse("Service Provider with this email already exists!!");
		}
		
		ServiceProvider serviceprovider = new ServiceProvider();
		serviceprovider.setProviderName(prodto.getProviderName());
		serviceprovider.setProviderMail(prodto.getProviderMail());
		serviceprovider.setPhone(prodto.getPhone());
		serviceprovider.setAvailibility(true);
		serviceprovider.setPassword(new BCryptPasswordEncoder().encode(prodto.getPassword()));
		serviceprovider.setLocation(prodto.getLocation());
		serviceprovider.setDescription(prodto.getDescription());
		serviceprovider.setServiceType(prodto.getServiceType());
		serviceprovider.setHourlyRate(prodto.getHourlyRate());
		
		proservice.save(serviceprovider);
		return new ApiResponse("Service Provider is Registered!!");
	}
	
	private ProviderResponseDTO mapToDTO(ServiceProvider provider) {
		ProviderResponseDTO dto = new ProviderResponseDTO();
		dto.setProviderName(provider.getProviderName());
		dto.setServiceType(provider.getServiceType());
		dto.setAvailability(true);
		dto.setPhone(provider.getPhone());
		dto.setLocation(provider.getLocation());
		
		return dto;
	}

	@Override
	public List<ProviderResponseDTO> getAllServices() {
		List<ServiceProvider> servicepro = proservice.findAll();
		return servicepro.stream()
				.map(this::mapToDTO)
				.collect(Collectors.toList());
	}

	@Override
	public List<ProviderResponseDTO> searchServiceProviders(String serviceType, String Location) {
		List<ServiceProvider> serviceprovider = proservice.findByLocationIgnoreCaseAndServiceType(Location, serviceType);
		return serviceprovider.stream()
				.map(this::mapToDTO)
				.collect(Collectors.toList());
	}

	@Override
	public ProviderResponseDTO viewServiceproviderDetails(Long providerId) {
		ServiceProvider serviceprovider = proservice.findById(providerId).orElseThrow(() -> new ApiException("Service Provider is not Found!!"));
		ProviderResponseDTO prodto = new ProviderResponseDTO();
		
		prodto.setProviderName(serviceprovider.getProviderName());
		prodto.setServiceType(serviceprovider.getServiceType());
		prodto.setAvailability(true);
		prodto.setLocation(serviceprovider.getLocation());
		prodto.setHoulyRate(serviceprovider.getHourlyRate());
		prodto.setPhone(serviceprovider.getPhone());
		
		return prodto;
		
	}

	@Override
	public ProviderResponseDTO getProviderById(Long Providerid) {
		ServiceProvider provider = proservice.findById(Providerid).orElseThrow(() -> new ApiException("Service Provider Not Found!!"));
		ProviderResponseDTO prores = new ProviderResponseDTO();
		prores.setAvailability(true);
		prores.setHoulyRate(provider.getHourlyRate());
		prores.setLocation(prores.getLocation());
		prores.setPhone(prores.getLocation());
		prores.setProviderid(prores.getProviderid());
		prores.setProviderName(prores.getProviderName());
		prores.setServiceType(provider.getServiceType());
		
		return prores;
	}

}
