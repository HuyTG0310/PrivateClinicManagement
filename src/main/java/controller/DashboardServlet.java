package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.RoleConstant;
import model.User;

/**
 *
 * @author huytr
 */
@WebServlet(name = "DashboardServlet", urlPatterns = {"/dashboard"})
public class DashboardServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login");
            return;
        }
        
        //bắt đầu điều hướng về đúng servlet theo role
        switch (user.getRoleId()) {
            case RoleConstant.ADMIN:
                response.sendRedirect("admin/dashboard");
                break;
            case RoleConstant.DOCTOR:
                response.sendRedirect("doctor/dashboard");
                break;
            case RoleConstant.RECEPTIONIST:
                response.sendRedirect("receptionist/dashboard");
                break;
            case RoleConstant.LAB_TECHNICIAN:
                response.sendRedirect("lab/dashboard");
                break;
            case RoleConstant.PHARMACIST:
                response.sendRedirect("pharmacist/dashboard");
                break;
            case RoleConstant.CASHIER:
                response.sendRedirect("cashier/dashboard");
                break;
            default:
                response.sendError(HttpServletResponse.SC_FORBIDDEN);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
