package servlet;

import model.Register;
import dao.Profiledao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/UpdateProfileServlet")
public class UpdateProfileServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("userEmail");

        if(email == null){
            response.sendRedirect("login.jsp");
            return;
        }

        String fullname = request.getParameter("fullname");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

       Register user = new Register();
        user.setEmail(email);
        user.setFullname(fullname);
        user.setPhone(phone);
        user.setPassword(password);

        boolean updated = Profiledao.updateUserProfile(user);
        if(updated){
            response.sendRedirect("profile.jsp?status=success");
        } else {
            response.sendRedirect("profile.jsp?status=error");
        }
    }
}
