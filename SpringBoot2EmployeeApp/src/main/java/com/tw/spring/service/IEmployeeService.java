package com.tw.spring.service;

import java.util.List;

import com.tw.spring.model.Employee;

public interface IEmployeeService {
	Integer saveEmployee(Employee e);

	Employee getOneEmployee(Integer id);

	List<Employee> getAllEmployee();

	void updateEmployee(Employee e);

	void deleteEmployee(Integer id);
}
