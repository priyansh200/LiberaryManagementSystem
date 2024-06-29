package com.lib;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/DeleteBook")

public class DeleteBook extends HttpServlet {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String BookName;
		BookName = request.getParameter("BookName");
	
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3606/lms", "root", "mysql");
			PreparedStatement p1= connection.prepareStatement("delete from avaliblbooks where BookName= ?");
			p1.setString(1,BookName);
			int i = p1.executeUpdate();
			if(i>0) {
				RequestDispatcher rd = request.getRequestDispatcher("AdminHome.jsp");
				rd.forward(request, response);
				out.print("<h2> book deletet successfully </h2> ");
			}
			else {
				response.setContentType("html/text");
				out.print("<h2> book does not exist</h2> ");
				RequestDispatcher rd = request.getRequestDispatcher("DeleteBook.html");
				rd.include(request, response);
			
				
			}
		
			
		} 

		catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		
	 catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

		
}
}
