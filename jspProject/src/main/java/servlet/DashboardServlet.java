package servlet;

import dao.Stationsdao;
import model.Station;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class DashboardServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Stationsdao dao = new Stationsdao();
        List<Station> stations = dao.getAllStations();
        request.setAttribute("stations", stations);

        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    }
}
