package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;
import dao.Stationsdao;
import model.Station;

@WebServlet("/StationsServlet")
public class StationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Stationsdao dao = new Stationsdao();
        List<Station> stations = dao.getAllStations(); // fetch all from DB

        request.setAttribute("stations", stations);
        RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
        rd.forward(request, response);
    }
}
