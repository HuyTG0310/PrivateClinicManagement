package controller;

import dao.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.*;

/**
 *
 * @author huytr
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("Login.jsp").forward(request, response);
    }

    //Nhận thông tin đăng nhập
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDAO userDAO = new UserDAO();
        User user = userDAO.login(username, password);

        //nếu thất bại thì hiện thông báo
        if (user == null) {
            request.setAttribute("error", "Sai tài khoản hoặc mật khẩu");
            //gửi lại username và password cũ
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        } //nếu thành công thì tạo session, đưa về servlet dashboard
        else {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setMaxInactiveInterval(60 * 30);

            //về doGet() dashboard để điều hướng role 
            response.sendRedirect("dashboard");
        }

    }

}
