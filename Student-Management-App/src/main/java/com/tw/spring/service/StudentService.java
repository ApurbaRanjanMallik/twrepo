package com.tw.spring.service;

import java.util.List;

import com.tw.spring.entity.Student;

public interface StudentService {
	List<Student> getAllStudents();
	
	Student saveStudent(Student student);
	
	Student getStudentById(Integer id);
	
	Student updateStudent(Student student);
	
	void deleteStudentById(Integer id);
}
