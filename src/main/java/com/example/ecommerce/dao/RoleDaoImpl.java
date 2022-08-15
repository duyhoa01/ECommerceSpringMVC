package com.example.ecommerce.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.model.Role;
import com.example.ecommerce.model.User;

@Repository
public class RoleDaoImpl implements RoleDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session currencySession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Role getOrCreateRole(String role) {
		role="ROLE_"+role;
		List<Role> roles=currencySession().createQuery("from Role r where r.role = :role").setParameter("role", role).list();
		if(roles ==null || roles.isEmpty()) {
			Role r=new Role();
			r.setRole("ROLE_"+role);
			currencySession().save(r);
			return r;
		}
		return roles.get(0);
	}

}
