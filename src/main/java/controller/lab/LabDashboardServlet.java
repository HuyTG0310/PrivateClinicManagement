/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.lab;

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
@WebServlet(name = "LabDashboardServlet", urlPatterns = {"/lab/dashboard"})
public class LabDashboardServlet extends HttpServlet {

    TestRequestDAO requestDao = new TestRequestDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("waitingTests", requestDao.getWaitingTests());
        
        request.setAttribute("pageTitle", "labDashboard");
        request.setAttribute("contentPage",
            "/WEB-INF/lab/dashboard.jsp");

        request.getRequestDispatcher("/WEB-INF/layout/lab_layout.jsp")
               .forward(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

   

}
