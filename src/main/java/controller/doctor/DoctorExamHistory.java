/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.doctor;

import dao.DoctorDAO;
import dao.ExamHistoryDAO;
import dao.ExaminationDAO;
import dto.ExamHistoryDTO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Doctor;
import model.User;

/**
 *
 * @author huytr
 */
@WebServlet(name = "DoctorExamHistory", urlPatterns = {"/doctor/history"})
public class DoctorExamHistory extends HttpServlet {

    private DoctorDAO doctorDao = new DoctorDAO();
    private ExamHistoryDAO examDao = new ExamHistoryDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");

        Doctor doctor = doctorDao.GetDoctorByUserId(user.getUserId());

        List<ExamHistoryDTO> histories = examDao.getExamHistoryByDoctor(doctor.getDoctorId());

        request.setAttribute("histories", histories);

        // dùng layout như các trang doctor khác
        request.setAttribute("pageTitle", "Bệnh nhân đã khám");
        request.setAttribute("activePage", "medicalHistory");
        request.setAttribute("contentPage", "/WEB-INF/doctor/exam_history_list.jsp");

        request.getRequestDispatcher("/WEB-INF/layout/doctor_layout.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
