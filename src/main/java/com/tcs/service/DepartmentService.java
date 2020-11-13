package com.tcs.service;

import java.util.List;
import java.util.Optional;

import com.tcs.dao.DepartmentRepository;
import com.tcs.dao.EmployeeRepository;
import com.tcs.model.Department;
import com.tcs.model.Employee;

public class DepartmentService {
	private DepartmentService() {
	
	}

	private static DepartmentService singleInstance = null;

	public static DepartmentService getInstance() {
		if (singleInstance == null) {
			singleInstance = new DepartmentService();
		}
	return singleInstance;
	}

	public String addDepartment(Department department) {
		DepartmentRepository dao = DepartmentRepository.getInstance();
		String result = dao.addDepartment(department);
		return result;
	}

public String updateDepartment(long id) {
	DepartmentRepository dao = DepartmentRepository.getInstance();
	String result = dao.updateDepartment(id);
	return result;
}

public String deleteEmployee(long id) {
	DepartmentRepository dao = DepartmentRepository.getInstance();
	String result = dao.deleteDepartment(id);
	return result;
}

public Optional<Department> findById(long id){
	DepartmentRepository dao = DepartmentRepository.getInstance();
	Optional<Department> result = dao.findById(id);
	return result;
}

public Optional<List<Department>> getEmployees(){
	DepartmentRepository dao = DepartmentRepository.getInstance();
	Optional<List<Department>> result = dao.getDepartment();
	return result;
}

public Optional<List<Department>> findByOrganizaitonId(long id){
	DepartmentRepository dao = DepartmentRepository.getInstance();
	Optional<List<Department>> result = dao.findByOrganizationId(id);
	return result;
}
}
