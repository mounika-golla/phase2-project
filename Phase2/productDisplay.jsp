<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.ecommerce.Product" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>productDisplay</title>
</head>
<body>
	<h2>Product Details</h2>
    <%
        // Retrieve the product from the session
        Product product = (Product) session.getAttribute("product");

        // Display product details
        if (product != null) {
    %>
            <p><b>Product Name:</b> <%= product.getProductName() %></p>
            <p><b>Price:</b> <%= product.getPrice() %></p>
    <%
        } else {
    %>
            <p>No product details found.</p>
    <%
        }
    %>
</body>
</html>