package com.springboot.junit.service;

import com.springboot.junit.entity.Medicine;

public interface MedicineService {
	String getHealthAdvice();

	String addMedicine(Medicine medicine);

	String getMedicine(Medicine medicine);

	String updateMedicine(String id, Double price);

	String returnMedicine(Medicine medicine);

	String deleteMedicine(String id);

}
