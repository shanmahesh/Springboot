package com.domain.factory;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.customer.model.CustomerModel;
import com.domain.Customer;

@Component
public class CustomerFactory {

	public Customer createCustomer(CustomerModel cusotmerModel) {
		
		Customer customer = new Customer();
		BeanUtils.copyProperties(cusotmerModel, customer);
		return customer;
	}
	
	public Customer createCustomer() {
		Customer customer = new Customer();
		return customer;
	}
	
	
}
