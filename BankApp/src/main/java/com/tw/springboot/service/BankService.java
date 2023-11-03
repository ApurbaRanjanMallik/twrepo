package com.tw.springboot.service;

import com.tw.springboot.entity.AccountDetails;

public interface BankService {

	public AccountDetails userReg(AccountDetails accDet);

	public String logIn(Long accNo, String password);

	public String showBal(Long accNo);

	public String deposit(Long accNo, Double amount);

	public String withdraw(Long accNo, Double amount);
	
	public String delete(Long accNo);

}
