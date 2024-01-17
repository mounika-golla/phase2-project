<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Entry</title>
</head>
<body>
	<form action="productEntry" method="post">
        Product Name: <input type="text" name="productName" required><br>
        Price: <input type="text" name="price" required><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>