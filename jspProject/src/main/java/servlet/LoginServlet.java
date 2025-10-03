package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

import model.Login;
import dao.Logindao;
import dao.Stationsdao;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Login login = new Login(username, password);

        Logindao dao = new Logindao();
        boolean isValid = dao.validate(login);

        if(isValid) {
            // Get stations list
            Stationsdao stationsDao = new Stationsdao();
            request.setAttribute("stations", stationsDao.getAllStations());

            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
            rd.forward(request, response);

        } else {
            request.setAttribute("errorMessage", "Invalid username or password!");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }
    }
}
