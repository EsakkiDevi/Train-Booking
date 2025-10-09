package servlet; 
import javax.servlet.*; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.*; 
import java.io.*; 
import java.util.*; 
import dao.Traindao; 
import model.Train; @WebServlet("/TrainServlet") 
public class TrainServlet extends HttpServlet { 
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{ 
		req.setCharacterEncoding("UTF-8"); res.setContentType("text/html;charset=UTF-8"); 
		String from = req.getParameter("from"); 
		String to = req.getParameter("to"); 
		if (from == null || to == null || from.trim().isEmpty() || to.trim().isEmpty()) 
		{ 
			req.setAttribute("error", "Please select both source and destination."); 
			RequestDispatcher rd = req.getRequestDispatcher("booking.jsp"); 
			rd.forward(req, res); return; 
			} 
		Traindao dao = new Traindao(); 
		List<Train> trains = dao.getTrains(from.trim(), to.trim()); 
		if (trains == null || trains.isEmpty()) 
		{ 
			req.setAttribute("message", "No trains found between " + from + " and " + to + "."); 
			} 
		else 
		{ 
			req.setAttribute("trains", trains); 
			} 
		RequestDispatcher rd = req.getRequestDispatcher("trainList.jsp"); 
		rd.forward(req, res); 
		} 
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{ 
		doPost(req, res); 
		} 
}