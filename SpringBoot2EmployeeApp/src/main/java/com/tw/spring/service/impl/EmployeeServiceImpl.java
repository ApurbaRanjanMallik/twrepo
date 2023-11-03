package com.tw.spring.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tw.spring.EmployeeRepository;
import com.tw.spring.exception.EmployeeNotFoundException;
import com.tw.spring.model.Employee;
import com.tw.spring.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private EmployeeRepository repo;

	@Override
	public Integer saveEmployee(Employee e) {
		Integer id=repo.save(e).getEmpId();
		return id;
	}

	@Override
	public Employee getOneEmployee(Integer id) {
		Optional<Employee>opt=repo.findById(id);
		Employee emp=opt.orElseThrow(
				()->new EmployeeNotFoundException("Employee doesn't exist")
				);
		return emp;
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> list=repo.findAll();
		return null;
	}

	@Override
	public void updateEmployee(Employee e) {
		repo.save(e);

	}

	@Override
	public void deleteEmployee(Integer id) {
		Employee emp=getOneEmployee(id);
		repo.delete(emp);
	}

}
