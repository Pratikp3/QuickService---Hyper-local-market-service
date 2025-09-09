package com.hyper.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hyper.pojo.Services;

@Repository
public interface ServiceRepository extends JpaRepository<Services, Long> {

	List<Services> findByCategoryIgnoreCase(String category);
	List<Services> findByServicename(String servicename);
	void deleteByServicename(String servicename);
}
