package com.example.ecommerce.dao;

import com.example.ecommerce.model.Role;

public interface RoleDao {
	
	public Role getOrCreateRole(String role);

}
