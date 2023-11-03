package com.tw.springboot.aop.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tw.springboot.aop.dao.StudentDAO;

@Component
public class TestRunner implements CommandLineRunner {
	@Autowired
	private StudentDAO dao;

	@Override
	public void run(String... args) throws Exception {
		dao.saveStudent();
		dao.getAllStudent();

	}

}
