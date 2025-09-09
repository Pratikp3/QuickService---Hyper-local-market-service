package com.hyper.service;

import com.hyper.DTO.CustomerRequestDTO;
import com.hyper.DTO.CustomerResponseDTO;
import com.hyper.DTO.CustomerUpdateDTO;
import com.hyper.pojo.ApiResponse;

public interface CustomerService {
	public CustomerResponseDTO getCustomerprofile(Long customerId);
	public ApiResponse updateCustomerProfile(Long customerId, CustomerUpdateDTO custdto);
	public ApiResponse deleteCustomerAccount(Long customerId);
	public ApiResponse addCustomer(CustomerRequestDTO custdto);

}
