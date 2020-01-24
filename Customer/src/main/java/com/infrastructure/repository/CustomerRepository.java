package com.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
