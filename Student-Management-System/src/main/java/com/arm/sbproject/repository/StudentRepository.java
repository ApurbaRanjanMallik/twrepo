package com.arm.sbproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arm.sbproject.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
