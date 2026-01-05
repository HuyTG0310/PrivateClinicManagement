/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.doctor;

import dao.AppointmentDAO;
import dao.DoctorDAO;
import dao.ExaminationDAO;
import dao.MedicineDAO;
import dao.PatientDAO;
import dao.PrescriptionDAO;
import dao.PrescriptionDetailDAO;
import dao.TestRequestDAO;
import dao.TestTypeDAO;
import dao.TestViewDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Doctor;
import model.Medicine;
import model.User;

/**
 *
 * @author huytr
 */
@WebServlet(name = "DoctorExamServlet", urlPatterns = {"/doctor/exam"})
public class DoctorExamServlet extends HttpServlet {

    MedicineDAO medicineDao = new MedicineDAO();
    AppointmentDAO appointmentDao = new AppointmentDAO();
    PatientDAO patientDao = new PatientDAO();
    ExaminationDAO examDao = new ExaminationDAO();
    PrescriptionDetailDAO detailDao = new PrescriptionDetailDAO();
    DoctorDAO doctorDao = new DoctorDAO();
    PrescriptionDAO preDao = new PrescriptionDAO();
    TestTypeDAO testTypeDao = new TestTypeDAO();
    TestRequestDAO requestDao = new TestRequestDAO();

    TestViewDAO testViewDao = new TestViewDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String appointmentId = request.getParameter("appointmentId");

        //đổi status khi bác sĩ ấn khám
        appointmentDao.UpdateStatus("IN_PROGRESS", appointmentId);

        request.setAttribute("medicines", medicineDao.GetAll());
        request.setAttribute("queueNumber", appointmentDao.GetQueueNumberByAppointmentId(appointmentId));
        request.setAttribute("patient", patientDao.GetPatientByAppointmentId(request.getParameter("appointmentId")));

        //hiển thị các loại xét nghiệm theo chuyên khoa từ appointment
        int clinicRoomId = appointmentDao.GetClinicRoomIdByAppointmentId(appointmentId);
        request.setAttribute("testTypes", testTypeDao.GetAllByClinicRoom(clinicRoomId));

//        request.setAttribute("testRequests", requestDao.GetByExamId(examDao.GetExamIdByAppointmentId(appointmentId)));
        request.setAttribute("testRequests", testViewDao.GetAllByExamId(examDao.GetExamIdByAppointmentId(appointmentId)));
        request.setAttribute("pageTitle", "Doctor Exam");
        request.setAttribute("activePage", "doctorExam");
        request.setAttribute("contentPage", "/WEB-INF/doctor/doctor_exam.jsp");

        //gửi lên để save dianosis lấy được id về
        request.setAttribute("appointmentId", appointmentId);

        request.setAttribute("exam", examDao.GetByAppointmentId(appointmentId));
        request.getRequestDispatcher("/WEB-INF/layout/doctor_layout.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
