package com.example.ecommerce.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.model.Customer;
import com.example.ecommerce.model.Product;

@Repository
public class CustommerDaoImpl implements CustommerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session currencySession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addCustommer(Customer customer) {
		currencySession().save(customer);
	}

	@Override
	public List<Customer> getAll() {
		return currencySession().createQuery("from Customer").list();
	}

	@Override
	public Customer getCustomer(Integer id) {
		try {
			return currencySession().get(Customer.class, id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public void updateCustomer(Customer customer) {
		Customer newCustomer=getCustomer(customer.getId());
		newCustomer.setUser(customer.getUser());
		currencySession().update(newCustomer);
	}

	@Override
	public void delete(Integer id) {
		Customer customer=getCustomer(id);
		if (customer != null) {
			currencySession().delete(customer);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Customer> getListCustomer(String key, Pageable pageable) {
		return currencySession().createQuery("from Customer c where c.user.lastName LIKE CONCAT('%',?1,'%')").setParameter(1, key)
				.setFirstResult((int) pageable.getOffset())
				.setMaxResults(pageable.getPageSize())
				.list();
	}

	@SuppressWarnings("unchecked")
	public List<Customer> getListCustomer(Pageable pageable) {
		return currencySession().createQuery("from Customer")
				.setFirstResult((int) pageable.getOffset())
				.setMaxResults(pageable.getPageSize())
				.list();
	}

	@Override
	public Long count() {
		return  (Long) currencySession()
                .createQuery("select count(*) from Customer").uniqueResult();
	}

	@Override
	public Long countwithKey(String key) {
		return  (Long) currencySession()
                .createQuery("select count(*) from Customer c where c.user.lastName LIKE CONCAT('%',?1,'%')").setParameter(1, key).uniqueResult();
	}
	
	

}
