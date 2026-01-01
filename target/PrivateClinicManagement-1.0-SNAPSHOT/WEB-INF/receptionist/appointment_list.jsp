<%-- 
    Document   : appointment_list
    Created on : Jan 1, 2026, 1:15:20 PM
    Author     : huytr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container my-4">

            <!-- TITLE -->
            <!-- TITLE -->
            <div class="d-flex justify-content-between align-items-center mb-4">


                <div class="d-flex align-items-center gap-3">
                    <!-- Page title -->
                    <div>
                        <h4 class="fw-bold mb-0">
                            <i class="fa-solid fa-calendar-check me-2 text-primary"></i>
                            Danh sách lịch khám
                        </h4>
                        <small class="text-muted">
                            Danh sách bệnh nhân đang chờ khám
                        </small>
                    </div>
                </div>


                <a href="${pageContext.request.contextPath}/receptionist/dashboard"
                   <a class="btn btn-outline-secondary btn-sm rounded-pill">
                        <i class="fa-solid fa-arrow-left me-1"></i>
                        Dashboard
                    </a>

            </div>

            <!-- TABLE -->
            <div class="card shadow-sm border-0">
                <div class="card-body p-0">

                    <table class="table table-hover align-middle mb-0">
                        <thead class="table-light">
                            <tr>
                                <th style="width: 90px;" class="text-center">STT</th>
                                <th>Bệnh nhân</th>
                                <th>Số điện thoại</th>
                                <th>Phòng khám</th>
                                <th style="width: 160px;">Giờ check-in</th>
                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach items="${appointments}" var="a">
                                <tr>
                                    <!-- Queue Number -->
                                    <td class="text-center fw-bold text-primary">
                                        ${a.queueNumber}
                                    </td>

                                    <!-- Patient Name -->
                                    <td>
                                        <i class="fa-solid fa-user me-1 text-secondary"></i>
                                        ${a.patientName}
                                    </td>

                                    <!-- Phone -->
                                    <td>
                                        <i class="fa-solid fa-phone me-1 text-secondary"></i>
                                        ${a.patientPhone}
                                    </td>

                                    <!-- Clinic Room -->
                                    <td>
                                        <c:if test="${a.clinicRoomName eq 'Nội tổng hợp'}">
                                            <span class="badge bg-info text-dark">
                                                ${a.clinicRoomName}
                                            </span>
                                        </c:if>
                                        <c:if test="${a.clinicRoomName eq 'Da liễu'}">
                                            <span class="badge bg-success">
                                                ${a.clinicRoomName}
                                            </span>
                                        </c:if>
                                        <c:if test="${a.clinicRoomName eq 'Răng hàm mặt'}">
                                            <span class="badge bg-danger">
                                                ${a.clinicRoomName}
                                            </span>
                                        </c:if>
                                        <c:if test="${a.clinicRoomName eq 'Nhi'}">
                                            <span class="badge bg-warning text-dark">
                                                ${a.clinicRoomName}
                                            </span>
                                        </c:if>
                                        
                                    </td>

                                    <!-- Check-in Time -->
                                    <td class="text-muted">
                                        ${a.checkinTime}
                                    </td>
                                </tr>
                            </c:forEach>

                            <!-- EMPTY -->
                            <c:if test="${empty appointments}">
                                <tr>
                                    <td colspan="5" class="text-center text-muted py-4">
                                        <i class="fa-solid fa-circle-info me-1"></i>
                                        Chưa có lịch khám nào
                                    </td>
                                </tr>
                            </c:if>
                        </tbody>
                    </table>

                </div>
            </div>

        </div>
    </body>
</html>
