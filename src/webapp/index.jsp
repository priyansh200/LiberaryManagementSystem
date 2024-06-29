<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Library Management System</title>
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
<br><br>
<div class="head"> <h1>Library Management System</h1></div>
 		<br>
 		<br>
        <br>
 			<div class="button"><a href ="AdminLogin.jsp">Admin</a></div>
        <br>
        <br>
        <br>
            <div class="button"><a href="StudentLogin.jsp">Student</a></div>
      
</body>
</html>