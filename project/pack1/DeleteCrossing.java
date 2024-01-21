package pack1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class DeleteCrossing extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Retrieve the crossing ID from the request
		int crossingId = Integer.parseInt(request.getParameter("id"));
		// Perform the delete operation (implement your logic)
		RailwayCrossingDAO crossingDAO = new RailwayCrossingDAO();
		crossingDAO.deleteCrossing(crossingId);
		// Redirect to the admin homepage after the deletion
		response.sendRedirect("admin-home.jsp");
	}

}
