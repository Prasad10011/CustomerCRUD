package com.SpringBootCRUD.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.SpringBootCRUD.DTO.CustomerDTO;
import com.SpringBootCRUD.DTO.CustomerSaveDTO;
import com.SpringBootCRUD.DTO.CustomerUpdateDTO;
import com.SpringBootCRUD.entity.Customer;

public interface CustomerService {
	Customer addCustomer(CustomerSaveDTO customerSaveDTO);

	List<CustomerDTO> getAllCustomers();

	Customer updateCustomer(CustomerUpdateDTO customerUpdateDTO);

	String deleteCustomer(int id);

	CustomerDTO getCustomerById(int id);
}
