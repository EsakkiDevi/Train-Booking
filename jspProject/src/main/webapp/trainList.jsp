<%@ page import="java.util.*,model.Train" %> 
<% List<Train> trains = (List<Train>)request.getAttribute("trains"); %> 
<html> 
<head> 
<title>Available Trains</title> 
<style> 
body 
{ font-family: 'Segoe UI', sans-serif; 
background: #eef1f7; 
padding: 40px; 
} 
table 
{ 
width: 100%; 
border-collapse: collapse; 
background: #fff; 
box-shadow: 0 4px 10px rgba(0,0,0,0.1); 
} 
th, td 
{ 
padding: 12px; 
text-align: center; 
border-bottom: 1px solid #ddd; 
} 
th 
{ 
background: #5563DE; 
color: #fff; 
} 
tr:hover 
{ 
background: #f1f3ff; 
} 
input[type=submit] 
{ 
background: #5563DE; 
color: #fff; 
border: none; 
padding: 6px 12px; 
border-radius: 4px; cursor: pointer; 
} 
input[type=submit]:hover 
{ 
background: #3b4cc0; 
} 
</style> 
</head> 
<body> 
  <form action="TrainServlet" method="post"> 
<h2>Available Trains</h2> 
<table> 
<tr> 
<th>No</th>
<th>Name</th>
<th>Departure</th>
<th>Arrival</th>
<th>Duration</th>
<th>Seats</th>
<th>Fare</th>
<th>Action</th>
 </tr> 
 <% for(Train t: trains){ %> 
 <tr> 
 <td><%=t.getTrainNo()%></td> 
 <td><%=t.getName()%></td> 
 <td><%=t.getDepartureTime()%></td> 
 <td><%=t.getArrivalTime()%></td> 
 <td><%=t.getDuration()%></td> 
 <td><%=t.getSeatsAvailable()%></td> 
 <td>₹<%=t.getFare()%></td> 
 <td> 
 <form action="BookingServlet" method="post"> 
 <input type="hidden" name="trainNo" value="<%=t.getTrainNo()%>"> 
 <input type="submit" value="Book"> 
 </form> 
 </td> 
 </tr> <% } %> 
 </table> 
 </body> 
 </html>