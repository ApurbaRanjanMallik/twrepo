package com.springboot.junit.service;

import org.springframework.stereotype.Service;

import com.springboot.junit.entity.Medicine;

@Service
public class MedicineServiceImpl implements MedicineService {

	@Override
	public String getHealthAdvice() {

		return "Carry water and drink enough water";
	}

	@Override
	public String addMedicine(Medicine medicine) {
		return "The medicine " + medicine.getName() + " added successfully";
	}

	@Override
	public String getMedicine(Medicine medicine) {

		return "The medicine " + medicine.getName() + " of price " + medicine.getPrice()
				+ "has been delevered successfully";
	}

	@Override
	public String updateMedicine(String id, Double price) {
		return "Medicine price updated with price " + price;
	}

	@Override
	public String returnMedicine(Medicine medicine) {

		return "You have The medicine returned " + medicine.getName() + " successfully";
	}

	@Override
	public String deleteMedicine(String id) {

		return "The medicine of " + id + " deleted successfully";
	}

}
