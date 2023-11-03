package com.tw.hms.service;

import java.util.List;

import com.tw.hms.dto.PatientDTO;

public interface IPatientService {

	Long addPatient(PatientDTO dto);

	PatientDTO getOnePatient(Long id);

	List<PatientDTO> getAllPatients();

	void updatePatient(PatientDTO dto);

	void deletePatient(Long id);
	
}
