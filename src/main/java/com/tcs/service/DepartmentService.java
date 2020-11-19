package com.tcs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.model.Department;
import com.tcs.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	public String createProduct(Department dept) {
		// TODO Auto-generated method stub
		Department tempDept = null;
		try {
			tempDept = departmentRepository.save(dept);
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
	}
	
	public List<Department> findByOrganization(Long organizationId){
		return departmentRepository.findByOrganization(organizationId);
	}
	
	public Optional<Department> findById(Long id){
		return departmentRepository.findById(id);
	}
}
