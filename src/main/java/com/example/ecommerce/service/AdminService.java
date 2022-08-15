package com.example.ecommerce.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.ecommerce.model.Admin;
import com.example.ecommerce.model.Manufacturer;
import com.example.ecommerce.model.Product;

public interface AdminService {
	public void addAdmin(Admin admin);
	
	public List<Manufacturer> getAllManufacturer();
	
	public void addProduct(Product product);
	
	public List<Product> getAllProduct();
	
	public Product getProductById(Integer id);
	
	public void updateProduct(Product product);
	
	public List<Product> getListProduct(String key,Pageable pageable);
	
	public List<Product> findAll(Pageable pageable);
	
	public Long countProducts();
	
	public Long countProductWithKey(String key);
}
