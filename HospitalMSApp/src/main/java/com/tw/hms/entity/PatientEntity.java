package com.tw.hms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "PATIENT_TAB")
public class PatientEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PAT_ID_COL")
	private Long id;

	@Column(name = "PAT_NAME_COL")
	private String name;

	@Column(name = "PAT_EMAIL_COL")
	private String email;

	@Column(name = "PAT_GENDER_COL")
	private String gender;

	@Column(name = "PAT_CONT_COL")
	private String contact;

	@Column(name = "PAT_ADDRS_COL")
	private String addrs;

	@Column(name = "PAT_BLOODGR_COL")
	private String bloodGr;

}
