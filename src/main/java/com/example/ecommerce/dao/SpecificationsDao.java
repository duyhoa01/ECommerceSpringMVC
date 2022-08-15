package com.example.ecommerce.dao;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.Specifications;

public interface SpecificationsDao {
	
	public void AddSpecifications(Specifications specifications);
	
	public Specifications getSpecifications(Integer id);
	
	public void updateSpecifications(Specifications specifications);
	
	public void updateSpecifications(Integer id,Specifications specifications);
}
