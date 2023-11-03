package com.tw.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tw.spring.model.Employee;
import com.tw.spring.service.IEmployeeService;
@RestController
@RequestMapping("/employees")
public class EmployeeRestController {
	@Autowired
	private IEmployeeService service;
	
	//1.save
	@PostMapping("/save")
	public ResponseEntity<String> saveEmployee(
			@RequestBody Employee employee
			)
	{
		Integer id=service.saveEmployee(employee);
		return new ResponseEntity<String>(
				"Employee "+id+" saved",
				HttpStatus.OK);
	}
	//2.fetch one
	
	//3.fetch all
	
	//4.update
	
	//5.delete
}
