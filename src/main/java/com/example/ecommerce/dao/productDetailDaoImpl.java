package com.example.ecommerce.dao;

import java.util.List;

import javax.persistence.criteria.From;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.ProductDetail;

@Repository
public class productDetailDaoImpl implements productDetailDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session currencySession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addList(List<ProductDetail> productDetails) {
		for (ProductDetail productDetail : productDetails) {
			currencySession().save(productDetail);	
		}
	}

	@Override
	public void UpdateList(List<ProductDetail> productDetails) {
		for (ProductDetail productDetail : productDetails) {
			ProductDetail newProductDetail=getProductDetail(productDetail.getId());
			newProductDetail.setPrice(productDetail.getPrice());
			newProductDetail.setProduct(productDetail.getProduct());
			newProductDetail.setRam(productDetail.getRam());
			currencySession().update(newProductDetail);	
		}
	}

	@Override
	public ProductDetail getProductDetail(Integer id) {
		return currencySession().get(ProductDetail.class, id);
	}

	@Override
	public void deleteListDetailByProduct(Product product) {
		List<ProductDetail> productDetails=product.getProductDetails();
		for (ProductDetail productDetail : productDetails) {
			currencySession().delete(getProductDetail(productDetail.getId()));
		}
	}

}
