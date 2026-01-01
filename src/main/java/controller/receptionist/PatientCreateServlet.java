/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.receptionist;

import dao.PatientDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import model.Patient;

/**
 *
 * @author huytr
 */
@WebServlet(name = "PatientCreateServlet", urlPatterns = {"/receptionist/patients/create"})
public class PatientCreateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/receptionist/patient_create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String dob = request.getParameter("dob");

        //vì name và phone đã required nên sẽ ko empty, chỉ cần check format phone
        if (!phone.matches("(^[0]\\d{9})$")) {
            request.setAttribute("error", "Số điện thoại phải đúng định dạng");
            request.getRequestDispatcher("/WEB-INF/receptionist/patient_create.jsp").forward(request, response);
            return;
        }

        //nếu thông tin đã đúng thì tạo patient
        Patient p = new Patient();
        p.setName(name);
        p.setGender(gender);
        p.setAddress(address);
        p.setPhone(phone);

        //nếu có nhập dob thì mới chuyển. ko cần format thì nhập đã đúng định dạng
        if (!dob.isEmpty()) {
            p.setDob(Date.valueOf(dob));
        }

        PatientDAO dao = new PatientDAO();

        int patientId = dao.Create(p);

        response.sendRedirect(request.getContextPath() + "/receptionist/appointments/create?patientId=" + patientId);

    }

}
