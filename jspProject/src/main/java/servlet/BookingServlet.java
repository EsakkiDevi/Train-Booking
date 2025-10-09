package servlet; 
import javax.servlet.*; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.*; 
import java.io.*; 
@WebServlet("/BookingServlet") 
public class BookingServlet extends HttpServlet { 
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{ 
		int trainNo = Integer.parseInt(req.getParameter("trainNo")); 
		req.setAttribute("trainNo", trainNo); 
		RequestDispatcher rd = req.getRequestDispatcher("bookTrain.jsp"); 
		rd.forward(req, res); 
		} 
	}