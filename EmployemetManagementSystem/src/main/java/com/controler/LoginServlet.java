package com.controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/loginservlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String email = request.getParameter("email");
      String password=request.getParameter("password");
      
      HttpSession session = request.getSession();
      
      if(email.equals("manager@codegnan.com") && password.equals("manager@cg")) {
    	  session.setAttribute("email",email);
    	  response.sendRedirect("manager.jsp");
      }
      else {
    	  EmployeeDAO dao= new EmployeeDAo();
    	  boolean status = dao.checkLogin(email,login);
    	  
      }
	}

}
