package com.example.ecommerce.dao;

import com.example.ecommerce.model.User;

public interface UserDao {
	public User getUser(String username);
	
	public void addUser(User user);
	
	public void updateUser(User user);
	
	public User getUserById(Integer id);
	
	public void delete(Integer id);
}
