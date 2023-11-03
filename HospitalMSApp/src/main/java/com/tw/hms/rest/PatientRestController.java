package com.tw.hms.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tw.hms.dto.PatientDTO;
import com.tw.hms.service.IPatientService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/v1/api/patient")
@Api(description = "PATIENT'S OPERATION")
public class PatientRestController {
	@Autowired
	private IPatientService service;
	
	@PostMapping("/save")
	@ApiOperation("CREATE PATIENT")
	public ResponseEntity<String> createPatient(@RequestBody @Valid PatientDTO dto) {
		Long id = service.addPatient(dto);
		String message = "PATIENT '" + id + "'IS CREATED";
		return ResponseEntity.ok(message);

	}

	@GetMapping("/getone")
	@ApiOperation("FETCH ONE PATIENT")
	public ResponseEntity<PatientDTO> fetchOnePatient(@PathVariable Long id) {
		PatientDTO dto = service.getOnePatient(id);
		return ResponseEntity.ok(dto);

	}

	@GetMapping("/all")
	@ApiOperation("FETCH ALL PATIENTS")
	public ResponseEntity<List<PatientDTO>> fetchAllPatients() {
		List<PatientDTO> list = service.getAllPatients();
		return ResponseEntity.ok(list);

	}

	@PutMapping("/update")
	@ApiOperation("UPDATE PATIENT INFORMATION")
	public ResponseEntity<String> updateOnePatient(@RequestBody PatientDTO dto) {
		service.updatePatient(dto);
		Long id = dto.getId();
		String messsage = "PATINET '" + id + "'IS UPDATED";
		return ResponseEntity.ok(messsage);

	}

	@DeleteMapping("/delete")
	@ApiOperation("DELETE PATIENT INFORMATION")
	public ResponseEntity<String> deleteOnePatient(@PathVariable Long id) {
		service.deletePatient(id);
		String message = "PATIENT '" + id + "' IS DELETED";
		return ResponseEntity.ok(message);

	}

}
