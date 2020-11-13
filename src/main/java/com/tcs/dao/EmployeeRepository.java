package com.tcs.dao;
import com.tcs.utils.DBUtils;
import com.tcs.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		Connection connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		Employee employee = null;
		String query = "select * from EMPLOYEE where productid=?";
		try {
			 preparedStatement = connection.prepareStatement(query);
			 preparedStatement.setLong(1,id);
			
			resultSet =  preparedStatement.executeQuery();
			 
			if(resultSet.next()) {
				 employee = new Employee();
				employee.setId(resultSet.getLong("id"));
				employee.setDepartmentId(resultSet.getLong("departmentId"));
				employee.setOrganizationId(resultSet.getLong("organizationId"));
				employee.setName(resultSet.getString("name"));
				employee.setAge(resultSet.getInt("age"));
				employee.setPosition(resultSet.getString("position"));
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
			return "Failed";
		}
		finally {
			DBUtils.closeConnection(connection);
		}
		return "Success";
	}
	
	public String deleteEmployee(long id) {
		Connection connection = DBUtils.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement("DELETE FROM EMPLOYEE WHERE id = " + id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return ("Failed");
		} finally {
			DBUtils.closeConnection(connection);
		}
		return ("Success");
	}
	public Optional<Employee> findById(long id){
		Connection connection = DBUtils.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM EMPLOYEE WHERE id = " + id);
			ResultSet resultSet = statement.executeQuery();
			Employee result = new Employee();
			resultSet.next();
			result.setId(resultSet.getLong(1));
			result.setDepartmentId(resultSet.getLong(2));
			result.setOrganizationId(resultSet.getLong(3));
			result.setName(resultSet.getString(4));
			result.setAge(resultSet.getInt(5));
			result.setPosition(resultSet.getString(6));
			return Optional.of(result);
		} catch (SQLException e) {
			e.printStackTrace();
			return Optional.empty();
		} finally {
			DBUtils.closeConnection(connection);
		}
	}
	public Optional<List<Employee>> getEmployees(){
		Connection connection = DBUtils.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement("Select * From EMPLOYEE");
			ResultSet set = statement.executeQuery();
			List<Employee> list = new ArrayList<Employee>();
			Employee emp = new Employee();
			while(set.next()) {
				emp.setId(set.getLong(1));
				emp.setDepartmentId(set.getLong(2));
				emp.setOrganizationId(set.getLong(3));
				emp.setName(set.getString(4));
				emp.setAge(set.getInt(5));
				emp.setPosition(set.getString(6));
				list.add(emp);
			}
			return Optional.of(list);
		} catch (SQLException e) {
			e.printStackTrace();
			return Optional.empty();
		}finally {
			DBUtils.closeConnection(connection);
		}
	}
	public Optional<List<Employee>> findByOrganizationId(long id){
		Connection connection = DBUtils.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM EMPLOYEE WHERE organizationId = " + id);
			ResultSet resultSet = statement.executeQuery();
			Employee result = new Employee();
			List<Employee> list = new ArrayList<Employee>();
			while(resultSet.next()) {
				result.setId(resultSet.getLong(1));
				result.setDepartmentId(resultSet.getLong(2));
				result.setOrganizationId(resultSet.getLong(3));
				result.setName(resultSet.getString(4));
				result.setAge(resultSet.getInt(5));
				result.setPosition(resultSet.getString(6));
				list.add(result);
			}
			return Optional.of(list);
		} catch (SQLException e) {
			e.printStackTrace();
			return Optional.empty();
		} finally {
			DBUtils.closeConnection(connection);
		}
	}
}
