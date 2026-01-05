/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.doctor;

import dao.ExaminationDAO;
import dao.TestRequestDAO;
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
@WebServlet(name = "RequestTestServlet", urlPatterns = {"/doctor/exam/request_test"})
public class RequestTestServlet extends HttpServlet {

    ExaminationDAO examDao = new ExaminationDAO();
    TestRequestDAO testDao = new TestRequestDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String appointmentId = request.getParameter("appointmentId");
        String[] testTypeIds = request.getParameterValues("testTypeIds");

        int examId = examDao.GetExamIdByAppointmentId(appointmentId);

        //nếu chưa có examination thì ko cho chỉ định
        if (examId != -1 && testTypeIds != null) {
            for (String id : testTypeIds) {
                testDao.Create(examId, id);
            }
        }

        response.sendRedirect(request.getContextPath() + "/doctor/exam?appointmentId=" + appointmentId);
    }

}
