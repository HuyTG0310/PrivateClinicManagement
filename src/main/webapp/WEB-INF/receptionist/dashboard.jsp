<%-- 
    Document   : Dashboard
    Created on : Dec 31, 2025, 3:37:22 PM
    Author     : huytr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.User" %>

<%
    User user = (User) session.getAttribute("user");
%>

<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <title>Receptionist Dashboard</title>

        <!-- Bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/assets/style.css" rel="stylesheet">

        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" rel="stylesheet">

    </head>

    <body class="bg-light">

        <div class="container-fluid">
            <div class="row">

                <!-- SIDEBAR -->
                <div class="col-md-3 col-lg-2 sidebar min-vh-100 p-3">
                    <h5 class="text-center mb-4 sidebar-title">
                        <i class="fa-solid fa-hospital me-1"></i>
                        Clinic System
                    </h5>

                    <ul class="nav nav-pills flex-column gap-2 sidebar-menu">

                        <li class="nav-item">
                            <a class="nav-link active" href="#">
                                <i class="fa-solid fa-gauge me-2"></i>
                                Dashboard
                            </a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link"
                               href="${pageContext.request.contextPath}/receptionist/appointments/list">
                                <i class="fa-solid fa-calendar-check me-2"></i>
                                Lịch khám
                            </a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link"
                               href="${pageContext.request.contextPath}/receptionist/appointments/create">
                                <i class="fa-solid fa-calendar-plus me-2"></i>
                                Tạo lịch khám
                            </a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link"
                               href="${pageContext.request.contextPath}/receptionist/patients/create">
                                <i class="fa-solid fa-user-plus me-2"></i>
                                Tạo bệnh nhân
                            </a>
                        </li>

                        <li class="nav-item mt-3">
                            <a class="nav-link logout"
                               href="${pageContext.request.contextPath}/logout">
                                <i class="fa-solid fa-right-from-bracket me-2"></i>
                                Đăng xuất
                            </a>
                        </li>

                    </ul>
                </div>

                <!-- MAIN CONTENT -->
                <div class="col-md-9 col-lg-10 p-4">

                    <!-- TOP BAR -->
                    <div class="d-flex justify-content-between align-items-center mb-4">
                        <h4 class="fw-bold mb-0">
                            <i class="fa-solid fa-user-nurse me-2 text-primary"></i>
                            Receptionist Dashboard
                        </h4>
                        <span class="text-muted">
                            Xin chào, <b><%= user.getFullName()%></b>
                        </span>
                    </div>

                    <!-- FUNCTION CARDS -->
                    <div class="row g-4">

                        <!-- Card: Appointment List -->
                        <div class="col-md-6 col-lg-4">
                            <div class="card shadow-sm h-100">
                                <div class="card-body text-center">
                                    <i class="fa-solid fa-calendar-check fa-3x text-primary mb-3"></i>
                                    <h5 class="fw-bold">Danh sách lịch khám</h5>
                                    <p class="text-muted small">
                                        Xem và quản lý các lịch khám của bệnh nhân
                                    </p>
                                    <a href="${pageContext.request.contextPath}/receptionist/appointments/list"
                                       class="btn btn-outline-primary">
                                        Truy cập
                                    </a>
                                </div>
                            </div>
                        </div>

                        <!-- Card: Create Appointment -->
                        <div class="col-md-6 col-lg-4">
                            <div class="card shadow-sm h-100">
                                <div class="card-body text-center">
                                    <i class="fa-solid fa-calendar-plus fa-3x text-success mb-3"></i>
                                    <h5 class="fw-bold">Tạo lịch khám</h5>
                                    <p class="text-muted small">
                                        Đặt lịch khám cho bệnh nhân đã có hồ sơ
                                    </p>
                                    <a href="${pageContext.request.contextPath}/receptionist/appointments/create"
                                       class="btn btn-outline-success">
                                        Tạo lịch
                                    </a>
                                </div>
                            </div>
                        </div>

                        <!-- ⭐ Card: Create Patient (NEW) -->
                        <div class="col-md-6 col-lg-4">
                            <div class="card shadow-sm h-100 border-start border-4 border-warning">
                                <div class="card-body text-center">
                                    <i class="fa-solid fa-user-plus fa-3x text-warning mb-3"></i>
                                    <h5 class="fw-bold">Tạo bệnh nhân mới</h5>
                                    <p class="text-muted small">
                                        Dành cho bệnh nhân lần đầu đến khám
                                    </p>
                                    <a href="${pageContext.request.contextPath}/receptionist/patients/create"
                                       class="btn btn-outline-warning">
                                        Tạo hồ sơ
                                    </a>
                                </div>
                            </div>
                        </div>

                    </div>


                </div>
            </div>
        </div>

    </body>
</html>

