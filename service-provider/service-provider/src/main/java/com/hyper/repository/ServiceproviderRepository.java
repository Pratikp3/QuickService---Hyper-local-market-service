package com.hyper.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hyper.pojo.ServiceProvider;

@Repository
public interface ServiceproviderRepository extends JpaRepository<ServiceProvider, Long> {
	ServiceProvider findByProviderMail(String ProviderMail);
	List<ServiceProvider> findByLocationIgnoreCaseAndServiceType(String location, String serviceType);
	
}
