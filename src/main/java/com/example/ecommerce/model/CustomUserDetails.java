package com.example.ecommerce.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.ecommerce.dao.UserDao;


public class CustomUserDetails implements UserDetails{
	
	User user;
	
	@Autowired
	private UserDao userDao;
	
	public CustomUserDetails(User domainUser) {
		this.user=domainUser;
	}
	
	public List<String> getRoles(Role role) {
		List<String> roles = new ArrayList<String>();
		
		roles.add(role.getRole());
		
		return roles;
	}
	
	public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles){
		List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
		
		for(String role:roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}

		return authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authList=getGrantedAuthorities(getRoles(user.getRole()));
		return authList;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
