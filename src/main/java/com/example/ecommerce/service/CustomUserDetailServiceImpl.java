package com.example.ecommerce.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.ecommerce.dao.UserDao;
import com.example.ecommerce.model.CustomUserDetails;
import com.example.ecommerce.model.User;

@Service
@Transactional
public class CustomUserDetailServiceImpl implements CustomUserDetailService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userDao.getUser(username);
		return new CustomUserDetails(user);
	}

}
