package com.springboot.junit.service;

import com.springboot.junit.model.User;

public interface WelcomeService {

	String getWelcomeMsg();

	boolean addUser(User user);

}
