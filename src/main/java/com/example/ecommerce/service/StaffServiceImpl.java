package com.example.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ecommerce.dao.CustommerDao;
import com.example.ecommerce.dao.StaffDao;
import com.example.ecommerce.dao.UserDao;
import com.example.ecommerce.model.Customer;
import com.example.ecommerce.model.Staff;
import com.example.ecommerce.model.User;

@Service
@Transactional
public class StaffServiceImpl implements StaffService {
	
	@Autowired
	private StaffDao staffDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CustommerDao custommerDao;

	@Override
	public void addStaff(Staff staff) {
		User user=staff.getUser();
		userDao.addUser(user);
		staffDao.addStaff(staff);
	}
	
	@Override
	public List<Customer> getAllCustomer() {
		return custommerDao.getAll();
	}

	@Override
	public Customer getCustomerById(Integer id) {
		return custommerDao.getCustomer(id);
	}

	@Override
	public void addcustommer(Customer customer) {
		User user=customer.getUser();
		userDao.addUser(user);
		custommerDao.addCustommer(customer);
	}

	@Override
	public void updateCustommer(Customer customer) {
		userDao.updateUser(customer.getUser());
		custommerDao.updateCustomer(customer);
	}

	@Override
	public void deleteCustommer(Integer id) {
		userDao.delete(custommerDao.getCustomer(id).getUser().getId());
		custommerDao.delete(id);
	}

	@Override
	public List<Customer> getListCustomer(String key, Pageable pageable) {
		return custommerDao.getListCustomer(key, pageable);
	}

	@Override
	public List<Customer> getListCustomer(Pageable pabPageable) {
		return custommerDao.getListCustomer(pabPageable);
	}

	@Override
	public Long countCustomer() {
		return custommerDao.count();
	}

	@Override
	public Long countCustomerWithKey(String key) {
		return custommerDao.countwithKey(key);
	}

}
