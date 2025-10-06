package servlet;

import dao.Stationsdao;
import dao.Traindao;
import model.Station;
import model.Train;
import db.database;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Fetch all stations for dropdown
        Stationsdao sdao = new Stationsdao();
        List<Station> stations = sdao.getAllStations();
        request.setAttribute("stations", stations);

        // Forward to JSP
        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String from = request.getParameter("from");
        String to = request.getParameter("to");

        // Fetch stations for dropdown again (so they remain after form submission)
        Stationsdao sdao = new Stationsdao();
        List<Station> stations = sdao.getAllStations();
        request.setAttribute("stations", stations);

        // Validate input
        if (from == null || from.isEmpty() || to == null || to.isEmpty()) {
            request.setAttribute("errorMsg", "Please select both From and To stations.");
        } else {
            // Fetch trains from DB
            try (Connection con = database.getConnection()) {
                Traindao tdao = new Traindao(con);
                List<Train> trains = tdao.getTrainsBySourceDest(from, to);
                request.setAttribute("trains", trains);
                if (trains.isEmpty()) {
                    request.setAttribute("errorMsg", "No trains found for selected route.");
                }
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("errorMsg", "Error fetching trains. Please try again later.");
            }
        }

        // Forward to JSP
        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    }
}
