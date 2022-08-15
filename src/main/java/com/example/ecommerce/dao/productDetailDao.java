package com.example.ecommerce.dao;

import java.util.List;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.ProductDetail;

public interface productDetailDao {
	
	public void addList(List<ProductDetail> productDetails);
	
	public void UpdateList(List<ProductDetail> productDetails);
	
	public ProductDetail getProductDetail(Integer id);
	
	public void deleteListDetailByProduct(Product product);

}
