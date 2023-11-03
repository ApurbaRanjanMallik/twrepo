package com.springboot.junit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.junit.entity.Medicine;
import com.springboot.junit.service.MedicineService;

@RestController
@RequestMapping("/medico")
public class MedicineController {
	@Autowired
	MedicineService medicineService;

	@GetMapping(value = "/healthadv")
	public ResponseEntity<String> getHealthAdvice() {
		String message = medicineService.getHealthAdvice();
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@PostMapping(value = "/add")
	public ResponseEntity<String> addMedicine(@RequestBody Medicine medicine) {
		String id = medicineService.addMedicine(medicine);
		String message = "DOCTOR '" + id + "'IS CREATED";
		return ResponseEntity.ok(message);

	}
}
