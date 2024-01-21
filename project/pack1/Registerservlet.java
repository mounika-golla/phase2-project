package pack1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Registerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Retrieve the form data
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		// Create a new User object
		userdetails user = new userdetails(name, email, password);
		// Store the user in the database
		userDAO userDAO = new userDAO();
		userDAO.registerUser(user);
		// Redirect to a success page or perform any other necessary actions
		response.sendRedirect("login.jsp");
		}

	}
