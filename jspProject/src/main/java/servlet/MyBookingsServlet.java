package servlet; 
import javax.servlet.*; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.*; 
import java.io.*; 
import java.util.*; 
import dao.Bookingdao; 
import model.Booking; 
@WebServlet("/MyBookingsServlet") 
public class MyBookingsServlet extends HttpServlet 
{ 
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{ 
		String username = "user1"; 
		Bookingdao dao = new Bookingdao(); 
		List<Booking> bookings = dao.getBookingsByUser(username); 
		req.setAttribute("bookings", bookings); 
		RequestDispatcher rd = req.getRequestDispatcher("myBookings.jsp"); 
		rd.forward(req, res); 
		} 
	}