package com.example.ecommerce.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.example.ecommerce.model.Customer;
import com.example.ecommerce.model.Staff;

public interface StaffService {
	public void addStaff(Staff staff);
	
	public List<Customer> getAllCustomer();
	
	public Customer getCustomerById(Integer id);
	
	public void addcustommer(Customer customer);
	
	public void updateCustommer(Customer customer);
	
	public void deleteCustommer(Integer id);
	
	public List<Customer> getListCustomer(String key,Pageable pageable);
	
	public List<Customer> getListCustomer(Pageable pabPageable);
	
	public Long countCustomer();
    
    public Long countCustomerWithKey(String key);
}
