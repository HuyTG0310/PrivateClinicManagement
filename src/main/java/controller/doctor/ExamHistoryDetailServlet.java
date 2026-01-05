/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.doctor;

import dao.ExaminationDAO;
import dao.PrescriptionDAO;
import dao.PrescriptionDetailDAO;
import dao.TestRequestDAO;
import dao.TestViewDAO;
import dto.ExamDetailDTO;
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
@WebServlet(name = "ExamHistoryDetailServlet", urlPatterns = {"/doctor/exam/detail"})
public class ExamHistoryDetailServlet extends HttpServlet {

    private ExaminationDAO examDao = new ExaminationDAO();
    private PrescriptionDAO prescriptionDao = new PrescriptionDAO();
    private PrescriptionDetailDAO detailDao = new PrescriptionDetailDAO();
    private TestRequestDAO testRequestDao = new TestRequestDAO();
    private TestViewDAO testViewDao = new TestViewDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String examIdRaw = request.getParameter("examId");
        if (examIdRaw == null) {
            response.sendRedirect(request.getContextPath() + "/doctor/history");
            return;
        }

        int examId = Integer.parseInt(examIdRaw);

        // === LẤY CHI TIẾT CA KHÁM ===
        ExamDetailDTO exam = examDao.getExamDetail(examId);
        if (exam == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        request.setAttribute("exam", exam);

        // === ĐƠN THUỐC ===
        int prescriptionId = prescriptionDao.FindByExamId(examId);
        if (prescriptionId != -1) {
            request.setAttribute(
                    "prescriptionDetails",
                    detailDao.GetDetailByPrescriptionId(prescriptionId)
            );
        }

        // === XÉT NGHIỆM ===
        request.setAttribute("testRequests", testViewDao.GetAllByExamId(examId));

        // layout
        request.setAttribute("pageTitle", "Chi tiết ca khám");
        request.setAttribute("activePage", "medicalHistory");
        request.setAttribute(
                "contentPage",
                "/WEB-INF/doctor/exam_history_detail.jsp"
        );

        request.getRequestDispatcher("/WEB-INF/layout/doctor_layout.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
