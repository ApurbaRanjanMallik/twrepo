package com.tw.springboot.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private UserDetailsService service;

	@Bean
	public AuthenticationManager manager(AuthenticationConfiguration authConfig) throws Exception {

		return authConfig.getAuthenticationManager();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder);
		provider.setUserDetailsService(service);
		return provider;
	}

	@Bean
	public SecurityFilterChain configureAuth(HttpSecurity security) throws Exception {
		security.authorizeHttpRequests(request -> request.antMatchers("/home", "/", "/user/**").permitAll()
				.antMatchers("/admin").hasAuthority("ADMIN").antMatchers("/customer").hasAuthority("CUSTOMER")
				.anyRequest().authenticated())
				.formLogin(form -> form.loginPage("/login").permitAll().defaultSuccessUrl("/hello", true))
				.logout(logout -> logout.permitAll());
		return security.build();

	}

}
