package com.example.ecommerce.service;

import java.util.List;

import com.example.ecommerce.model.Customer;
import com.example.ecommerce.model.Manufacturer;

public interface CustommerService {
	public void addcustommer(Customer customer);
	
	public List<Customer> getAllCustomer();
}
