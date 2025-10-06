package servlet;

import dao.Traindao;
import db.database;
import model.Train;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/TrainServlet")
public class TrainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String source = request.getParameter("source");
        String dest = request.getParameter("destination");

        try {
            Traindao dao = new Traindao(database.getConnection());
            List<Train> trains = dao.getTrainsBySourceDest(source, dest);

            request.setAttribute("trains", trains);
            request.setAttribute("source", source);
            request.setAttribute("destination", dest);

            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
