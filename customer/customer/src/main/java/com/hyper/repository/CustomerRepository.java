package com.hyper.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hyper.pojo.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{


}
