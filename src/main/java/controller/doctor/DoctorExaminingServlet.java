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
import model.Doctor;
import model.User;

/**
 *
 * @author huytr
 */
@WebServlet(name = "DoctorExaminingServlet", urlPatterns = {"/doctor/examining"})
public class DoctorExaminingServlet extends HttpServlet {

    AppointmentDAO dao = new AppointmentDAO();
    DoctorDAO doctorDao = new DoctorDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        Doctor doctor = doctorDao.GetDoctorByUserId(user.getUserId());

        request.setAttribute("examiningAppointments", dao.GetInProgressAppointmentsForDoctor(doctor.getDoctorId()));
        request.setAttribute("pageTitle", "Examining");
        request.setAttribute("activePage", "examiningPatients");
        request.setAttribute("contentPage", "/WEB-INF/doctor/doctor_examining_list.jsp");

        request.getRequestDispatcher("/WEB-INF/layout/doctor_layout.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
