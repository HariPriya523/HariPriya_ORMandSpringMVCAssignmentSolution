package com.greatlearning.customermanagement.service;

import java.util.List;
import com.greatlearning.customermanagement.entity.Customer;

public interface CustomerManagementService {

	public List<Customer> getCustomerList();

	public void deleteCustomerById(int id);
	
	public void saveCustomer(Customer customer);

	public Customer getCustomerById(int id);

}
