package com.example.ecommerce.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ecommerce.dao.AdminDao;
import com.example.ecommerce.dao.ManufacturerDao;
import com.example.ecommerce.dao.ProductDao;
import com.example.ecommerce.dao.SpecificationsDao;
import com.example.ecommerce.dao.UserDao;
import com.example.ecommerce.dao.productDetailDao;
import com.example.ecommerce.model.Admin;
import com.example.ecommerce.model.Manufacturer;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.ProductDetail;
import com.example.ecommerce.model.User;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ManufacturerDao manufacturerDao;
	
	@Autowired
	private SpecificationsDao specificationsDao;
	
	@Autowired
	private productDetailDao productDetailDao;

	@Override
	public void addAdmin(Admin admin) {
		User user=admin.getUser();
		userDao.addUser(user);
		adminDao.addAdmin(admin);
	}
	
	@Override
	public List<Manufacturer> getAllManufacturer(){
		return manufacturerDao.getAllManufacturer();
	}

	@Override
	public void addProduct(Product product) {
		productDetailDao.addList(product.getProductDetails());
		specificationsDao.AddSpecifications(product.getSpecifications());
		productDao.addProduct(product);
	}

	@Override
	public List<Product> getAllProduct() {
		return productDao.getAllProduct();
	}

	@Override
	public Product getProductById(Integer id) {
		return productDao.getProductById(id);
	}

	@Override
	public void updateProduct(Product product) {
		Product p=productDao.getProductById(product.getId());
		productDetailDao.deleteListDetailByProduct(p);
		productDetailDao.addList(product.getProductDetails());
//		productDetailDao.UpdateList(product.getProductDetails());
		specificationsDao.updateSpecifications(p.getSpecifications().getId(),product.getSpecifications());
		productDao.updateProduct(product);
	}

	@Override
	public List<Product> getListProduct(String key,Pageable pageable) {
		return productDao.getListProduct(key,pageable);
	}

	@Override
	public List<Product> findAll(Pageable pageable) {
		return productDao.findAll(pageable);
	}

	@Override
	public Long countProducts() {
		return productDao.count();
	}

	@Override
	public Long countProductWithKey(String key) {
		return productDao.countwithKey(key);
	}

}
