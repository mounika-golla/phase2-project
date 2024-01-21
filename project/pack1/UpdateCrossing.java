package pack1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class UpdateCrossing extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			// Retrieve the crossing ID from the hidden field
			String idParam = request.getParameter("crossingId");
			if (idParam != null && !idParam.isEmpty()) {
			int crossingId = Integer.parseInt(idParam);
			// Retrieve the updated details for the crossing
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String landmark = request.getParameter("landmark");
			String trainSchedules = 
			request.getParameter("trainSchedules");
			String personInCharge = 
			request.getParameter("personInCharge");
			String status = request.getParameter("status");
			// Create a new RailwayCrossing object with the updated details
			RailwayCrossing updatedCrossing = new
			RailwayCrossing();
			updatedCrossing.setId(crossingId);
			updatedCrossing.setName(name);
			updatedCrossing.setAddress(address);
			updatedCrossing.setLandmark(landmark);
			updatedCrossing.setTrainSchedule(trainSchedules);
			updatedCrossing.setPersonInCharge(personInCharge);
			updatedCrossing.setStatus(status);
			// Perform the update operation
			RailwayCrossingDAO crossingDAO = new
			RailwayCrossingDAO();
			crossingDAO.updateCrossing(updatedCrossing);
			// Redirect to the admin homepage after the update
			response.sendRedirect("admin-home.jsp");
			} else {
			// Handle case where idParam is empty or null
			throw new ServletException("Crossing ID is missing.");
			}
			} catch (NumberFormatException e) {
			// Handle case where idParam is not a valid integer
			throw new ServletException("Invalid Crossing ID format.", e);
			} catch (Exception e) {
			// Handle other exceptions
			throw new ServletException("An error occurred during the crossing update.", e);
			}
			}

	}
