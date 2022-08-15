package com.example.ecommerce.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.example.ecommerce.model.Customer;

public interface CustommerDao {
	public void addCustommer(Customer customer);
	
	public List<Customer> getAll();
	
	public Customer getCustomer(Integer id);
	
	public void updateCustomer(Customer customer);
	
	public void delete(Integer id);
	
	public List<Customer> getListCustomer(String key,Pageable pageable);
	
	public List<Customer> getListCustomer(Pageable pabPageable);
	
	public Long count();
    
    public Long countwithKey(String key);
}
