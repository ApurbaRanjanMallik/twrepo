package com.tw.hms.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tw.hms.dto.DoctorDTO;
import com.tw.hms.service.IDoctorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v1/api/doctor")
@Api(description = "DOCTOR'S OPERATION")
public class DoctorRestController {

	@Autowired
	private IDoctorService service;

	/**
	 * This method is for creating a new Doctor in Database
	 * 
	 * @paramdoctorDto in JSON Format
	 * @return Success Response on creation
	 */
	@PostMapping("/save")
	@ApiOperation("CREATE DOCTOR")
	public ResponseEntity<String> createDoctor(@RequestBody @Valid DoctorDTO dto) {
		Long id = service.addDoctor(dto);
		String message = "DOCTOR '" + id + "'IS CREATED";
		return ResponseEntity.ok(message);
	}

	/**
	 * This method is for getting one doctor details It is taking the id of the
	 * Doctor Returning the Doctor object
	 * 
	 */
	@GetMapping("/getone/{id}")
	@ApiOperation("FETCH ONE DOCTOR")
	public ResponseEntity<DoctorDTO> fetchOneDoctor(@PathVariable Long id) {
		DoctorDTO dto = service.getOneDoctor(id);
		return ResponseEntity.ok(dto);
	}

	/**
	 * This method is for getting all Doctors details
	 * 
	 * 
	 */
	@GetMapping("/all")
	@ApiOperation("FETCH ALL DOCTORS INFORMATION")
	public ResponseEntity<List<DoctorDTO>> fetchAllDoctors() {
		List<DoctorDTO> list = service.getAllDoctors();
		return ResponseEntity.ok(list);
	}

	/**
	 * This method is for one Doctor details It is taking the id of the doctor. If
	 * the id is exist then it will delete all details
	 * 
	 */
	@DeleteMapping("/delete/{id}")
	@ApiOperation("DELETE DOCTOR INFORMATION")
	public ResponseEntity<String> deleteOneDoctor(@PathVariable Long id) {
		service.deleteDoctor(id);
		String message = "DOCTOR '" + id + "'IS DELETED";
		return ResponseEntity.ok(message);
	}

	/**
	 * This method is for update Doctor information
	 * 
	 * @paramdoctorDto in JSON Format
	 * @return Success Response on creation
	 * 
	 */
	@PutMapping("/update")
	@ApiOperation("UPDATE DOCTOR INFORMATION")
	public ResponseEntity<String> updateOneDoctor(@RequestBody @Valid DoctorDTO dto) {
		service.updateDoctor(dto);
		Long id = dto.getId();
		String message = "DOCTOR '" + id + "' IS UPDATED";
		return ResponseEntity.ok(message);

	}

	@PatchMapping("/modify/{id}/{docDept}")
	public ResponseEntity<String> updateDoctorById(@PathVariable Long id, @PathVariable String docDept) {
		service.updateDocDeptById(id, docDept);
		return ResponseEntity.ok("DOCTOR '" + id + "' UPDATED WITH NEW DEPT");

	}
}
