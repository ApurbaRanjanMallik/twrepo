package com.tw.hms.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tw.hms.dto.DoctorDTO;
import com.tw.hms.entity.DoctorEntity;

@Component
public class DoctorMapper {

	@Autowired
	private ModelMapper mapper;

	public DoctorEntity mapToEntity(DoctorDTO dto) {
		DoctorEntity entity = mapper.map(dto, DoctorEntity.class);
		return entity;
	}

	public DoctorDTO mapToDTO(DoctorEntity entity) {
		DoctorDTO dto = mapper.map(entity, DoctorDTO.class);
		return dto;
	}

	public List<DoctorDTO> mapToDTOList(List<DoctorEntity> entities) {
		List<DoctorDTO> list = new ArrayList<>(entities.size());
		for (DoctorEntity entity : entities) {
			list.add(mapToDTO(entity));
		}
		return list;
	}
}
