package pack1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Adminloginpage extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	private static final String ADMIN_ID = "pranee@gmail.com";
	 private static final String ADMIN_PASSWORD = "pranee1617";

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		 String password = request.getParameter("password");
		 if (email != null && email.equals(ADMIN_ID) && password != null && 
		password.equals(ADMIN_PASSWORD)) {
		 response.sendRedirect("admin-home.jsp");
		 } else {
		 request.getRequestDispatcher("admin-login.jsp").forward(request, 
		response);
		 }

	}

}
