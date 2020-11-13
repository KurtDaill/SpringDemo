package com.tcs.main;

import java.util.List;
import java.util.Optional;

import com.tcs.model.Employee;
import com.tcs.service.EmployeeService;

public class Main {
	public static void Main(String args[]) {
		int opt = 0;
		long id = 144;
		Employee emp = new Employee();
		Optional<Employee> resultEmp;
		Optional<List<Employee>> resultList;
		EmployeeService serve = EmployeeService.getInstance();
		switch(opt)
		{
			case 1: System.out.println(serve.addEmployee(emp));
			case 2: System.out.println(serve.updateEmployee(id));
			case 3: System.out.println(serve.deleteEmployee(id));
			case 4: resultEmp = serve.findById(id);
			case 5: resultList = serve.findByOrganizaitonId(id);
			case 6: resultList = serve.getEmployees();
		}
	}
}
