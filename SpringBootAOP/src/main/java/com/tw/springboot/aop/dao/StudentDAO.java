package com.tw.springboot.aop.dao;

import org.springframework.stereotype.Component;

import com.tw.springboot.aop.anno.MyAnno;

@Component
public class StudentDAO {
	@MyAnno
	public void saveStudent() {
		System.out.println("Save Student ");
	}

	public void getAllStudent() {
		System.out.println("Get all Students");
	}
}
