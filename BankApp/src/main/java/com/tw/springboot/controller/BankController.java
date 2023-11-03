package com.tw.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tw.springboot.entity.AccountDetails;
import com.tw.springboot.service.BankService;
import com.tw.springboot.service.UtilClass;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/bank")
@Api(description = "BANK APPLICATION")
public class BankController {

	@Autowired
	private BankService bankService;

	@PostMapping("/registration")
	@ApiOperation("Register")
	public ResponseEntity<String> saveAcHolder(@RequestBody AccountDetails accDet) {
		AccountDetails accDetails = bankService.userReg(accDet);
		String body = "User Saved " + accDetails.getAccNo();
		return ResponseEntity.ok(body);
	}

	@PostMapping("/logIn")
	@ApiOperation("Log In")
	public ResponseEntity<String> logInToApp(@RequestBody UtilClass utilclass) {
		String logIn = bankService.logIn(utilclass.getAccountNumber(), utilclass.getPassword());
		return ResponseEntity.ok(logIn);
	}

	@PutMapping("/deposit/{acNo}/{amount}")
	@ApiOperation("Deposit")
	public ResponseEntity<String> depositAmount(@PathVariable Long acNo, @PathVariable Double amount) {
		String depositBalance = bankService.deposit(acNo, amount);
		return ResponseEntity.ok(depositBalance);

	}

	@PutMapping("/withdraw/{acNo}/{amount}")
	@ApiOperation("Withdraw")
	public ResponseEntity<String> withdrawAmount(@PathVariable Long acNo, @PathVariable Double amount) {
		String withdrawBalance = bankService.withdraw(acNo, amount);
		return ResponseEntity.ok(withdrawBalance);

	}

	@GetMapping("/show/{id}")
	@ApiOperation("Balance Enquiry")
	public ResponseEntity<String> getBalance(@PathVariable Long id) {
		String showBalance = bankService.showBal(id);
		String response = showBalance;
		return ResponseEntity.ok(response);

	}

	@DeleteMapping("/delete/{id}")
	@ApiOperation("Delete Account")
	@ResponseStatus(value = HttpStatus.OK)
	public String deleteAccount(@PathVariable Long id) {
		String deleleteAccount = bankService.delete(id);
		return deleleteAccount;

	}

}
