/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.doctor;

import dao.DoctorDAO;
import dao.ExaminationDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author huytr
 */
@WebServlet(name = "SaveDiagnosisServlet", urlPatterns = {"/doctor/exam/save_diagnosis"})
public class SaveDiagnosisServlet extends HttpServlet {

    ExaminationDAO examinationDao = new ExaminationDAO();
    DoctorDAO doctorDao = new DoctorDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String appointmentId = request.getParameter("appointmentId");

        String diagnosis = request.getParameter("diagnosis");

        User user = (User) request.getSession().getAttribute("user");
        int doctorId = doctorDao.GetDoctorByUserId(user.getUserId()).getDoctorId();

        int examId = examinationDao.GetExamIdByAppointmentId(appointmentId);

        if (examId == -1) {
            examinationDao.Create(appointmentId, doctorId, diagnosis);
        } else {
            examinationDao.UpdateDiagnosis(examId, diagnosis);
        }
        
        response.sendRedirect(request.getContextPath() + "/doctor/exam?appointmentId=" + appointmentId);
    }

}
