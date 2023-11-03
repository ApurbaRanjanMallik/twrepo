package com.springboot.junit.service;

import org.springframework.stereotype.Service;

import com.springboot.junit.model.User;

@Service
public class WelcomeServiceImpl implements WelcomeService {

	@Override
	public String getWelcomeMsg() {
		return "Welcome to Antra";
	}

	@Override
	public boolean addUser(User user) {
		// logic here
		return true;
	}

}
