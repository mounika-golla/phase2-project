package pack1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AddCrossing extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Retrieve the form data from the request
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String landmark = request.getParameter("landmark");
		String trainSchedules = request.getParameter("train_schedules");
		String personInCharge = request.getParameter("person_in_charge");
		String status = request.getParameter("status");
		// Create a new RailwayCrossing object with the form data
		RailwayCrossing crossing = new RailwayCrossing();
		crossing.setName(name);
		crossing.setAddress(address);
		crossing.setLandmark(landmark);
		crossing.setTrainSchedule(trainSchedules);
		crossing.setPersonInCharge(personInCharge);
		crossing.setStatus(status);
		// Save the new crossing to the database
		RailwayCrossingDAO crossingDAO = new RailwayCrossingDAO();
		crossingDAO.addCrossing(crossing);
		// Redirect to the admin homepage after adding the crossing
		response.sendRedirect("admin-home.jsp");
		}
}
