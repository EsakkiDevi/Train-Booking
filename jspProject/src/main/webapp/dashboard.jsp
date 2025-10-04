<%@ page import="java.util.List" %>
<%@ page import="model.Station" %>
<%@ page import="dao.Stationsdao" %>
<%@ page import="model.Train" %>
<%@ page session="true" %>
<%
    // Session check
    String username = (String) session.getAttribute("username");
    if(username == null){
        response.sendRedirect("login.jsp");
        return;
    }

    // Fetch all stations for dropdown
    Stationsdao sdao = new Stationsdao();
    List<Station> stations = sdao.getAllStations();

    // Fetch trains if search submitted
    List<Train> trains = (List<Train>) request.getAttribute("trains");
%>

<html>
<head>
    <title>Train Dashboard</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        h2 { text-align: center; }
        .search-bar { display: flex; gap: 10px; flex-wrap: wrap; justify-content: center; margin-bottom: 20px; }
        select, input[type="date"] { padding: 6px; font-size: 14px; max-height: 150px; overflow-y: auto; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        table th, table td { padding: 10px; text-align: center; border: 1px solid #ccc; }
        button { padding: 5px 10px; cursor: pointer; }
    </style>
</head>
<body>

<h2>Hello, <%= username %>! Search Trains</h2>

<!-- Search Form -->
<form method="get" action="TrainServlet" class="search-bar">
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
    <input type="date" name="date" value="<%= request.getParameter("date") != null ? request.getParameter("date") : "" %>" 
           min="<%= java.time.LocalDate.now() %>" required/>

    <button type="submit">Search</button>
</form>

<!-- Train Table -->
<table>
    <thead>
        <tr>
            <th>Train No</th>
            <th>Name</th>
            <th>Departure</th>
            <th>Arrival</th>
            <th>Distance</th>
            <th>Seats</th>
            <th>Book</th>
        </tr>
    </thead>
    <tbody>
        <% if(trains != null && !trains.isEmpty()) {
            for(Train t : trains) { %>
                <tr>
                    <td><%= t.getTrainNo() %></td>
                    <td><%= t.getName() %></td>
                    <td><%= t.getDepartureTime() %></td>
                    <td><%= t.getArrivalTime() %></td>
                    <td><%= t.getDuration() %></td>
                    <td><%= t.getSeatsAvailable() %></td>
                    <td><button onclick="alert('Booked <%= t.getTrainNo() %>')">Book</button></td>
                </tr>
        <%   } 
           } else if(request.getParameter("from") != null) { %>
                <tr><td colspan="7">No trains found</td></tr>
        <% } %>
    </tbody>
</table>

</body>
</html>
