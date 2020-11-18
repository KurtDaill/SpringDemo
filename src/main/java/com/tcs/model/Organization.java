package com.tcs.model;

import java.util.ArrayList;
import java.util.List;

public class Organization {
	private Long id;
	private String name;
	private String address;
	private List<Department> departments = new ArrayList<>();
	private List<Employee> employees = new ArrayList<>();
}
