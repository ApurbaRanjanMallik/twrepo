package com.tw.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;

@Entity
@Table(name = "AccountDetails")
@Data
@Component
public class AccountDetails {
	@Column(name="user_name")
	private String userName;
	@Id
	@Column(name="account_no")
	private Long accNo;
	@Column(name="user_password")
	private String password;
	@Column(name="avl_balance")
	private Double avlBalance;
	
}
