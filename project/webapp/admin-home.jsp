<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="pack1.RailwayCrossing"%>
<%@ page import="pack1.RailwayCrossingDAO"%>
<%@ page import="java.util.List"%>
<%
// Create an instance of RailwayCrossingDAO
RailwayCrossingDAO crossingDAO = new RailwayCrossingDAO();
// Retrieve all crossings from the DAO
List<RailwayCrossing> crossings = crossingDAO.getAllCrossings();
// Get the ID from the search request parameter
String searchId = request.getParameter("searchId");
// Check if the searchId parameter is provided
if (searchId != null && !searchId.isEmpty()) {
// Parse the searchId as an int
int crossingId = Integer.parseInt(searchId);
// Retrieve the crossing by ID from the DAO
RailwayCrossing searchedCrossing = 
crossingDAO.getCrossingById(crossingId);
// Set the crossing as an attribute to be displayed in the table
request.setAttribute("crossing", searchedCrossing);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>admin home page</title>
<style>
 table {
 width: 100%;
 border-collapse: collapse;
 }
 th, td {
 padding: 8px;
 text-align: left;
 border-bottom: 1px solid #ddd;
 }
 th {
 background-color: #f2f2f2;
 }
 </style>
</head>
<body>
<h1>Admin Home Page</h1>
<form action="homepage.jsp" method="post">
</form>
<a href="add-crossing.jsp">add</a><br>
<form action="SearchCrossing" method="post"><br>
<input type="text" name="searchId" placeholder="Enter ID">
<button type="submit">Search Crossing</button>
</form>
<br>
<a href="admin-home">Display</a><br>
<form action="admin-login.jsp" method="post"><br>
<button type="submit">Logout</button>
</form>
<!-- Table -->
<table>
<thead>
<tr>
<th>Sr.No</th>
<th>Name</th>
<th>Address</th>
<th>Landmark</th>
<th>Train Schedule</th>
<th>Person In-Charge</th>
<th>Status</th>
<th>Action</th>
</tr>
</thead>
<tbody>
<%if (request.getAttribute("crossing") != null){// Check if a specific crossing is found 
	RailwayCrossing crossing = (RailwayCrossing)request.getAttribute("crossing");
	%>
<tr>
<td><%=crossing.getId()%></td>
<td><%=crossing.getName()%></td>
<td><%=crossing.getAddress()%></td>
<td><%=crossing.getLandmark()%></td>
<td><%=crossing.getTrainSchedule()%></td>
<td><%=crossing.getPersonInCharge()%></td>
<td><%=crossing.getStatus()%></td>
<td></td>
</tr>
<%
} else { // Display all crossings
for (RailwayCrossing anotherCrossing : crossings) {
%>
<tr>
<td><%=anotherCrossing.getId()%></td>
<td><%=anotherCrossing.getName()%></td>
<td><%=anotherCrossing.getAddress()%></td>
<td><%=anotherCrossing.getLandmark()%></td>
<td><%=anotherCrossing.getTrainSchedule()%></td>
<td><%=anotherCrossing.getPersonInCharge()%></td>
<td><%=anotherCrossing.getStatus()%></td>
<td>
<form action="update-crossing.jsp"
method="post">
<input type="hidden" name="id"
value="<%=anotherCrossing.getId()%>">
<button type="submit" class="updatebutton">Update</button>
</form>
<form action="DeleteCrossing" method="post">
<input type="hidden" name="id"
value="<%=anotherCrossing.getId()%>">
<button type="submit" class="deletebutton">Delete</button>
</form>
</tr>
<%
}
}
%>
</tbody>
</table>
</body>
</html>