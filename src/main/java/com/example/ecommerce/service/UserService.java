package com.example.ecommerce.service;

import com.example.ecommerce.model.User;

public interface UserService {
	public User getUser(String username);
	
	public void addUser(User user);
}
