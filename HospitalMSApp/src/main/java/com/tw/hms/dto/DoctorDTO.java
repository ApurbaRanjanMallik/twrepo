package com.tw.hms.dto;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import lombok.Data;
@Component
@Data
public class DoctorDTO {

	private Long id;

	@NotNull
	private String docName;

	@NotNull
	private String docQualif;

	@NotNull
	private String docSpec;

	@NotNull
	private String docDept;

	@NotNull
	private String docAddrs;

	@NotNull
	private String docContact;
}
