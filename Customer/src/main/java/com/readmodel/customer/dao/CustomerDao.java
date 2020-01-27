package com.readmodel.customer.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.readmodel.customer.dto.CustomerDto;

public interface CustomerDao extends MongoRepository<CustomerDto, Long>{
 
}
