package com.tw.springboot.security.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tw.springboot.security.entity.UserData;
import com.tw.springboot.security.service.IUserService;
import com.tw.springboot.security.service.repo.UserRepository;
@Service
public class UserServiceIMPL implements IUserService, UserDetailsService {

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private UserRepository repository;

	@Override
	public Integer saveUser(UserData userData) {
		String encPwd = encoder.encode(userData.getUserPwd());
		userData.setUserPwd(encPwd);
		return repository.save(userData).getUserId();
	}

	@Override
	public Optional<UserData> getOneUser(Integer id) {
		return repository.findById(id);
	}

	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		Optional<UserData> optional = repository.findByUserEmail(userName);
		if (optional.isEmpty()) {
			throw new UsernameNotFoundException(userName + " not exist");
		}
		UserData userData = optional.get();
		List<GrantedAuthority> authorities = userData.getUserRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList());
		return new org.springframework.security.core.userdetails.User(userName, userData.getUserPwd(), authorities);
	}

}
