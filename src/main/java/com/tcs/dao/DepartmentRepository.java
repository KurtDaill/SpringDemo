package com.tcs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.tcs.model.Department;
import com.tcs.model.Employee;
import com.tcs.utils.DBUtils;

public class DepartmentRepository {
	private static DepartmentRepository singleInstance;

	private DepartmentRepository() {
	
	}

public static DepartmentRepository getInstance() {
	if(singleInstance == null) {
		singleInstance = new DepartmentRepository();
	}
	return singleInstance;
}
public String addDepartment(Department department) {
	Connection connection = DBUtils.getConnection();
	PreparedStatement preparedStatement = null;
	int result = 0;
	String insertProduct = "insert into Employee (id, organizationId, name) values(?,?,?)";
	try {
		 preparedStatement = connection.prepareStatement(insertProduct);
		 preparedStatement.setLong(1, department.getId());
		 preparedStatement.setLong(2, department.getOrganizationId());
		 preparedStatement.setString(4, department.getName());
		 
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

public String updateDepartment(long id) {
	Connection connection = DBUtils.getConnection();
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	Department department = null;
	String query = "select * from Department where productid=?";
	try {
		 preparedStatement = connection.prepareStatement(query);
		 preparedStatement.setLong(1,id);
		
		resultSet =  preparedStatement.executeQuery();
		 
		if(resultSet.next()) {
			department = new Department();
			department.setId(resultSet.getLong("id"));
			department.setOrganizationId(resultSet.getLong("organizationId"));
			department.setName(resultSet.getString("name"));
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

public String deleteDepartment(long id) {
	Connection connection = DBUtils.getConnection();
	try {
		PreparedStatement statement = connection.prepareStatement("DELETE FROM DEPARTMENT WHERE id = " + id);
		statement.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
		return ("Failed");
	} finally {
		DBUtils.closeConnection(connection);
	}
	return ("Success");
}
public Optional<Department> findById(long id){
	Connection connection = DBUtils.getConnection();
	try {
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM DEPARTMENT WHERE id = " + id);
		ResultSet resultSet = statement.executeQuery();
		Department result = new Department();
		resultSet.next();
		result.setId(resultSet.getLong(1));
		result.setOrganizationId(resultSet.getLong(2));
		result.setName(resultSet.getString(3));
		return Optional.of(result);
	} catch (SQLException e) {
		e.printStackTrace();
		return Optional.empty();
	} finally {
		DBUtils.closeConnection(connection);
	}
}
public Optional<List<Department>> getDepartment(){
	Connection connection = DBUtils.getConnection();
	try {
		PreparedStatement statement = connection.prepareStatement("Select * From DEPARTMENT");
		ResultSet set = statement.executeQuery();
		List<Department> list = new ArrayList<Department>();
		Department dep = new Department();
		while(set.next()) {
			dep.setId(set.getLong(1));
			dep.setOrganizationId(set.getLong(2));
			dep.setName(set.getString(3));
			list.add(dep);
		}
		return Optional.of(list);
	} catch (SQLException e) {
		e.printStackTrace();
		return Optional.empty();
	}finally {
		DBUtils.closeConnection(connection);
	}
}
public Optional<List<Department>> findByOrganizationId(long id){
	Connection connection = DBUtils.getConnection();
	try {
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM DEPARTMENT WHERE organizationId = " + id);
		ResultSet resultSet = statement.executeQuery();
		Department result = new Department();
		List<Department> list = new ArrayList<Department>();
		while(resultSet.next()) {
			result.setId(resultSet.getLong(1));
			result.setOrganizationId(resultSet.getLong(2));
			result.setName(resultSet.getString(3));
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
