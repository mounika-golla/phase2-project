package pack1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SearchCrossing extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SearchCrossing() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Retrieve the search ID from the request
		int searchId = Integer.parseInt(request.getParameter("searchId"));
		// Implement your logic to search for the crossing by ID and retrieve its
		// details from the database
		RailwayCrossingDAO crossingDAO = new RailwayCrossingDAO();
		RailwayCrossing crossing = crossingDAO.getCrossingById(searchId);
		// Set the search result in the request attribute
		request.setAttribute("crossing", crossing);
		// Redirect to the admin homepage with the search results
		request.getRequestDispatcher("admin-home.jsp").forward(request, 
		response);

	}

}
