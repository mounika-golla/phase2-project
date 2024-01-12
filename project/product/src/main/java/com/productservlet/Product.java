package com.productservlet;

import jakarta.servlet.ServletException;



import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Product extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String productId = request.getParameter("productId");

        if (productId != null && !productId.isEmpty()) {
            try {
                // Load the JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Establish a connection
                String jdbcUrl = "jdbc:mysql://localhost:3306/Mounika";
                String username = "root";
                String password = "Mounik@2690";
                Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

                // Prepare the SQL query
                String sql = "SELECT * FROM product WHERE id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, Integer.parseInt(productId));

                // Execute the query
                ResultSet resultSet = preparedStatement.executeQuery();

                // Display the result
                out.println("<html><body>");
                if (resultSet.next()) {
                    out.println("<h2>Product Details</h2>");
                    out.println("<p>ID: " + resultSet.getInt("id") + "</p>");
                    out.println("<p>Name: " + resultSet.getString("name") + "</p>");
                    out.println("<p>Price: $" + resultSet.getDouble("price") + "</p>");
                } else {
                    out.println("<p>No product found for ID: " + productId + "</p>");
                }
                out.println("</body></html>");

                // Close the resources
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (ClassNotFoundException | SQLException e) {
                (e).printStackTrace();
            }
        } else {
            out.println("<p>Please enter a valid product ID.</p>");
        }
	}
}
	


