package com.tw.springboot.service;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class UtilClass{
	private Long accountNumber;
	private String password;

}
