package com.tcs.main;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tcs.config.DBConfig;
import com.tcs.model.*;
import com.tcs.service.EmployeeService;

public class JPAMain {
	public static void main(String args[]) {
		Department dept = new Department();
		dept.setId((long) 10);
		dept.setOrganizationId(15);
		
		Organization org = new Organization();
		org.setId((long) 10);
		org.setAddress("1 Dummy St");
		
		Employee emp = new Employee();
		emp.setName("Jon");
		emp.setId((long) 5);
		emp.setDepartmentId((long) 10);
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
		EmployeeService empService = context.getBean(EmployeeService.class);
		
		System.out.println(empService.CreateEmployee(emp));
		context.close();
	}
}
