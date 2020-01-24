package com.customer.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.command.AddCustomerCommand;
import com.customer.model.CustomerModel;
import com.domain.Customer;
import com.domain.factory.CustomerFactory;
import com.infrastructure.repository.CustomerRepository;

@Service
public class CustomerService {

	List<CustomerModel> customers = new ArrayList<CustomerModel>();

	CustomerFactory  customerFactory;
	CustomerRepository  	customerRepository;
	
	@Autowired
	public CustomerService(CustomerFactory  customerFactory, 
		   CustomerRepository  	customerRepository
			) {
		this.customerFactory = customerFactory;
		this.customerRepository = customerRepository;
	}

	public List<CustomerModel> getCustomers() {
		
		List<Customer> customers = customerRepository.findAll();
		
		CustomerModel m = new CustomerModel();
		List<CustomerModel> customerModel = new ArrayList<CustomerModel>();
		m.setName( customers.get(0).getName());
		
		customerModel.add(m);
		return customerModel;
	}
	
	public CustomerModel getCustomer(Long id) {
		return customers.get(id.intValue());
	}
		
	
	public CustomerModel addCustomer(AddCustomerCommand addCustomerCommand) {
		
		CustomerModel customerModel = null;
		Customer c = customerFactory.createCustomer(addCustomerCommand.getCustomerModel());
		customerRepository.save(c);
		
		return customerModel;
	} 
	
}
