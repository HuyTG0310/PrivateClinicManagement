package controller.receptionist;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author huytr
 */
@WebServlet(name = "ReceptionistDashboardServlet", urlPatterns = {"/receptionist/dashboard"})
public class DashboardServlet extends HttpServlet {

    //chuyển về UI
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("contentPage", "/WEB-INF/receptionist/dashboard.jsp");
        request.setAttribute("pageTitle", "Dashboard");
        request.setAttribute("activePage", "dashboard");
        request.getRequestDispatcher("/WEB-INF/layout/receptionist_layout.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
