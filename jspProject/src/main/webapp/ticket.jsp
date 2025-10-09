<%@ page import="java.util.*,model.Passenger,model.Booking,model.Train" %>
 <html> 
 <head> 
 <title>Ticket Confirmation</title> 
 <style> 
 body 
 { 
 font-family: 'Segoe UI', sans-serif; 
 background: linear-gradient(135deg, #74ABE2, #5563DE); 
 color: #fff; 
 display: flex; 
 justify-content: center; 
 align-items: center; 
 height: 100vh; } 
 .ticket 
 { 
 background: rgba(255,255,255,0.15); 
 padding: 30px 50px; 
 border-radius: 10px; 
 text-align: left; 
 box-shadow: 0 4px 10px rgba(0,0,0,0.3); width: 750px; } 
 .header 
 { 
 text-align: center; 
 margin-bottom: 20px; 
 } 
 h2 
 {
 margin-bottom: 10px; 
 } 
 .details, .passenger-table 
 { 
 width: 100%; 
 margin-top: 10px; 
 } 
 .details td 
 { 
 padding: 5px 10px; 
 } 
 .passenger-table 
 { 
 border-collapse: collapse; margin-top: 20px; 
 } 
 .passenger-table th, .passenger-table td 
 { 
 border: 1px solid rgba(255,255,255,0.3); 
 padding: 8px; 
 text-align: center; 
 } 
 .passenger-table th 
 { 
 background: rgba(255,255,255,0.2); 
 } 
 .footer 
 { 
 text-align: center; margin-top: 20px; font-size: 16px; 
 } 
 </style> 
 </head> 
 <body> 
 <% Booking booking = (Booking)request.getAttribute("booking"); 
 Train train = (Train)request.getAttribute("train"); 
 List<Passenger> passengers = (List<Passenger>)request.getAttribute("passengers"); 
 //if(booking == null) booking = new Booking(); 
 //if(train == null) train = new Train(); 
 //if(passengers == null) passengers = new ArrayList<>(); %> 
 <div class="ticket"> 
 <div class="header"> 
 <h2>Zoho Rail E-Ticket</h2> 
 <p>Booking Confirmation</p> 
 </div> 
 <table class="details"> 
 <tr>
 <td><strong>Booking ID:</strong></td><td><%=booking.getBookingId()%></td></tr> 
 <tr><td><strong>Train No:</strong></td><td><%=train.getTrainNo()%></td></tr> 
 <tr><td><strong>Train Name:</strong></td><td><%=train.getName()%></td></tr> 
 <tr><td><strong>Source:</strong></td><td><%=train.getSource()%></td></tr> 
 <tr><td><strong>Destination:</strong></td><td><%=train.getDestination()%></td></tr> 
 <tr><td><strong>Departure Time:</strong></td><td><%=train.getDepartureTime()%></td></tr> 
 <tr><td><strong>Arrival Time:</strong></td><td><%=train.getArrivalTime()%></td></tr> 
 <tr><td><strong>Duration:</strong></td><td><%=train.getDuration()%></td></tr> 
 <tr><td><strong>Seats Booked:</strong></td><td><%=booking.getSeatsBooked()%></td></tr> 
 <tr><td><strong>Quota:</strong></td><td><%=booking.getQuota()%></td></tr> 
 <tr><td><strong>Payment Status:</strong></td><td><%=booking.getPaymentStatus()%></td></tr> 
 </table> 
 <h3 style="margin-top:20px;">Passenger Details</h3> 
 <table class="passenger-table"> 
 <tr> 
 <th>Name</th> 
 <th>Age</th> 
 <th>Gender</th> 
 <th>Category</th> 
 <th>Fare (₹)</th> 
 </tr> 
 <% if(passengers.size() > 0)
 { 
	 for(Passenger p : passengers)
	 { 
		 String category; 
		 if(p.getAge() < 12) 
			 category = "Child"; 
		 else if(p.getAge() >= 60) 
			 category = "Senior Citizen"; 
		 else category = "Adult"; %> 
		 <tr> 
		 <td><%=p.getName()%></td> 
		 <td><%=p.getAge()%></td> 
		 <td><%=p.getGender()%></td> 
		 <td><%=category%></td> 
		 <td><%=String.format("%.2f", p.getFare())%></td> 
		 </tr> 
		 <% 
		 } 
	 } 
 else 
 { %> 
 <tr>
 <td colspan="5">No passenger details available</td></tr> <% } %> 
 </table> 
 <div class="footer"> <p>Thank you for booking with Indian Railways</p> <p>Have a safe and pleasant journey!</p> </div> </div> 
 </body> 
 </html>