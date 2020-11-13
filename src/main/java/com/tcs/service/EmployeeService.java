package com.tcs.service;

import java.util.List;
import java.util.Optional;

import com.tcs.dao.EmployeeRepository;
import com.tcs.model.Employee;

public class EmployeeService {
	private EmployeeService() {
		
	}
	
	private static EmployeeService singleInstance = null;
	
	public static EmployeeService getInstance() {
		if (singleInstance == null) {
			singleInstance = new EmployeeService();
		}
		return singleInstance;
	}
	
	public String addEmployee(Employee employee) {
		EmployeeRepository dao = EmployeeRepository.getInstance();
		String result = dao.addEmployee(employee);
		return result;
	}
	
	public String updateEmployee(long id) {
		EmployeeRepository dao = EmployeeRepository.getInstance();
		String result = dao.updateEmployee(id);
		return result;
	}
	
	public String deleteEmployee(long id) {
		EmployeeRepository dao = EmployeeRepository.getInstance();
		String result = dao.deleteEmployee(id);
		return result;
	}
	
	public Optional<Employee> findById(long id){
		EmployeeRepository dao = EmployeeRepository.getInstance();
		Optional<Employee> result = dao.findById(id);
		return result;
	}
	
	public Optional<List<Employee>> getEmployees(){
		EmployeeRepository dao = EmployeeRepository.getInstance();
		Optional<List<Employee>> result = dao.getEmployees();
		return result;
	}
	
	public Optional<List<Employee>> findByOrganizaitonId(long id){
		EmployeeRepository dao = EmployeeRepository.getInstance();
		Optional<List<Employee>> result = dao.findByOrganizationId(id);
		return result;
	}
}
