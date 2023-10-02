package com.SpringBootCRUD.CustomerController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootCRUD.DTO.CustomerDTO;
import com.SpringBootCRUD.DTO.CustomerSaveDTO;
import com.SpringBootCRUD.DTO.CustomerUpdateDTO;
import com.SpringBootCRUD.Services.CustomerService;
import com.SpringBootCRUD.entity.ApiResponse;
import com.SpringBootCRUD.entity.Customer;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	// add Customer
	@PostMapping(path = "/save")
	public ResponseEntity<ApiResponse> saveCustomer(@RequestBody CustomerSaveDTO customerSaveDTO) {
		try {
			Customer customer = customerService.addCustomer(customerSaveDTO);
			// If the update is successful
			if (customer != null) {
				return ResponseEntity.ok().body(new ApiResponse(true, "Added successful"));
			} else {
				return ResponseEntity.ok().body(new ApiResponse(false, "Customer not added"));
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponse(false, "An error occurred"));
		}
	}

	// Get all customers
	@GetMapping(path = "/getAllCustomers")
	public ResponseEntity<ApiResponse> getAllCustomers() {

		try {
			List<CustomerDTO> customers = customerService.getAllCustomers();
			// If the update is successful
			if (customers != null) {
				return ResponseEntity.ok().body(new ApiResponse(true, "success", customers));
			} else {
				return ResponseEntity.ok().body(new ApiResponse(false, "Customers not found"));
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponse(false, "An error occurred"));
		}
	}

	// Get customer by id
	@GetMapping(path = "/getCustomerById/{id}")
	public ResponseEntity<ApiResponse> getCustomerById(@PathVariable(value = "id") int id) {

//		CustomerDTO customer = customerService.getCustomerById(id);
//		return customer;
		try {
			CustomerDTO customer = customerService.getCustomerById(id);
			// If the update is successful
			if (customer != null) {
				return ResponseEntity.ok().body(new ApiResponse(true, "success", customer));
			} else {
				return ResponseEntity.ok().body(new ApiResponse(false, "customer not found"));
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponse(false, "An error occurred"));
		}
	}

	@PutMapping(path = "/update")
	public ResponseEntity<ApiResponse> updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO) {

		try {
			Customer customer = customerService.updateCustomer(customerUpdateDTO);
			// If the update is successful
			if (customer != null) {
				return ResponseEntity.ok().body(new ApiResponse(true, "Update successful"));
			} else {
				return ResponseEntity.ok().body(new ApiResponse(false, "Update not successful"));
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponse(false, "An error occurred"));
		}
	}

	// Delete customer by Id
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ApiResponse> deleteCustomer(@PathVariable(value = "id") int id) {

		try {
			String result = customerService.deleteCustomer(id);
			// If the update is successful
			if (result == "success") {
				return ResponseEntity.ok().body(new ApiResponse(true, "deleted successful"));
			} else {
				return ResponseEntity.ok().body(new ApiResponse(false, "deletion not successful"));
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponse(false, "An error occurred"));

		}
	}
}
