package pack1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class Adminhomepage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RailwayCrossingDAO crossingDAO;
	public void init() {
	crossingDAO = new RailwayCrossingDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// Fetch all railway crossing details from the database
		List<RailwayCrossing> crossings = crossingDAO.getAllCrossings();
		// Pass the crossing details to the JSP page
		request.setAttribute("crossings", crossings);
		request.getRequestDispatcher("admin-home.jsp").forward(request, 
		response);
		}

}
