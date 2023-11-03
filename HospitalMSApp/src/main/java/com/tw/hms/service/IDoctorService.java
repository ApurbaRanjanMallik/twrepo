package com.tw.hms.service;

import java.util.List;

import com.tw.hms.dto.DoctorDTO;

public interface IDoctorService {

	Long addDoctor(DoctorDTO dto);

	DoctorDTO getOneDoctor(Long id);

	List<DoctorDTO> getAllDoctors();

	void deleteDoctor(Long id);

	void updateDoctor(DoctorDTO dto);

	Integer updateDocDeptById(Long id, String docDept);
	
}
