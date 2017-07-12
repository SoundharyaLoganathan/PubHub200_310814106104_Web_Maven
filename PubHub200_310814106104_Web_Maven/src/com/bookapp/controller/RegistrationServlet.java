package com.bookapp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookapp.dao.UserDAO;
import com.bookapp.model.User;


@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegistrationServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
	
		User user=new User();
		user.setUserName(name);
		user.setEmail(email);
		user.setPassword(password);
		
		UserDAO dao=new UserDAO();
		dao.register(user);
		}
		
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			String password=request.getParameter("password");
		
			User user=new User();
			user.setUserName(name);
			user.setEmail(email);
			user.setPassword(password);
			
			UserDAO dao=new UserDAO();
			dao.register(user);
			response.sendRedirect("success.jsp");
			System.out.println(user);
			
			
		
	}

	
	

}
