package com.example.ecommerce.dao;

import com.example.ecommerce.model.Manufacturer;

import java.util.List;

public interface ManufacturerDao {
	
	public List<Manufacturer> getAllManufacturer();
	
	public List<Integer> getAllId();

}
