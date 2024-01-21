<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="pack1.RailwayCrossing"%>
<%@ page import="pack1.RailwayCrossingDAO"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Search Crossings</h2>
<!-- All crosings -->
<button onclick="location.href='user-home.jsp'"
class="allCrossing-button">All Crossings</button>
<!-- favourite crossing -->
<button onclick="location.href='user-home-favourite.jsp'"
class="favouriteCrossing-button">Favorite Crossings</button>
<!-- Search input -->
<div class="search-container">
<input type="text" id="searchInput" placeholder="Search by name"
onkeyup="searchCrossings()">
<button>search</button>
<!-- Logout button -->
<button onclick="location.href='login.jsp'" class="logoutbutton">Logout</button>
</div>
<!-- Search Results Container -->
<div class="search-results">
<%
RailwayCrossingDAO crossingDAO = new RailwayCrossingDAO();
List<RailwayCrossing> allCrossings = crossingDAO.getAllCrossings();
for (RailwayCrossing crossing : allCrossings) {
String status = crossing.getStatus();
String statusClass = status.equalsIgnoreCase("Open") ? "statusopen" : "status-closed";
%>
<div class="container crossing">
<h3><%=crossing.getName()%></h3>
<p>
Status: <strong><span class="status 
<%=statusClass%>"><%=crossing.getStatus()%></span></strong>
</p>
<p>
Person in Charge: 
<strong><%=crossing.getPersonInCharge()%></strong>
</p>
<p>
Train Schedules: 
<strong><%=crossing.getTrainSchedule()%></strong>
</p>
<p>
Landmark: 
<strong><%=crossing.getLandmark()%></strong>
</p>
<p>
Address: <strong><%=crossing.getAddress()%></strong>
</p>
<form action="AddFavouriteServlet" method="post"
style="display: inline;">
<input type="hidden" name="crossingId"
value="<%=crossing.getId()%>">
<button type="submit">ADD TO FAVORITES</button>
</form>
</div>
<%
}
%>

</body>
</html>