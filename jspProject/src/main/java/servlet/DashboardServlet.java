package servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.Traindao;
import dao.Stationsdao;
import model.Train;
import model.Station;

@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        HttpSession session = req.getSession();
	        String username = (String) session.getAttribute("username");
	        if(username == null) { 
	            resp.sendRedirect("login.jsp"); 
	            return; 
	        }

	        Stationsdao sdao = new Stationsdao();
	        List<Station> stations = sdao.getAllStations();
	        req.setAttribute("stations", stations);

	        Traindao tdao = new Traindao();
	        List<Train> trains = tdao.getAllTrains(); // Show all trains initially
	        req.setAttribute("trains", trains);

	        req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
	    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        if(username == null) { 
            resp.sendRedirect("login.jsp"); 
            return; 
        }

        String from = req.getParameter("from");
        String to = req.getParameter("to");
        String travelDate = req.getParameter("travelDate");

        Stationsdao sdao = new Stationsdao();
        List<Station> stations = sdao.getAllStations();
        req.setAttribute("stations", stations);

        if(from == null || to == null || from.equals(to)) {
            req.setAttribute("errorMsg", "Please select valid From and To stations.");
        } else {
            // Fetch trains from DB using station codes
            Traindao tdao = new Traindao();
            List<Train> trains = tdao.searchTrains(from, to);
            req.setAttribute("trains", trains);
        }

        req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
    }

   
}
