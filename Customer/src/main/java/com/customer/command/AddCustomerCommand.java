package com.customer.command;

import com.customer.model.CustomerModel;

public class AddCustomerCommand {

	private CustomerModel customerModel;

	public CustomerModel getCustomerModel() {
		return customerModel;
	}

	public void setCustomerModel(CustomerModel customerModel) {
		this.customerModel = customerModel;
	}

	public AddCustomerCommand(CustomerModel customerModel) {
		super();
		this.customerModel = customerModel;
	}
	
	
	
	
}
