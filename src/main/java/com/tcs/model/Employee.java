package com.tcs.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EMPLOYEE")
public class Employee {
	@Id
	private Long id;
	@Column(name = "organization_id")
	private Long organizationId;
	@Column(name = "department_id")
	private Long departmentId;
	private String name;
	private int age;
	private String position;
}
