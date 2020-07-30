package com.jdbc.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dbutil.MySqlDbConnection;
import com.jdbc.demo.insert.Customer;

public class CustomerDAO {
	public int addCustomer(Customer customer) {
		int c=0;
		
		try(Connection connection= MySqlDbConnection.getConnection();) {
			String sql="insert into customer(id,name,city,age,gender,contact) values(?,?,?,?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, customer.getId());
			preparedStatement.setString(2, customer.getName());
			preparedStatement.setString(3, customer.getCity());
			preparedStatement.setInt(4, customer.getAge());
			preparedStatement.setString(5, customer.getGender());
			preparedStatement.setLong(6, customer.getContact());
			
			c=preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		return c;
	}
	
	public Customer getCustomerById(int id) {
		Customer customer=null;
		try(Connection connection= MySqlDbConnection.getConnection();) {
			String sql="select name,city,age,gender,contact from customer where id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				customer=new Customer();
				customer.setId(id);
				customer.setAge(resultSet.getInt("age"));
				customer.setName(resultSet.getString("name"));
				customer.setCity(resultSet.getString("city"));
				customer.setGender(resultSet.getString("gender"));
				customer.setContact(resultSet.getLong("contact"));
			}
		}catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
		return customer;
	}

}
