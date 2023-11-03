package com.tw.springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tw.springboot.entity.AccountDetails;
import com.tw.springboot.repository.AccountsRepository;

@Service
public class BankServiceImpl implements BankService {

	@Autowired
	private AccountsRepository accRepo;

	@Override
	public AccountDetails userReg(AccountDetails accDet) {
		AccountDetails accData = accRepo.save(accDet);
		return accData;
	}

	@Override
	public String logIn(Long accNo, String password) {
		Optional<AccountDetails> findById = accRepo.findById(accNo);
		AccountDetails accountDetails = findById.get();
		Long accNo1 = accountDetails.getAccNo();
		String password2 = accountDetails.getPassword();
		if (accNo == accNo1 && password2.equals(password)) {
			return "Welcome To Bank";
		} else {
			return "Incorrect Details";
		}

	}

	@Override
	public String showBal(Long accNo) {
		Optional<AccountDetails> identity = accRepo.findById(accNo);
		AccountDetails accDetail = identity.get();
		Double balance = accDetail.getAvlBalance();
		return "Your Account balance is RS: " + balance;
	}

	@Override
	public String deposit(Long accNo, Double amount) {
		if (amount > 0.0) {
			Optional<AccountDetails> identity = accRepo.findById(accNo);
			AccountDetails accDetail = identity.get();
			Double balance = accDetail.getAvlBalance();
			balance = balance + amount;
			accDetail.setAvlBalance(balance);
			accRepo.save(accDetail);
			return "Money of amount RS: " + amount + " dipositted in your account";
		} else {
			return "Please enter valid amount";
		}
	}

	@Override
	public String withdraw(Long accNo, Double amount) {
		if (amount > 0.0) {
			Optional<AccountDetails> identity = accRepo.findById(accNo);
			AccountDetails accDetails = identity.get();
			Double balance = accDetails.getAvlBalance();
			if (amount <= balance) {
				balance = balance - amount;
				accDetails.setAvlBalance(balance);
				accRepo.save(accDetails);
				return "Money of amount RS:" + amount + " has withdrawn from your account";
			} else {
				return "Insufficient balance";
			}
		} else {
			return "Please enter valid amount";
		}
	}

	@Override
	public String delete(Long accNo) {
		if (accRepo.existsById(accNo)) {
			accRepo.deleteById(accNo);
			return "deleted user with " + accNo;
		}
		return "Please provide valid account number";

	}

}
