package com.app.jwt.service.impl;

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

import com.app.jwt.entity.User;
import com.app.jwt.repository.UserRepository;
import com.app.jwt.service.IUserService;

@Service
public class UserServiceImpl implements IUserService, UserDetailsService {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;

	public Integer saveUser(User user) {
		user.setPassword(pwdEncoder.encode(user.getPassword()));
		return repository.save(user).getId();
	}

	public User findByUsername(String username) {
		Optional<User> user = repository.findByUsername(username);
		if (user.isPresent())
			return user.get();
		return null;
	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = findByUsername(username);
		if (user == null)
			throw new UsernameNotFoundException(
					new StringBuffer().append("User name ").append(username).append(" not found!").toString());

		List<GrantedAuthority> authorities = user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role))
				.collect(Collectors.toList());

		return new org.springframework.security.core.userdetails.User(username, user.getPassword(), authorities);
	}

}
