package com.lib;

import java.io.IOException;

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

@WebServlet("/StudentSignin")

public class StudentSignup extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int i;
		String name, email, password;
		name = request.getParameter("name");
		email = request.getParameter("user");
		password = request.getParameter("password");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3606/lms", "root", "mysql");
				PreparedStatement p1 = connection
						.prepareStatement("insert into studentdata (Name,Email,Password) values (?,?,?)");

				p1.setString(1, name);
				p1.setString(2, email);
				p1.setString(3, password);

				i = p1.executeUpdate();
				if (i > 0) {
					RequestDispatcher rd = request.getRequestDispatcher("StudentHome.jsp");
					rd.forward(request, response);
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
