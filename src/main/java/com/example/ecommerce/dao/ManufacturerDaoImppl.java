package com.example.ecommerce.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.model.Manufacturer;

@Repository
public class ManufacturerDaoImppl implements ManufacturerDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session currencySession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Manufacturer> getAllManufacturer() {
		return currencySession().createQuery("from Manufacturer").list();
	}

	@Override
	public List<Integer> getAllId() {
		return currencySession().createQuery("select id from Manufacturer").list();
	}

}
