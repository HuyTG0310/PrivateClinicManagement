<%-- 
    Document   : doctor_examining_list
    Created on : Jan 2, 2026, 12:07:02 PM
    Author     : huytr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- ================= HEADER ================= -->
<div class="d-flex justify-content-between align-items-center mb-4">
    <h4 class="fw-bold mb-0">
        <i class="fa-solid fa-hourglass-half me-2 text-warning"></i>
        Bệnh nhân đang khám
    </h4>
    <span class="text-muted">
        Đang chờ kết quả xét nghiệm
    </span>
</div>

<!-- ================= TABLE ================= -->
<div class="card shadow-sm border-0">
    <div class="card-body p-0">

        <table class="table table-hover align-middle mb-0">
            <thead class="table-light">
                <tr>
                    <th class="text-center" style="width:80px;">STT</th>
                    <th>Bệnh nhân</th>
                    <th>Số điện thoại</th>
                    <th>Thời gian bắt đầu</th>
                    <th>Trạng thái</th>
                    <th class="text-center" style="width:200px;">Hành động</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach items="${examiningAppointments}" var="a">
                    <tr>
                        <td class="text-center fw-bold text-primary">
                            ${a.queueNumber}
                        </td>

                        <td>
                            <i class="fa-solid fa-user me-1 text-secondary"></i>
                            ${a.patientName}
                        </td>

                        <td>${a.patientPhone}</td>

                        <td>${a.checkinTime}</td>

                        <td>
                            <span class="badge bg-warning text-dark">
                                Đang chờ kết quả
                            </span>
                        </td>

                        <td class="text-center">
                            <a href="${pageContext.request.contextPath}/doctor/exam?appointmentId=${a.appointmentId}"
                               class="btn btn-outline-primary btn-sm">
                                <i class="fa-solid fa-rotate-right me-1"></i>
                                Tiếp tục khám
                            </a>
                        </td>
                    </tr>
                </c:forEach>

                <c:if test="${empty examiningAppointments}">
                    <tr>
                        <td colspan="6" class="text-center text-muted py-4">
                            <i class="fa-solid fa-circle-info me-1"></i>
                            Không có bệnh nhân nào đang khám
                        </td>
                    </tr>
                </c:if>
            </tbody>

        </table>

    </div>
</div>
