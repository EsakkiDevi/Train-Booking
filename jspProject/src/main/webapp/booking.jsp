<%@ page session="true" %>
<%
    String username = (String) session.getAttribute("username");
    if(username == null){ response.sendRedirect("login.jsp"); return; }

    String trainNo = request.getParameter("trainNo");
    String trainName = request.getParameter("trainName");
    String departure = request.getParameter("departure");
    String arrival = request.getParameter("arrival");
    String duration = request.getParameter("duration");
    String seatsAvailable = request.getParameter("seatsAvailable");
    String source = request.getParameter("source");
    String destination = request.getParameter("destination");

    if(trainNo == null){ response.sendRedirect("dashboard.jsp"); return; }
%>

<html>
<head>
<title>Book Train Ticket</title>
<style>
body { font-family: 'Segoe UI', sans-serif; background:#e8f0fe; }
.container { width:400px; margin:40px auto; background:white; padding:20px; border-radius:10px; box-shadow:0 0 10px #ccc; }
h2 { text-align:center; color:#333; }
table { width:100%; margin-bottom:15px; }
td { padding:8px; }
input, select, button { width:100%; padding:8px; margin:6px 0; border:1px solid #ccc; border-radius:5px; }
button { background:#4CAF50; color:white; cursor:pointer; }
button:hover { background:#45a049; }
</style>
</head>
<body>
<div class="container">
<h2>Booking Details</h2>

<table>
<tr><td>Train No:</td><td><%= trainNo %></td></tr>
<tr><td>Name:</td><td><%= trainName %></td></tr>
<tr><td>From:</td><td><%= source %></td></tr>
<tr><td>To:</td><td><%= destination %></td></tr>
<tr><td>Departure:</td><td><%= departure %></td></tr>
<tr><td>Arrival:</td><td><%= arrival %></td></tr>
<tr><td>Available Seats:</td><td><%= seatsAvailable %></td></tr>
</table>

<form action="payment.jsp" method="get">
    <label>Seats to Book:</label>
    <input type="number" name="seats" min="1" max="<%= seatsAvailable %>" required>

    <label>Quota:</label>
    <select name="quota" required>
        <option value="General">General</option>
        <option value="Tatkal">Tatkal</option>
        <option value="Ladies">Ladies</option>
        <option value="Senior">Senior Citizen</option>
    </select>

    <!-- Hidden fields to send train details -->
    <input type="hidden" name="trainNo" value="<%= trainNo %>">
    <input type="hidden" name="trainName" value="<%= trainName %>">
    <input type="hidden" name="departure" value="<%= departure %>">
    <input type="hidden" name="arrival" value="<%= arrival %>">
    <input type="hidden" name="duration" value="<%= duration %>">
    <input type="hidden" name="source" value="<%= source %>">
    <input type="hidden" name="destination" value="<%= destination %>">
    <input type="hidden" name="seatsAvailable" value="<%= seatsAvailable %>">

    <button type="submit">Confirm Booking</button>
</form>
</div>
</body>
</html>
