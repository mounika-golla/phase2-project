package com.ecommerce;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


public class ProductEntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ProductEntryServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// Retrieve form data
        String productName = request.getParameter("productName");
        double price = Double.parseDouble(request.getParameter("price"));

        // Create a Product object
        Product product = new Product();
        product.setProductName(productName);
        product.setPrice(price);

        // Store the product in the session
        HttpSession session = request.getSession();
        session.setAttribute("product", product);

        // Redirect to the next JSP page
        response.sendRedirect("productDisplay.jsp");
	}

}
