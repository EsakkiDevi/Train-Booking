<html> 
<head> 
<title>Book Train</title> 
<style> 
body 
{ 
font-family: 'Segoe UI', sans-serif; 
background: #f4f6f9; 
display: flex; 
justify-content: center; 
align-items: center; 
height: 100vh; 
} 
form 
{ 
background: #fff; 
padding: 30px 40px; 
border-radius: 10px; 
box-shadow: 0 4px 10px rgba(0,0,0,0.1); 
width: 600px; 
} 
h3
 { 
 text-align: center; 
 color: #333; 
 } 
 input, select 
 { 
 width: 100%; 
 padding: 10px; 
 margin: 8px 0; 
 border: 1px solid #ccc; 
 border-radius: 6px; 
 } 
 button, input[type=submit] 
 { 
 background: #5563DE; 
 color: #fff; 
 border: none; 
 padding: 10px; 
 border-radius: 6px; 
 cursor: pointer; 
 font-weight: bold; 
 } 
 button:hover, input[type=submit]:hover 
 { 
 background: #3b4cc0; 
 } 
 .passenger 
 { 
 border: 1px solid #ddd; 
 padding: 10px; 
 margin-top: 10px; 
 border-radius: 6px; 
 position: relative; 
 } 
 .remove-btn 
 { 
 position: absolute; 
 top: 5px; 
 right: 5px; 
 background: #ff4d4d; 
 color: #fff; 
 border: none; 
 border-radius: 50%; 
 width: 25px; 
 height: 25px; 
 cursor: pointer; 
 font-weight: bold; 
 } 
 .remove-btn:hover 
 { 
 background: #e60000; 
 } 
 .add-btn 
 { 
 background: #28a745; 
 color: #fff; 
 border: none; 
 padding: 8px 15px; 
 border-radius: 6px; 
 cursor: pointer; 
 font-weight: bold; 
 } 
 .add-btn:hover 
 { 
 background: #218838; 
 } 
 </style> 
 <script> 
 function addPassengerRow() 
 { 
const container = document.getElementById('passengerContainer'); 
 const div = document.createElement('div'); 
 div.className = 'passenger'; 
 div.innerHTML = ` <button type="button" class="remove-btn" onclick="removePassenger(this)">−</button> 
 <h4>Passenger</h4> 
 <label>Name:</label>
 <input type="text" name="pname" required> 
 <label>Age:</label>
 <input type="number" name="page" required> 
 <label>Gender:</label> 
 <select name="pgender" value="select"> 
 <option>Male</option> 
 <option>Female</option> 
 <option>Others</option> 
 </select> 
 <label>Category:</label> 
 <select name="pcategory" value="select"> 
 <option>Adult</option> 
 <option>Child</option> 
 <option>Senior</option> 
 </select> `; container.appendChild(div); 
 } 
 function removePassenger(btn) 
 { 
	 const container = document.getElementById('passengerContainer'); 
	 container.removeChild(btn.parentNode); 
	 } 
 </script> 
 </head>
  <body> 
  <form action="PassengerServlet" method="post"> 
  <h3>Book Train</h3> Train No: <%=request.getAttribute("trainNo")%><br><br> 
  <label>Seats:</label> 
  <input type="number" id="seatCount" name="seats" min="1" required><br> 
  <label>Quota:</label> 
  <select name="quota"> 
  <option>General</option> 
  <option>Tatkal</option> 
  <option>Ladies</option> 
  </select><br> 
  <label>Class:</label> 
  <select name="class"> 
  <option>AC</option> 
  <option>2AC</option> 
  <option>Sleeper</option> 
  </select><br>
   <h4>Passenger Details</h4>
    <div id="passengerContainer"></div> <br>
     <button type="button" class="add-btn" onclick="addPassengerRow()">+ Add Passenger</button><br><br> 
     <input type="hidden" name="trainNo" value="<%=request.getAttribute("trainNo")%>"> 
     <input type="submit" value="Proceed to Payment"> </form> 
     </body> 
     </html>