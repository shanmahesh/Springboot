package com.application.customer.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.customer.command.AddCustomerCommand;
import com.application.customer.model.CustomerModel;
import com.base.Event;
import com.base.EventEnvelope;
import com.domain.Customer;
import com.domain.event.CustomerCreatedEvent;
import com.domain.factory.CustomerFactory;
import com.infrastructure.repository.CustomerRepository;
import com.message.MessageConsumer;
import com.message.MessageProducer;
import com.readmodel.customer.dao.CustomerDao;
import com.readmodel.customer.dto.CustomerDto;

@Service
public class CustomerService {

	List<CustomerModel> customers = new ArrayList<CustomerModel>();

	CustomerFactory  customerFactory;
	CustomerRepository  	customerRepository;
	CustomerDao customerDao;
	
	@Autowired
	MessageProducer messageProducer;
	
	@Autowired
	MessageConsumer messageConsumer;  
	
	@Autowired
	public CustomerService(CustomerFactory  customerFactory, 
		   CustomerRepository  	customerRepository,
		   CustomerDao customerDao
			) {
		this.customerFactory = customerFactory;
		this.customerRepository = customerRepository;
		this.customerDao = customerDao;
	}

	public List<CustomerModel> getCustomers() {
		
		List<CustomerDto> customers = customerDao.findAll();
		
		List<CustomerModel> customerModels = new ArrayList<CustomerModel>();
		
		for(int i=0;i<customers.size();i++) {
			CustomerModel m = new CustomerModel();
			BeanUtils.copyProperties(customers.get(i), m);
			
			customerModels.add(m);
		}
		
		return customerModels;
	}
	
	public CustomerModel getCustomer(Long id) {
		return customers.get(id.intValue());
	}
		
	
	public CustomerModel addCustomer(AddCustomerCommand addCustomerCommand) {
		
		CustomerModel customerModel = null;
		Customer c = customerFactory.createCustomer(addCustomerCommand.getCustomerModel());
		customerRepository.save(c);
		
		CustomerCreatedEvent event = new CustomerCreatedEvent();
		
		event.setCustomer(c);
		
		messageProducer.Send(event);
		
		
		CustomerDto dto = new CustomerDto();
		BeanUtils.copyProperties(c, dto);
		customerDao.save(dto);
		
		return customerModel;
	} 
	
}
