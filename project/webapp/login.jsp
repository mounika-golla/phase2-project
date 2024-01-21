<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <h2>Railway Crossing</h2>
<h4>User Login</h4>
<form action="LoginServlet" method="post">
<label for="email">Email:</label> <input type="text"
id="email"
name="email" required><br> <label
for="password">Password:</label>
<input type="password" id="password" name="password"
required><br>
<button type="submit">Login</button>
</form>
<p>
Don't have an account? <a href="register.jsp">Create 
New
Account</a>
</p>
</body>
</html>