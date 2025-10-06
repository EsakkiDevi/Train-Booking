<%@ page import="java.util.*, model.Station, model.Train" %>
<%@ page session="true" %>
<%
    String username = (String) session.getAttribute("username");
    if(username == null){ response.sendRedirect("login.jsp"); return; }

    List<Station> stations = (List<Station>) request.getAttribute("stations");
    List<Train> trains = (List<Train>) request.getAttribute("trains");

    // Today's date
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
    String today = sdf.format(new Date());
%>
<html>
<head>
<title>Train Dashboard</title>
<style>
body { font-family: Arial; background:#eef2f3; margin:0; padding:0; }
.container { width:90%; margin:20px auto; background:white; padding:20px; border-radius:10px; }
h2 { text-align:center; color:#333; }
form { text-align:center; margin-bottom:20px; }
select, button, input[type="date"] { padding:10px; margin:10px; width:200px; border-radius:5px; border:1px solid #ccc; }
button { background:#4CAF50; color:white; border:none; cursor:pointer; font-weight:bold; }
button:hover { background:#45a049; }
table { width:100%; border-collapse:collapse; }
th, td { border:1px solid #ddd; padding:10px; text-align:center; }
th { background:#4CAF50; color:white; }
tr:nth-child(even) { background:#f9f9f9; }
</style>
</head>
<body>
<div class="container">
<h2>Welcome, <%= username %>!</h2>

<!-- 🔍 Search Form -->
<form method="post" action="DashboardServlet">
  <!-- From Station -->
    <select name="from" required>
        <option value="">--Select Source--</option>
        <% for(Station s : stations) { %>
            <option value="<%= s.getCode() %>" 
                <%= (request.getParameter("from") != null && request.getParameter("from").equals(s.getCode())) ? "selected" : "" %>>
                <%= s.getName() %> - <%= s.getCode() %>
            </option>
        <% } %>
    </select>

    <!-- To Station -->
    <select name="to" required>
        <option value="">--Select Destination--</option>
        <% for(Station s : stations) { %>
            <option value="<%= s.getCode() %>" 
                <%= (request.getParameter("to") != null && request.getParameter("to").equals(s.getCode())) ? "selected" : "" %>>
                <%= s.getName() %> - <%= s.getCode() %>
            </option>
        <% } %>
    </select>

  <!-- Travel Date -->
  <input type="date" name="travelDate" required min="<%= today %>">

  <button type="submit">Search Trains</button>
</form>

<!-- 🚆 Train List Table -->
<% if(trains != null && !trains.isEmpty()){ %>
  <h3 style="text-align:center;">Available Trains</h3>
  <table>
    <tr>
      <th>Train No</th><th>Name</th><th>Departure</th><th>Arrival</th>
      <th>Duration</th><th>Seats</th><th>From</th><th>To</th><th>Book</th>
    </tr>
    <% for(Train t : trains){ %>
      <tr>
        <td><%= t.getTrainNo() %></td>
        <td><%= t.getName() %></td>
        <td><%= t.getDepartureTime() %></td>
        <td><%= t.getArrivalTime() %></td>
        <td><%= t.getDuration() %></td>
        <td><%= t.getSeatsAvailable() %></td>
        <td><%= t.getSource() %></td>
        <td><%= t.getDestination() %></td>
        <td>
          <form method="get" action="booking.jsp">
            <input type="hidden" name="trainNo" value="<%= t.getTrainNo() %>"/>
            <input type="hidden" name="trainName" value="<%= t.getName() %>"/>
            <input type="hidden" name="departure" value="<%= t.getDepartureTime() %>"/>
            <input type="hidden" name="arrival" value="<%= t.getArrivalTime() %>"/>
            <input type="hidden" name="duration" value="<%= t.getDuration() %>"/>
            <input type="hidden" name="seatsAvailable" value="<%= t.getSeatsAvailable() %>"/>
            <input type="hidden" name="source" value="<%= t.getSource() %>"/>
            <input type="hidden" name="destination" value="<%= t.getDestination() %>"/>
            <input type="hidden" name="travelDate" value="<%= request.getParameter("travelDate") %>"/>
            <button type="submit">Book</button>
          </form>
        </td>
      </tr>
    <% } %>
  </table>
<% } else if(request.getParameter("from") != null){ %>
  <p style="text-align:center;">No trains found for this route.</p>
<% } %>

</div>
</body>
</html>
