package com.tw.springboot.security.service;

import java.util.Optional;

import com.tw.springboot.security.entity.UserData;

public interface IUserService {

	Integer saveUser(UserData userData);

	Optional<UserData> getOneUser(Integer id);

}
