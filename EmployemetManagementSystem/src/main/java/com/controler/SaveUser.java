package com.controler;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;
import com.model.Employee;
@WebServlet("/saveuser")
public class SaveUser extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Employee employee = new Employee();
	employee.setName(request.getParameter("name"));
	employee.setEmail(request.getParameter("email"));
	employee.setPassword(request.getParameter("password"));
	employee.setDepartment(request.getParameter("department"));
	employee.setMobile(request.getParameter("mobile"));
	employee.setAddr(request.getParameter("addr"));
	
	EmployeeDAO dao = new EmployeeDAO();
	
	try {
		boolean status = dao.save(employee);
		if(status) {
			dao.commit();
			request.setAttribute("status","Registered sucessfully");
		}
		else {
			dao.rollback();
			request.setAttribute("status","Registration failed");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
		dispatcher.forward(request, response);
		
	} 
	catch (ClassNotFoundException | SQLException e) {
		
		e.printStackTrace();
	}
	
	}

}
