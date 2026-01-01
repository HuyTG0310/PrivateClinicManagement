/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.receptionist;

import dao.AppointmentDAO;
import dto.AppointmentDTO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author huytr
 */
@WebServlet(name = "AppointmentListServlet", urlPatterns = {"/receptionist/appointments/list"})
public class AppointmentListServlet extends HttpServlet {

    AppointmentDAO dao = new AppointmentDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("pageTitle", "Danh sách lịch khám");
        request.setAttribute("activePage", "appointments");
        request.setAttribute("contentPage", "/WEB-INF/receptionist/appointment_list.jsp");
        request.setAttribute("appointments", dao.GetTodayAppointments());
        request.getRequestDispatcher("/WEB-INF/layout/receptionist_layout.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
