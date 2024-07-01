<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.sql.Connection , java.sql.DriverManager , java.sql.PreparedStatement , 
	java.sql.SQLException , jakarta.servlet.RequestDispatcher , java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Face</title>
</head>
<body>
<br><br><br>
<h1><center>RENTED BOOKS</center></h1>
 <%! 
 	String bname , aname , sname;
 %>
 
 <%
 try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		}
	catch (ClassNotFoundException ec) {
		// TODO Auto-generated catch block
		ec.printStackTrace();
		}

	try {

			response.setContentType("text/html");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3606/lms"
					, "root", "mysql");
			PreparedStatement p1= connection.prepareStatement("select * from rentedbook");
			ResultSet re= p1.executeQuery();
			
			out.println("<html><body><h2><br><br><br><center><table border='4'><tr><td> Book Name </td><td> Author Name </td><td> Student Student Name </td></tr>");
			while(re.next()){
		
				bname= re.getString("book_name");
				aname=re.getString("author_name");
				sname=re.getString("stud_name");
				out.println("<tr><td>"+ bname+"</td><td>"+ aname+"</td><td>"+ sname+"</td></tr>");
					
				}
			out.println("</table></center></h2></body></html>");
		}
	catch (SQLException ec) {
		// TODO Auto-generated catch block
		ec.printStackTrace();
		}
 %>
</body>
</html> 

</body>
</html>