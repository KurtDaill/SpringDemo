package com.tcs.dao;
import com.tcs.utils.DBUtils;
import com.tcs.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class EmployeeRepository {
	private static EmployeeRepository singleInstance;
	
	private EmployeeRepository() {
		
	}
	
	public static EmployeeRepository getInstance() {
		if(singleInstance == null) {
			singleInstance = new EmployeeRepository();
		}
		return singleInstance;
	}
	public String addEmployee(Employee employee) {
		Connection connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		int result = 0;
		String insertProduct = "insert into Employee (id, organizationId, DepartmentId, name, age, position) values(?,?,?,?,?,?)";
		try {
			 preparedStatement = connection.prepareStatement(insertProduct);
			 preparedStatement.setLong(1, employee.getId());
			 preparedStatement.setLong(2, employee.getOrganizationId());
			 preparedStatement.setLong(3, employee.getDepartmentId());
			 preparedStatement.setString(4, employee.getName());
			 preparedStatement.setInt(5, employee.getAge());
			 preparedStatement.setString(6, employee.getPosition());
			 
			 result = preparedStatement.executeUpdate();
			 
			 if(result>0)
			 {
				 connection.commit();
				 return "success";
				 
			 }
			 else {
				 return "fail";
			 }
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
		finally {
			DBUtils.closeConnection(connection);
		}
	}
	
	public String updateEmployee(long id) {
		
	}
	public String deleteEmployee(long id);
	public Optional<Employee> findById(long id);
	public Optional<List<Employee>> getEmployees();
	public Optional<List<Employee>> findByOrganizationId(long id);
}
