<%@ page session="true" %>
<%
String username = (String) session.getAttribute("username");
if(username == null){ response.sendRedirect("login.jsp"); return; }

String trainNo = request.getParameter("trainNo");
String trainName = request.getParameter("trainName");
String source = request.getParameter("source");
String destination = request.getParameter("destination");
String departure = request.getParameter("departure");
String arrival = request.getParameter("arrival");
String seatsAvailable = request.getParameter("seatsAvailable");
%>

<html>
<head>
<title>Passenger Details</title>
<link rel="stylesheet" href="styles/booking.css">
</head>
<body>
<div class="container">
<h2>Enter Passenger Details</h2>
<form action="PassengerServlet" method="post">
  <input type="hidden" name="trainNo" value="<%= trainNo %>">
  <input type="hidden" name="trainName" value="<%= trainName %>">
  <input type="hidden" name="source" value="<%= source %>">
  <input type="hidden" name="destination" value="<%= destination %>">
  <input type="hidden" name="departure" value="<%= departure %>">
  <input type="hidden" name="arrival" value="<%= arrival %>">
  <input type="hidden" name="seatsAvailable" value="<%= seatsAvailable %>">
  <input type="hidden" name="username" value="<%= username %>">

  <label>Class:</label>
  <select name="trainClass" required>
    <option value="Sleeper">Sleeper</option>
    <option value="3A">3A</option>
    <option value="2A">2A</option>
    <option value="1A">1A</option>
  </select>

  <label>Quota:</label>
  <select name="quota" required>
    <option value="General">General</option>
    <option value="Tatkal">Tatkal</option>
    <option value="Ladies">Ladies</option>
  </select>

  <label>No of Passengers:</label>
  <input type="number" name="seats" min="1" max="<%= seatsAvailable %>" required>

  <h3>Passenger Info</h3>
  <div>
    <input type="text" name="passengerName" placeholder="Name" required>
    <input type="number" name="age" placeholder="Age" required>
    <select name="gender">
      <option>Male</option>
      <option>Female</option>
    </select>
  </div>

  <button type="submit">Proceed to Payment</button>
</form>
</div>
</body>
</html>
