package com.example.ecommerce.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session currencySession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public User getUser(String username) {
		List<User> users=currencySession().createQuery("from User u where u.username = :userName").setParameter("userName", username).list();
		if(users.size()>0) {
			return users.get(0);
		}
		return null;
	}

	@Override
	public void addUser(User user) {
		currencySession().save(user);
	}

	@Override
	public void updateUser(User user) {
		User newUser=getUserById(user.getId());
		newUser.setAddress(user.getAddress());
		newUser.setEmail(user.getEmail());
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setPhone(user.getPhone());
		if (user.getImage()!=null) {
			newUser.setImage(user.getImage());
		}
		
		currencySession().update(newUser);
	}

	@Override
	public User getUserById(Integer id) {
		return currencySession().get(User.class, id);
	}

	@Override
	public void delete(Integer id) {
		User user=getUserById(id);
		if (user!=null) {
			currencySession().delete(user);
		}
	}

}
