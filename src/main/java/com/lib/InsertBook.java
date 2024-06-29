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

@WebServlet("/InsertBook")

public class InsertBook extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int i;
		String BookName, Author;
		response.setContentType("html");
		PrintWriter out = response.getWriter();
		BookName = request.getParameter("BookName");
		Author = request.getParameter("Author");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3606/lms", "root", "mysql");
				PreparedStatement p1 = connection
						.prepareStatement("insert into avaliblbooks (BookName,Author) values (?,?)");

				p1.setString(1, BookName);
				p1.setString(2, Author);

				i = p1.executeUpdate();
				if (i > 0) {
					
					RequestDispatcher rd = request.getRequestDispatcher("AdminHome.jsp");
					rd.forward(request, response);
				}
				else {
					out.print("<h2> book not inserted </h2> ");
					RequestDispatcher rd = request.getRequestDispatcher("InsertBook.html");
					rd.include(request, response);
				
				
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
