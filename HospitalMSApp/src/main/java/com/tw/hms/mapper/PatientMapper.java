package com.tw.hms.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tw.hms.dto.PatientDTO;
import com.tw.hms.entity.PatientEntity;

@Component
public class PatientMapper {

	@Autowired
	private ModelMapper mapper;

	public PatientEntity mapToEntity(PatientDTO dto) {
		PatientEntity entity = mapper.map(dto, PatientEntity.class);
		return entity;
	}

	public PatientDTO mapToDTO(PatientEntity entity) {
		PatientDTO dto = mapper.map(entity, PatientDTO.class);
		return dto;
	}

	public List<PatientDTO> mapToDTOList(List<PatientEntity> entities) {
		List<PatientDTO> list = new ArrayList<>(entities.size());
		for (PatientEntity entity : entities) {
			list.add(mapToDTO(entity));
		}
		return list;
	}
}
