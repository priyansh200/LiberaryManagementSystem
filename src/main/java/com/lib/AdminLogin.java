package com.lib;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AdminLogin")

public class AdminLogin extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("html");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("user");
		String password = request.getParameter("password");
		if (email.equals("priyansh") && password.equals("1401")) {
			response.setContentType("text/html");
			RequestDispatcher rd = request.getRequestDispatcher("AdminHome.jsp");
			rd.forward(request, response);

		} else {
			response.setContentType("text/html");
			out.print("<h3 style= 'color:red,padding-top = 100px' > <center>*wrong email or passowrd </center></h3>");
			RequestDispatcher rd = request.getRequestDispatcher("AdminLogin.jsp");
			rd.include(request, response);
		}

	}

}
