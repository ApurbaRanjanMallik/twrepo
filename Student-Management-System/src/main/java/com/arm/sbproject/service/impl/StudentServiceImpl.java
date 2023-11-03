package com.arm.sbproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arm.sbproject.entity.Student;
import com.arm.sbproject.repository.StudentRepository;
import com.arm.sbproject.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepository repository;

	public StudentServiceImpl(StudentRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public List<Student> getAllStudent() {
		return repository.findAll();
	}

}
