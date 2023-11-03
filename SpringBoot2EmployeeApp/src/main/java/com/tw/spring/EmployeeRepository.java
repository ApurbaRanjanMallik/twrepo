package com.tw.spring;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tw.spring.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
