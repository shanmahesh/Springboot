package com.readmodel.customer.dto;

import java.math.BigDecimal;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customers")
public class CustomerDto {
	@Id
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
