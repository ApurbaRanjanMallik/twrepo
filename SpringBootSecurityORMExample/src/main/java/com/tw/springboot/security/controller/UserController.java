package com.tw.springboot.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tw.springboot.security.entity.UserData;
import com.tw.springboot.security.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService service;
	//1. show Register page
	@GetMapping("/register")
	public String showReg() {
		return "userregistration";
	}
	//2. save user data
	@PostMapping("/save")
	public String saveUser(@ModelAttribute UserData userData, Model model) {
		Integer id=service.saveUser(userData);
		String message="User '"+id+"' created";
		model.addAttribute("message", message);
		return "userregistration";
		
	}
}
