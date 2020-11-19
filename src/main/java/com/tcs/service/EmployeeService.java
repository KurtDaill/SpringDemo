package com.tcs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.model.Employee;
import com.tcs.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	
	public String CreateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		Employee tempEmp = null;
		try {
			tempEmp = employeeRepository.save(emp);
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
	}
	
	public List<Employee> findByDepartmentId(Long departmentId){
		return employeeRepository.findByDepartmentID(departmentId);
	}
	
	public Optional<Employee> findById(Long id){
		return employeeRepository.findById(id);
	}
}
