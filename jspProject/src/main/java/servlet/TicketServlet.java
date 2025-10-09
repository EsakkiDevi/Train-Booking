
package servlet; 
import javax.servlet.*; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.*; 
import java.io.*; 
@WebServlet("/TicketServlet") 
public class TicketServlet extends HttpServlet { 
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException 
	{ 
		req.setAttribute("paymentStatus", "SUCCESS"); 
		RequestDispatcher rd = req.getRequestDispatcher("ticket.jsp"); 
		rd.forward(req, res); 
		} 
	}