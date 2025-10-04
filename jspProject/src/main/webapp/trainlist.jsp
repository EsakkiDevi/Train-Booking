<% List<Train> trains = (List<Train>) request.getAttribute("trains"); %>
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
<% } } else { %>
<tr><td colspan="7">No trains found</td></tr>
<% } %>
</tbody>
