package com.example.ecommerce.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.ecommerce.model.Product;

public interface ProductDao {

	public void addProduct(Product product);
	
	public List<Product> getAllProduct();
	
	public Product getProductById(Integer id);
	
	public void updateProduct(Product product);
	
	public List<Product> getListProduct(String key,Pageable pageable);
	
	public List<Product> findAll(Pageable pageable);
	
    public Long count();
    
    public Long countwithKey(String key);
    
    public List<Product> getListProduct(String key, List<Integer> manufactures, List<Integer> price, int minPin, int maxPin,Pageable pageable);
    
    public Long countwithKeyManuPriPin(String key, List<Integer> manufactures, List<Integer> price,int minPin, int maxPin );
}
