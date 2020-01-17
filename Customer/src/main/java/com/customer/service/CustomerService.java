package com.customer.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.customer.model.CustomerModel;

@Service
public class CustomerService {

	List<CustomerModel> customers = new ArrayList<CustomerModel>();


	public List<CustomerModel> getCustomers() {
		
		CustomerModel model = new CustomerModel();
		model.setId(new Long(1));
		model.setName("Vin");
		model.setService(new BigDecimal(10.00));
		
		customers.add(model);
		
		model = new CustomerModel();
		model.setId(new Long(2));
		model.setName("John");
		model.setService(new BigDecimal(20.00));
		customers.add(model);
		
		model = new CustomerModel();
		model.setId(new Long(3));
		model.setName("Jim");
		model.setService(new BigDecimal(30.00));
		customers.add(model);
		
		return customers;
	}
	
	public CustomerModel getCustomer(Long id) {
		return customers.get(id.intValue());
	}
		
	
}
