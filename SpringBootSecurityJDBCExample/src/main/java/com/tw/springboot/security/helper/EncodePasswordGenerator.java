package com.tw.springboot.security.helper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//@Component
public class EncodePasswordGenerator {
	//@Bean
	public static String getEncodePassword(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String decodePassword = passwordEncoder.encode(password);
		return decodePassword;
	}
}
