package com.example.ecommerce.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.example.ecommerce.model.Manufacturer;
import com.example.ecommerce.model.Product;

public interface HomeService {
	
	public List<Manufacturer> getAllManufacturers();
	
	public List<Product> getListProduct(String key, List<Integer> manufacturer, List<Integer> price, List<Integer> pin,Pageable pageable);
	
	public Long countwithKeyManuPriPin(String key, List<Integer> manufactures, List<Integer> price, List<Integer> pins);
	
	public List<Integer> getAllId();

}
