package com.customer.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customer.command.AddCustomerCommand;
import com.customer.model.*;
import com.customer.service.CustomerService;
@CrossOrigin(value="http://localhost:4200")
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
	
	@PostMapping("/addCustomer")
	public CustomerModel addCustomer(@RequestBody CustomerModel customerModel) {
		AddCustomerCommand addCustomerCommand = new  AddCustomerCommand(customerModel); 
		return cusotmerService.addCustomer(addCustomerCommand);
	}
	
	
	
}
