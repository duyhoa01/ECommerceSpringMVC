package com.example.ecommerce.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.model.Staff;

@Repository
public class StaffDaoImpl implements StaffDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session currencySession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addStaff(Staff staff) {
		currencySession().save(staff);
	}

}
