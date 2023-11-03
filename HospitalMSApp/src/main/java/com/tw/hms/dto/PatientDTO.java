package com.tw.hms.dto;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class PatientDTO {
	@NotNull
	private Long id;

	@NotNull
	private String name;

	@NotNull
	private String email;

	@NotNull
	private String gender;

	@NotNull
	private String contact;

	@NotNull
	private String addrs;

	@NotNull
	private String bloodGr;
}
