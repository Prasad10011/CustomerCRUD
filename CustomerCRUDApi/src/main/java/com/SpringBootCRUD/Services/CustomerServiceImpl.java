package com.SpringBootCRUD.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBootCRUD.CustomerRepo.CustomerRepo;
import com.SpringBootCRUD.DTO.CustomerDTO;
import com.SpringBootCRUD.DTO.CustomerSaveDTO;
import com.SpringBootCRUD.DTO.CustomerUpdateDTO;
import com.SpringBootCRUD.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public Customer addCustomer(CustomerSaveDTO customerSaveDTO) {
		Customer customer = new Customer(customerSaveDTO.getCustomerName(), customerSaveDTO.getCustomerAddress(),
				customerSaveDTO.getMobileNo());
		Customer save = customerRepo.save(customer);
		return save;
	}

	@Override
	public List<CustomerDTO> getAllCustomers() {
		List<Customer> customers = customerRepo.findAll();
		List<CustomerDTO> customersList = new ArrayList<CustomerDTO>();
		for (Customer customer : customers) {
			CustomerDTO customerDTO = new CustomerDTO(customer.getCustomerId(), customer.getCustomerName(),
					customer.getCustomerAddress(), customer.getMobileNo());
			customersList.add(customerDTO);
		}
		return customersList;
	}

	@Override
	public Customer updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
		if (customerRepo.existsById(customerUpdateDTO.getCustomerId())) {
			Customer customer = customerRepo.getById(customerUpdateDTO.getCustomerId());
			customer.setCustomerName(customerUpdateDTO.getCustomerName());
			customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
			customer.setMobileNo(customerUpdateDTO.getMobileNo());
			return customerRepo.save(customer);
		}
		return null;
	}

	@Override
	public String deleteCustomer(int id) {
		if (customerRepo.existsById(id)) {
			customerRepo.deleteById(id);
			return "success";
		} else {
			return null;
		}
	}

	@Override
	public CustomerDTO getCustomerById(int id) {
		Customer customer = customerRepo.getById(id);
		CustomerDTO customerDTO = new CustomerDTO(customer.getCustomerId(), customer.getCustomerName(),
				customer.getCustomerAddress(), customer.getMobileNo());
		return customerDTO;
	}

}
