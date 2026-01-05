/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.doctor;

import dao.AppointmentDAO;
import dao.ExaminationDAO;
import dao.MedicineDAO;
import dao.PrescriptionDAO;
import dao.PrescriptionDetailDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Arrays;
import model.Medicine;

/**
 *
 * @author huytr
 */
@WebServlet(name = "SavePrescriptionServlet", urlPatterns = {"/doctor/exam/save_prescription"})
public class SavePrescriptionServlet extends HttpServlet {

    ExaminationDAO examDao = new ExaminationDAO();

    PrescriptionDAO prescriptionDao = new PrescriptionDAO();

    PrescriptionDetailDAO detailDao = new PrescriptionDetailDAO();

    MedicineDAO medicineDao = new MedicineDAO();

    AppointmentDAO appointDao = new AppointmentDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("===== SAVE PRESCRIPTION HIT =====");

        request.getParameterMap().forEach((k, v) -> {
            System.out.println(k + " = " + java.util.Arrays.toString(v));
        });

        String appointmentId = request.getParameter("appointmentId");

        int examId = examDao.GetExamIdByAppointmentId(appointmentId);

        if (examId == -1) {
            response.sendRedirect(request.getContextPath() + "/doctor/exam?appointmentId=" + appointmentId);
            return;
        }

        int prescriptionId = prescriptionDao.FindByExamId(examId);

        if (prescriptionId == -1) {
            prescriptionId = prescriptionDao.Create(examId);
        }

        String[] medicineNames = request.getParameterValues("medicineName[]");
        String[] quantities = request.getParameterValues("quantity[]");
        String[] dosages = request.getParameterValues("dosage[]");

        if (medicineNames == null) {
            // Không có thuốc → chỉ tạo prescription, không tạo detail
            response.sendRedirect(
                    request.getContextPath()
                    + "/doctor/exam?appointmentId=" + appointmentId
            );
            return;
        }

        for (int i = 0; i < medicineNames.length; i++) {
            if (medicineNames[i] == null || medicineNames[i].isBlank()) {
                response.sendRedirect(request.getContextPath() + "/login");
                continue;
            }
            Medicine med = medicineDao.GetByName(medicineNames[i]);
            if (med == null) {
                continue;
            }
            detailDao.AddDetail(prescriptionId, med.getMedicineId(), Integer.parseInt(quantities[i]), dosages[i]);
        }

        //đổi status khi bác sĩ ấn lưu đơn thuốc
        appointDao.UpdateStatus("DONE", appointmentId);

        response.sendRedirect(request.getContextPath() + "/doctor/dashboard");
    }

}
