<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.sql.Connection , java.sql.DriverManager , java.sql.PreparedStatement , 
	java.sql.SQLException , jakarta.servlet.RequestDispatcher , java.sql.ResultSet,jakarta.servlet.http.HttpSession" %>
<%@ page session = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>

.head {
    display: flex;
  	justify-content: center;
  	align-items: center;
  	color: white;
    height: 200px;
    background-color : rgb(102, 102, 102);
    font-size : 50px;
    }
    
.button{
	display: block;
    margin: 0 auto;
    width: 300px;
    height: 100px;
    border-radius: 30px;
    color: white;
    font-size: 40px;
    cursor: pointer;
     display: flex;
  	justify-content: center;
  	align-items: center;
	margin: 40px;
	margin-left: 130px;
    background: #d4af7a;
    text-transform: uppercase;
	}
	
a{
	text-decoration: none;
	}
	
#container{
	display: flex;
}		
</style>
</head>

<body>
<% 
int id= (int)request.getSession().getAttribute("id");




%>

<div class="head"><h1>Student Portal</h1></div>
 		<br>
 		<br>
 		<br>
<h1><center>Avalible Books</center></h1>

 <%! 
 	String book , author;
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
			PreparedStatement p1= connection.prepareStatement("select * from avaliblbooks");
			ResultSet re= p1.executeQuery();
			
			
		
			out.println("<html><body><h2><br><br><br><center><table border='4'><tr><td> Book Name </td><td> Author Name </td></tr>");
			while(re.next()){
		
				book= re.getString("BookName");
				author=re.getString("Author");
				out.println("<tr><td>"+ book+"</td><td>"+ author+"</td></tr>");
					
				}
			out.println("</table></center></h2></body></html>");
		}
	catch (SQLException ec) {
		// TODO Auto-generated catch block
		ec.printStackTrace();
		}
 %>
 
 
        
        <div id="container">
 			<div class="button"><a href ="RentBook.jsp">Rent</a></div>
        
            <div class="button"><a href="ReturnBook.jsp">Return</a></div>
            <div class="button"><a href="myRentedBooks.jsp">Mine</a></div>
        
        
            <div class="button"><a href="logout.html">Logout</a></div>
       
       
        </div>
        
        
        <br>
        <br>
      
</body>
</html>