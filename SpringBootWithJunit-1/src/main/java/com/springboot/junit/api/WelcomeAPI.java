package com.springboot.junit.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.junit.model.User;
import com.springboot.junit.service.WelcomeService;

@RestController
@RequestMapping(value = "/api")
public class WelcomeAPI {

	@Autowired
	WelcomeService service;

	@GetMapping(value = "/welcome")
	public ResponseEntity<String> getWelcome() {
		String message = service.getWelcomeMsg();
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@PostMapping(value = "/user/add", consumes = "application/json")
	public ResponseEntity<String> addUser(@RequestBody User user) {
		boolean flag = service.addUser(user);
		if (flag) {
			return new ResponseEntity<>("User added", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("User not added", HttpStatus.BAD_REQUEST);
		}
	}
}
