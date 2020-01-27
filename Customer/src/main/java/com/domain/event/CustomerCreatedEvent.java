package com.domain.event;

import com.base.Event;
import com.domain.Customer;

public class CustomerCreatedEvent implements Event{

	private int id;
	private String eventDesc = "CustomerCreatedEvent";
	private Customer customer;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEventDesc() {
		return eventDesc;
	}
	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
}
