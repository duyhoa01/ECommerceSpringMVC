package com.example.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ecommerce.dao.CustommerDao;
import com.example.ecommerce.dao.UserDao;
import com.example.ecommerce.model.Customer;
import com.example.ecommerce.model.Manufacturer;
import com.example.ecommerce.model.User;

@Service
@Transactional
public class CustommerServiceImpl implements CustommerService {
	
	@Autowired
	private CustommerDao custommerDao;
	
	@Autowired
	private UserDao userDao;
	

	@Override
	public void addcustommer(Customer customer) {
		User user=customer.getUser();
		userDao.addUser(user);
		custommerDao.addCustommer(customer);
	}

	@Override
	public List<Customer> getAllCustomer() {
		return custommerDao.getAll();
	}

}
