package pack1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemoveFavouriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String crossingId = request.getParameter("crossingId");
		if (crossingId != null && !crossingId.isEmpty()) {
		int railwayCrossingId = Integer.parseInt(crossingId);
		// Perform the database operation to remove the crossing from favorites
		RailwayCrossingDAO crossingDAO = new
		RailwayCrossingDAO();
		crossingDAO.removeFromFavorites(railwayCrossingId); // Implement this method in RailwayCrossingDAO
		}
		// Redirect back to the userHome.jsp page
		response.sendRedirect("user-home.jsp");
		}
		
	}
