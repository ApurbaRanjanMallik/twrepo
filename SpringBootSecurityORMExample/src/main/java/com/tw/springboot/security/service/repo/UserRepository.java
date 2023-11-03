package com.tw.springboot.security.service.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tw.springboot.security.entity.UserData;

public interface UserRepository extends JpaRepository<UserData, Integer> {
	Optional<UserData> findByUserEmail(String userEmail);
}
