package com.tw.springboot.security.entity;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usertab")
public class UserData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userid")
	private Integer userId;

	@Column(name = "username")
	private String userName;

	@Column(name = "useremail")
	private String userEmail;

	@Column(name = "userpwd")
	private String userPwd;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "roles_tab", joinColumns = @JoinColumn(name = "userid"))
	@Column(name = "userrole")
	private Set<String> userRoles;

}
