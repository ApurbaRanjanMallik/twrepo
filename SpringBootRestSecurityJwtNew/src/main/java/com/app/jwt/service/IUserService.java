package com.app.jwt.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.app.jwt.entity.User;

public interface IUserService {

	public Integer saveUser(User user);
	public User findByUsername(String username);
	public UserDetails loadUserByUsername(String userName);
}
