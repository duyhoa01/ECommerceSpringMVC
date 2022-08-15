package com.example.ecommerce.service;

import com.example.ecommerce.model.Role;

public interface RoleService {
	public Role getOrCreateRole(String role);
}
