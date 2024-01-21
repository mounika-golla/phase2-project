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
          <h4>User Register</h4>
<form action="RegisterServlet" method="post">
<label for="name">Name:</label> <input type="text"
id="name"
name="name" required><br> <label
for="email">Email:</label>
<input type="text" id="email" name="email" required><br>
<label for="password">Password:</label> <input
type="password"
id="password" name="password" required><br>
<button type="submit">Register</button>
</form>
<p>
Already have an account? <a href="login.jsp">Sign 
in</a>
</p>

</body>
</html>