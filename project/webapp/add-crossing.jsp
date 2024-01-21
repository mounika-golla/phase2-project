<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Railway Crossings</h2>
<h4>Add Railway Crossing Information</h4>
<form action="Addcrossing" method="post">
<label for="name">Enter Name</label> <input type="text"
id="name"
name="name" required><br> <label
for="address">Address</label>
<input type="text" id="address" name="address"
required><br>
<label for="landmark">Landmark</label> <input type="text"
id="landmark" name="landmark" required><br> <label
for="trainSchedules">Train Schedules</label> <input
type="text"
id="trainSchedules" name="trainSchedules"
required><br>
<label for="personInCharge">Person in Charge</label> <input
type="text" id="personInCharge"
name="personInCharge" required><br>
<label for="status">Crossing Status</label> <select id="status"
name="status">
<option value="Open">Open</option>
<option value="Closed">Closed</option>
</select><br>
<button type="submit">Submit</button>
</form>
</body>
</html>