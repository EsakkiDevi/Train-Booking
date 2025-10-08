<%@ page import="java.util.*, model.Station, model.Train" %>
<%@ page session="true" %>
<%
    String username = (String) session.getAttribute("username");
    if(username == null){ response.sendRedirect("login.jsp"); return; }

    List<Station> stations = (List<Station>) request.getAttribute("stations");
    List<Train> trains = (List<Train>) request.getAttribute("trains");
    String errorMsg = (String) request.getAttribute("errorMsg");
%>
<html>
<head>
<title>Dashboard - Train Booking</title>
<link rel="stylesheet" href="styles/dashboard.css">
</head>
<body>
<div class="container">
<h2>Welcome, <%= username %></h2>

<form action="DashboardServlet" method="post">
  <label>From:</label>
  <select name="from" required>
    <option value="">--Select Source--</option>
    <% if(stations != null){ 
         for(Station s : stations){ %>
           <option value="<%= s.getCode() %>"><%= s.getCity() %></option>
    <% } } %>
  </select>

  <label>To:</label>
  <select name="to" required>
    <option value="">--Select Destination--</option>
    <% if(stations != null){ 
         for(Station s : stations){ %>
           <option value="<%= s.getCode() %>"><%= s.getCity() %></option>
    <% } } %>
  </select>

  <label>Date of Journey:</label>
  <input type="date" name="travelDate" min="<%= java.time.LocalDate.now() %>" required>

  <button type="submit">Search</button>
</form>

<% if(errorMsg != null){ %>
  <p style="color:red"><%= errorMsg %></p>
<% } %>

<% if(trains != null && !trains.isEmpty()){ %>
  <h3>Available Trains</h3>
  <table border="1" cellpadding="6">
    <tr>
      <th>Train No</th><th>Name</th><th>From</th><th>To</th>
      <th>Departure</th><th>Arrival</th><th>Seats</th><th>Action</th>
    </tr>
    <% for(Train t : trains){ %>
      <tr>
        <td><%= t.getTrainNo() %></td>
        <td><%= t.getName() %></td>
        <td><%= t.getSource() %></td>
        <td><%= t.getDestination() %></td>
        <td><%= t.getDepartureTime() %></td>
        <td><%= t.getArrivalTime() %></td>
        <td><%= t.getSeatsAvailable() %></td>
        <td>
          <form action="booking.jsp" method="get">
            <input type="hidden" name="trainNo" value="<%= t.getTrainNo() %>">
            <input type="hidden" name="trainName" value="<%= t.getName() %>">
            <input type="hidden" name="source" value="<%= t.getSource() %>">
            <input type="hidden" name="destination" value="<%= t.getDestination() %>">
            <input type="hidden" name="departure" value="<%= t.getDepartureTime() %>">
            <input type="hidden" name="arrival" value="<%= t.getArrivalTime() %>">
            <input type="hidden" name="seatsAvailable" value="<%= t.getSeatsAvailable() %>">
            <button type="submit">Book</button>
          </form>
        </td>
      </tr>
    <% } %>
  </table>
<% } else if(trains != null){ %>
  <p>No trains found for the selected route.</p>
<% } %>

</div>
</body>
</html>
