/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.receptionist;

import dao.AppointmentDAO;
import dao.ClinicRoomDAO;
import dao.PatientDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.ClinicRoom;
import model.Patient;
import model.User;

/**
 *
 * @author huytr
 */
@WebServlet(name = "AppointmentCreateServlet", urlPatterns = {"/receptionist/appointments/create"})
public class AppointmentCreateServlet extends HttpServlet {

    PatientDAO patientDao = new PatientDAO();
    ClinicRoomDAO clinicDao = new ClinicRoomDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //nếu vừa tạo mới patient xong thì get ra
        String patientIdRaw = request.getParameter("patientId");
        if (patientIdRaw != null) {
            int patientId = Integer.parseInt(patientIdRaw);
            Patient patient = patientDao.GetById(patientId);
            request.setAttribute("patient", patient);
        }

        //Load ds phòng khám
        request.setAttribute("rooms", clinicDao.GetAll());
        request.setAttribute("pageTitle", "Tạo lịch khám");
        request.setAttribute("activePage", "createAppointment");
        request.setAttribute("contentPage", "/WEB-INF/receptionist/appointment_create.jsp");
        request.getRequestDispatcher("/WEB-INF/layout/receptionist_layout.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("searchPatient")) {
            String phone = request.getParameter("searchPhone").trim();
            Patient patient = patientDao.SearchByPhone(phone);

            if (patient == null) {
                request.setAttribute("searchError", "Không tìm thấy bệnh nhân");
            } else {
                request.setAttribute("patient", patient);
            }

            request.setAttribute("rooms", clinicDao.GetAll());
            request.setAttribute("pageTitle", "Tạo lịch khám");
            request.setAttribute("activePage", "createAppointment");
            request.setAttribute("contentPage", "/WEB-INF/receptionist/appointment_create.jsp");
            request.getRequestDispatcher("/WEB-INF/layout/receptionist_layout.jsp").forward(request, response);
            return;
        }

        int patientId = Integer.parseInt(request.getParameter("patientId"));
        int clinicRoomId = Integer.parseInt(request.getParameter("roomId"));

        User receptionist = (User) request.getSession().getAttribute("user");

        AppointmentDAO dao = new AppointmentDAO();
        dao.CreateAppointment(patientId, clinicRoomId, receptionist.getUserId());
        response.sendRedirect(request.getContextPath() + "/receptionist/dashboard");
    }

}
