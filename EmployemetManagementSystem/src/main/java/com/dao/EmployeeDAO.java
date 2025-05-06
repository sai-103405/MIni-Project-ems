package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.controler.List;
import com.model.Employee;

public class EmployeeDAO {
     Connection connection = null;
	public boolean save(Employee employee) throws ClassNotFoundException, SQLException {
		connection = ConnectionManager.getConnection();
		
		String query= "insert into employee(name,email,password,department,mobile,addr,salary) values(?,?,?,?,?,?,?)";
		PreparedStatement statement = connection.prepareStatement(query);
		
		statement.setString(1, employee.getName());
		statement.setString(2, employee.getEmail());
		statement.setString(3, employee.getPassword());
		statement.setString(4, employee.getDepartment());
		statement.setString(5, employee.getMobile());
		statement.setString(6, employee.getAddr());
		statement.setDouble(7, employee.getSalary());
		
		
		int count = statement.executeUpdate();
		
		
		if(count==1) {
			return true;
		}
		return false;
	}
	
	public void commit() throws SQLException {
		connection.commit();
		connection.close();
	}
	public void rollback() throws SQLException {
		connection.rollback();
		connection.close();
	}


	public List<com.controler.Employee> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
