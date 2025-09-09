package com.hyper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyper.DTO.CustomerRequestDTO;
import com.hyper.DTO.CustomerResponseDTO;
import com.hyper.DTO.CustomerUpdateDTO;
import com.hyper.DTO.UserResponseDTO;
import com.hyper.customException.ApiException;
import com.hyper.feign.UserServiceClient;
import com.hyper.pojo.ApiResponse;
import com.hyper.pojo.Customer;
import com.hyper.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private UserServiceClient userclient;

	@Autowired
	private CustomerRepository custrepo;
	
	@Override
	public CustomerResponseDTO getCustomerprofile(Long customerId) {
		Customer cust = custrepo.findById(customerId).orElseThrow(() -> new ApiException("Customer  not Found!!"));
		UserResponseDTO userdata =  userclient.getUserById(customerId);
		CustomerResponseDTO custdto = new CustomerResponseDTO();
		custdto.setFullName(userdata.getUsername());
		custdto.setAddress(userdata.getAddress());
		custdto.setEmail(userdata.getEmail());
		custdto.setPhone(userdata.getContact());
		
		custdto.setCity(cust.getCity());
		custdto.setSpecificAddress(cust.getSpecificAddress());
		custdto.setState(cust.getState());
		
		return custdto;
	}

	@Override
	public ApiResponse updateCustomerProfile(Long customerId, CustomerUpdateDTO custdto) {
		Customer customer = custrepo.findById(customerId).orElseThrow(() -> new ApiException("Customer Not Found!!"));
		UserResponseDTO userdata = userclient.getUserById(customerId);
		
		customer.setCity(custdto.getCity());
		customer.setSpecificAddress(custdto.getSpecificaddress());
		customer.setState(custdto.getState());
		
//		userdata.setAddress(custdto.getAddress());
//		userdata.setContact(custdto.getPhone());
//		userdata.setUsername(custdto.getFullName());
//		userdata.setEmail(custdto.getEmail());
		
		custrepo.save(customer);
		
		

		return new ApiResponse("Customer Updated Successfully!!");
		
	}

	@Override
	public ApiResponse deleteCustomerAccount(Long customerId) {
		Customer cust = custrepo.findById(customerId).orElseThrow(() -> new ApiException("Customer Not found"));
		custrepo.delete(cust);
		return new ApiResponse("Customer is Deleted");
	}

	@Override
	public ApiResponse addCustomer(CustomerRequestDTO custdto) {
		
		UserResponseDTO user = userclient.getUserByMail(custdto.getUserEmail());
		Customer cust = new Customer();
		cust.setCity(custdto.getCity());
		cust.setSpecificAddress(custdto.getSpecificAddress());
		cust.setState(custdto.getState());
		cust.setUserId(user.getId());
		custrepo.save(cust);
		return new ApiResponse("Customer has added!!");
	}

}
