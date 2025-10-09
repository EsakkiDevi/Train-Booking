<%@ page import="dao.Stationsdao,model.Station,java.util.*" %> 
<% Stationsdao dao = new Stationsdao(); 
List<Station> stations = dao.getAllStations(); %> 
<html> 
<head> 
<title>Book Ticket</title> 
<style> 
body 
{ 
font-family: 'Segoe UI', sans-serif; 
background: #f4f6f9; 
display: flex; 
justify-content: center; 
align-items: center; height: 100vh; 
} 
form
 { 
 background: #fff; 
 padding: 30px 40px; 
 border-radius: 10px; 
 box-shadow: 0 4px 10px rgba(0,0,0,0.1); 
 } 
 h2
  { 
  text-align: center; 
  color: #333; 
  } 
  select, input[type=date], input[type=submit] 
  { 
  width: 100%; 
  padding: 10px; 
  margin: 10px 0; 
  border: 1px solid #ccc; 
  border-radius: 6px; 
  } 
  input[type=submit] 
  { 
  background: #5563DE; 
  color: #fff; 
  border: none; 
  cursor: pointer; 
  font-weight: bold; 
  } 
  input[type=submit]:hover 
  { 
  background: #3b4cc0; 
  } 
  </style> 
  </head> 
  <body> 
  <form action="TrainServlet" method="post"> 
  <h2>Search Trains</h2> 
  <label>From:</label> 
  <select name="from"> 
  <% for(Station s: stations){ %> 
  <option value="<%=s.getStncode()%>"><%=s.getStnname()%></option> <% } %> 
  </select> 
  <label>To:</label> 
  <select name="to"> <% for(Station s: stations){ %> 
  <option value="<%=s.getStncode()%>"><%=s.getStnname()%></option> <% } %> 
  </select> 
  <label>Date:</label> 
  <input type="date" name="date" min="<%=java.time.LocalDate.now()%>"> 
  <input type="submit" value="Search"> 
  </form> 
  </body> 
  </html>