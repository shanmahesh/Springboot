package com.application.customer.model;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class CustomerModel {

	private Long id;
	private String name;
	private BigDecimal service;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getService() {
		return service;
	}
	public void setService(BigDecimal service) {
		this.service = service;
	}
	
	
	
}
