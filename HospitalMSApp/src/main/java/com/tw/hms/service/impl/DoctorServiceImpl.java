package com.tw.hms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tw.hms.dto.DoctorDTO;
import com.tw.hms.entity.DoctorEntity;
import com.tw.hms.exception.DoctorNotFoundException;
import com.tw.hms.mapper.DoctorMapper;
import com.tw.hms.repo.DoctorRepository;
import com.tw.hms.service.IDoctorService;

@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	private DoctorRepository repo;

	@Autowired
	private DoctorMapper mapper;

	@Override
	public Long addDoctor(DoctorDTO dto) {
		DoctorEntity entity = mapper.mapToEntity(dto);
		entity = repo.save(entity);
		return entity.getId();
	}

	@Override
	public DoctorDTO getOneDoctor(Long id) {
		DoctorEntity entity = repo.findById(id)
				.orElseThrow(() -> new DoctorNotFoundException("DOCTOR'" + id + "'NOT EXIST"));
		return mapper.mapToDTO(entity);
	}

	@Override
	public List<DoctorDTO> getAllDoctors() {
		List<DoctorEntity> list = repo.findAll();
		List<DoctorDTO> listDTO = mapper.mapToDTOList(list);
		return listDTO;
	}

	@Override
	public void deleteDoctor(Long id) {
		repo.delete(repo.findById(id).orElseThrow(() -> new DoctorNotFoundException("DOCTOR'" + id + "'NOT EXIST")));
	}

	@Override
	public void updateDoctor(DoctorDTO dto) {
		if (repo.existsById(dto.getId())) {
			DoctorEntity entity = mapper.mapToEntity(dto);
			repo.save(entity);
		} else {
			throw new DoctorNotFoundException("DOCTOR'" + dto.getId() + "'NOT EXIST");
		}
	}

	@Override
	public Integer updateDocDeptById(Long id, String docDept) {
		if (!repo.existsById(id))
			throw new DoctorNotFoundException("DOCTOR '" + id + "' NOT EXIST");

		return repo.updateDateDocDeptById(id, docDept);
	}

}
