package com.tw.hms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tw.hms.dto.PatientDTO;
import com.tw.hms.entity.PatientEntity;
import com.tw.hms.exception.PatientNotFoundException;
import com.tw.hms.mapper.PatientMapper;
import com.tw.hms.repo.PatientRepository;
import com.tw.hms.service.IPatientService;

@Service
public class PatientServiceImpl implements IPatientService {

	@Autowired
	private PatientRepository repo;
	
	@Autowired
	private PatientMapper mapper;

	@Override
	public Long addPatient(PatientDTO dto) {
		PatientEntity entity = mapper.mapToEntity(dto);
		entity = repo.save(entity);
		return entity.getId();
	}

	@Override
	public PatientDTO getOnePatient(Long id) {
		PatientEntity entity = repo.findById(id)
				.orElseThrow(
						() -> new PatientNotFoundException
						("PATIENT '" + id + "' DOES NOT EXICT"));
		return mapper.mapToDTO(entity);
	}

	@Override
	public List<PatientDTO> getAllPatients() {
		List<PatientEntity> list = repo.findAll();
		List<PatientDTO> listDTO = mapper.mapToDTOList(list);
		return listDTO;
	}

	@Override
	public void updatePatient(PatientDTO dto) {
		if (repo.existsById(dto.getId())) {
			PatientEntity entity=mapper.mapToEntity(dto);
			repo.save(entity);
		}else {
			throw new PatientNotFoundException("PATIENT '" + dto.getId() + "' DOES NOT EXICT");
		}
	}

	@Override
	public void deletePatient(Long id) {
		repo.delete(repo.findById(id)
					.orElseThrow(
						()->new PatientNotFoundException
						("PATIENT '" + id + "' DOES NOT EXICT")
								)
				   );
	}
}
