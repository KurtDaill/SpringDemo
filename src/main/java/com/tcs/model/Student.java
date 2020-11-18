package com.tcs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	private String name;
	//TODO: Remove me
	public String getName() {
		return name;
	}
	private String id;
	@Autowired
	private Hostel hostel;
	
	public Student(String name, String id) {
		this.name = name;
		this.id = id;
	}
}
