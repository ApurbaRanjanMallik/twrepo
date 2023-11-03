package com.tw.springboot.security.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.tw.springboot.security.helper.EncodePasswordGenerator;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
		security.authorizeHttpRequests(
				(requests) -> requests.antMatchers("/", "/home").permitAll().antMatchers("/admin").hasAuthority("ADMIN")
						.antMatchers("/customer").hasAuthority("CUSTOMER").anyRequest().authenticated())
				.formLogin((form) -> form.loginPage("/login").permitAll()).logout((logout) -> logout.permitAll());

		return security.build();

	}

	@Bean
	public UserDetailsService userDetailsService(DataSource source) {
		/*
		 * UserDetails user1 =
		 * User.builder().username("RAAM").password(generator.getEncodePassword("RAAM"))
		 * .authorities("ADMIN").build();
		 */

		/*
		 * UserDetails user2 =
		 * User.builder().username("HANUMAN").password(EncodePasswordGenerator.
		 * getEncodePassword("HANUMAN")) .authorities("CUSTOMER").build();
		 */

		UserDetails user3 = User.builder().username("LAXMAN").password(encoder().encode("HANUMAN"))
				.authorities("CUSTOMER2").build();

		JdbcUserDetailsManager users = new JdbcUserDetailsManager(source);
		// users.createUser(user1);
		// users.createUser(user2);
		users.createUser(user3);

		return users;
	}

}
