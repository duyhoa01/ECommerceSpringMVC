package com.example.ecommerce.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.ProductDetail;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session currencySession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addProduct(Product product) {
		currencySession().save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		return currencySession().createQuery("from Product").list();
	}

	@Override
	public Product getProductById(Integer id) {
		try {
			return currencySession().get(Product.class, id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public void updateProduct(Product product) {
		Product newProduct=getProductById(product.getId());
		newProduct.setCount(product.getCount());
		newProduct.setDescription(product.getDescription());
		newProduct.setDiscount(product.getDiscount());
		newProduct.setManufacrurer(product.getManufacrurer());
		newProduct.setName(product.getName());
		newProduct.setRate(product.getRate());
		if(product.getImages().size()!=0) {
			newProduct.setImages(product.getImages());
		}
		
		currencySession().update(newProduct);
	}

	@Override
	public List<Product> getListProduct(String key,Pageable pageable) {
		return currencySession().createQuery("from Product p where p.name LIKE CONCAT('%',?1,'%')").setParameter(1, key)
								.setFirstResult((int) pageable.getOffset())
								.setMaxResults(pageable.getPageSize())
								.list();
	}

	@SuppressWarnings("unchecked")
	public List<Product> findAll(Pageable pageable) {
		return currencySession().createQuery("from Product")
				.setFirstResult((int) pageable.getOffset())
				.setMaxResults(pageable.getPageSize())
				.list();
	}

	@Override
	public Long count() {
		return  (Long) currencySession()
                .createQuery("select count(*) from Product").uniqueResult();
	}

	@Override
	public Long countwithKey(String key) {
		return  (Long) currencySession()
                .createQuery("select count(*) from Product p where p.name LIKE CONCAT('%',?1,'%')").setParameter(1, key).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<ProductDetail> getListProduct(String key, List<Integer> manufactures, List<Integer> price, int minPin,int maxPin,double minPrice, double maxPrice, Pageable pageable) {
		return  currencySession()
                .createQuery("select pd from Product p JOIN p.productDetails  pd  where p.name LIKE CONCAT('%',?1,'%') AND p.manufacrurer.id IN (:manufactures) AND p.specifications.dungLuongPin between :low and :high AND pd.price >= :minPrice AND pd.price <= :maxPrice")
                .setParameter(1, key).setParameter("manufactures", manufactures)
                .setParameter("low", minPin)
                .setParameter("high", maxPin)
                .setParameter("minPrice", minPrice)
                .setParameter("maxPrice", maxPrice)
                .setFirstResult((int) pageable.getOffset())
				.setMaxResults(pageable.getPageSize())
				.list();
		

	}

	@Override
	public Long countwithKeyManuPriPin(String key, List<Integer> manufactures, List<Integer> price,
			int minPin, int maxPin,double minPrice, double maxPrice) {
		return  (Long) currencySession()
                .createQuery("select count(*) from Product p JOIN p.productDetails pd where p.name LIKE CONCAT('%',?1,'%') AND p.manufacrurer.id IN (:manufactures) AND p.specifications.dungLuongPin between :low and :high AND pd.price >= :minPrice AND pd.price <= :maxPrice")
                .setParameter(1, key).setParameter("manufactures", manufactures)
                .setParameter("low", minPin)
                .setParameter("high", maxPin)
                .setParameter("minPrice", minPrice)
                .setParameter("maxPrice", maxPrice).uniqueResult();
                
	}

	

}
