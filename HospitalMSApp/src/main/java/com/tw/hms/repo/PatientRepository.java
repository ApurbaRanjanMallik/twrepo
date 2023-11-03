package com.tw.hms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tw.hms.entity.PatientEntity;

public interface PatientRepository extends JpaRepository<PatientEntity, Long> {

}
