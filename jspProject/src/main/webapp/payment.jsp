<html> <head> 
<title>Payment</title> 
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
 width: 350px; 
 } 
 h3 
 { 
 text-align: center; 
 color: #333; 
 } 
 input[type=radio] 
 { 
 margin: 10px; 
 } 
 input[type=submit] 
 { 
 width: 100%; 
 background: #5563DE; 
 color: #fff; 
 border: none; 
 padding: 10px; 
 border-radius: 6px; 
 cursor: pointer; 
 font-weight: bold; } 
 input[type=submit]:hover 
 { 
 background: #3b4cc0; 
 } 
 </style> 
 </head> 
 <body> 
 <form action="PaymentServlet" method="post">
  <h3>Select Payment Method</h3>
  <label><input type="radio" name="method" value="UPI" required>UPI</label><br><br>
  <label><input type="radio" name="method" value="Wallet">Wallet</label><br><br>
  <label><input type="radio" name="method" value="Credit">Credit</label><br><br>
  <label><input type="radio" name="method" value="Debit">Debit</label><br><br><br>
  <input type="submit" value="Pay Now">
</form>
 </body> </html>