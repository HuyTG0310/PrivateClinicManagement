/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.lab;

import dao.TestRequestDAO;
import dao.TestResultDAO;
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
@WebServlet(name = "LabSaveResultServlet", urlPatterns = {"/lab/result"})
public class LabSaveResultServlet extends HttpServlet {

    TestRequestDAO requetDao = new TestRequestDAO();
    TestResultDAO resultDao = new TestResultDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //nhấn nhập kết quả thì vô đây

        int requestId = Integer.parseInt(request.getParameter("requestId"));

        request.setAttribute("testRequest", requetDao.getByTestRequestId(requestId));
        request.setAttribute("pageTitle", "Nhập kết quả");
        request.setAttribute("contentPage",
                "/WEB-INF/lab/test_result_input.jsp");

        request.getRequestDispatcher("/WEB-INF/layout/lab_layout.jsp")
                .forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //nhập kết quả xong thì vào đây
        int requestId = Integer.parseInt(request.getParameter("requestId"));
        String result = request.getParameter("resultValue");
        resultDao.Create(requestId, result);
        response.sendRedirect(request.getContextPath() + "/lab/dashboard");

    }

}
