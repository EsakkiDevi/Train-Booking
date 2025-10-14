<%@ page import="java.util.*,model.Booking" %> 
<% List<Booking> bookings = (List<Booking>)request.getAttribute("bookings"); %> 
<html> 
<head> 
<title>My Bookings</title> 
<style> 
body 
{ 
font-family: 'Segoe UI', sans-serif; 
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
</style> 
</head> 
<body> 
<h2>My Bookings</h2> 
<table> 
<tr> 
<th>Booking ID</th>
<th>Train No</th>
<th>Seats</th>
<th>Quota</th>
<th>Status</th>
<th>Time</th> 
</tr> 
<% for(Booking b: bookings){ %> 
<tr> 
<td><%=b.getBookingId()%></td> <
<td><%=b.getTrainNo()%></td> 
<td><%=b.getSeatsBooked()%></td> 
<td><%=b.getQuota()%></td> 
<td><%=b.getPaymentStatus()%></td> 
<td><%=b.getBookingTime()%></td> 
</tr> <% } %> 
</table> 
</body> 
</html>