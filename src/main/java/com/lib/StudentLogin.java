package com.lib;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/StudentLogin")

public class StudentLogin extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("html");
		PrintWriter out = response.getWriter();

		String user, password, u, p;

		user = request.getParameter("user");
		password = request.getParameter("password");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3606/lms", "root", "mysql");
				PreparedStatement p1 = connection.prepareStatement("select * from studentdata");
				ResultSet re = p1.executeQuery();
				while (re.next()) {

					u = re.getString("email");
					p = re.getString("password");

					if (u.equals(user) && p.equals(password)) {
						int id = re.getInt("Id");
						HttpSession session=  request.getSession();
						session.setAttribute("id", id);
						response.setContentType("text/html");
						RequestDispatcher rd = request.getRequestDispatcher("StudentHome.jsp");
						rd.forward(request, response);

					}
				}

				response.setContentType("text/html");
				out.print(
						"<h3 style= 'color:red,padding-top = 100px' > <center>*wrong email or passowrd </center></h3>");
				RequestDispatcher rd = request.getRequestDispatcher("StudentLogin.jsp");
				rd.include(request, response);

			} catch (SQLException ec) {
				// TODO Auto-generated catch block
				ec.printStackTrace();
			}

		} catch (ClassNotFoundException ec) {
			// TODO Auto-generated catch block
			ec.printStackTrace();
		}
	}

}
