package com.tcs.dao;

import com.tcs.model.Hostel;
import com.tcs.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

public class HostelRepository {
	
	@Autowired
	DBUtils dbUtils;
	
	public String createHostel(Hostel hostel) {
		// TODO Auto-generated method stub
		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement = null;
		int result = 0;
		String insertProduct = "insert into PRODUCT (productid,productname,description,category,price) values(?,?,?,?,?)";
		try {
			 preparedStatement = connection.prepareStatement(insertProduct);
			 preparedStatement.setString(1, hostel.getName());
			 preparedStatement.setString(2, hostel.getCity());
			 
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
			dbUtils.closeConnection(connection);
		}
		
	}

	public Optional<Hostel> getHostelByName(String id) {
		// TODO Auto-generated method stub
		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		Hostel hostel = null;
		String query = "select * from HOSTEL where hostelname=?";
		try {
			 preparedStatement = connection.prepareStatement(query);
			 preparedStatement.setString(1,id);
			
			resultSet =  preparedStatement.executeQuery();
			 
			if(resultSet.next()) {
				 hostel = new Hostel();
				hostel.setName(resultSet.getString("name"));
				hostel.setCity(resultSet.getString("city"));
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
			return Optional.empty();
		}
		finally {
			dbUtils.closeConnection(connection);
		}
		return Optional.of(hostel);
	}
}
