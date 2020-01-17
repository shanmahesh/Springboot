package com.customer.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.customer.model.*;
import com.customer.service.CustomerService;

@RestController
public class CustomerApi {

	@Autowired
	CustomerService cusotmerService;
	
	@GetMapping("/customers")
	public List<CustomerModel> getCustomers() {
		return  cusotmerService.getCustomers();
	}
	
	@GetMapping("/customer/{id}")
	public CustomerModel getCustomer(@PathVariable("id") Long id) {
		return cusotmerService.getCustomer(id);
	}
	
}
