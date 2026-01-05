/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.doctor;

import dao.AppointmentDAO;
import dao.DoctorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Doctor;
import model.User;

/**
 *
 * @author huytr
 */
@WebServlet(name = "DoctorDashboardServlet", urlPatterns = {"/doctor/dashboard"})
public class DoctorDashboardServlet extends HttpServlet {

    AppointmentDAO dao = new AppointmentDAO();
    DoctorDAO doctorDao = new DoctorDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        User user = (User) session.getAttribute("user");
        
        Doctor doctor = doctorDao.GetDoctorByUserId(user.getUserId());
        request.setAttribute("totalToday", 10);
        request.setAttribute("waitingCount", 10);
        request.setAttribute("doneCount", 10);
        request.setAttribute("waitingAppointments", dao.GetWaitingAppointmentsForDoctor(doctor.getDoctorId()));

        request.setAttribute("pageTitle", "Doctor Dashboard");
        request.setAttribute("activePage", "doctorDashboard");
        request.setAttribute("contentPage", "/WEB-INF/doctor/dashboard.jsp");

        request.getRequestDispatcher("/WEB-INF/layout/doctor_layout.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
