<%-- 
    Document   : Dashboard
    Created on : Dec 31, 2025, 3:37:22 PM
    Author     : huytr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- ================= HEADER ================= -->
<div class="d-flex justify-content-between align-items-center mb-4">
    <h4 class="fw-bold mb-0">
        <i class="fa-solid fa-gauge me-2 text-primary"></i>
        Doctor Dashboard
    </h4>
    <span class="text-muted">
        Xin chào, <b>${sessionScope.user.fullName}</b>
    </span>
</div>

<!-- ================= STATS ================= -->
<div class="row g-4 mb-4">

    <div class="col-md-4">
        <div class="card shadow-sm border-0">
            <div class="card-body text-center">
                <i class="fa-solid fa-users fa-2x text-primary mb-2"></i>
                <h6 class="fw-bold">Bệnh nhân hôm nay</h6>
                <h3 class="mb-0">${totalToday}</h3>
            </div>
        </div>
    </div>

    <div class="col-md-4">
        <div class="card shadow-sm border-0">
            <div class="card-body text-center">
                <i class="fa-solid fa-clock fa-2x text-warning mb-2"></i>
                <h6 class="fw-bold">Đang chờ khám</h6>
                <h3 class="mb-0">${waitingCount}</h3>
            </div>
        </div>
    </div>

    <div class="col-md-4">
        <div class="card shadow-sm border-0">
            <div class="card-body text-center">
                <i class="fa-solid fa-check fa-2x text-success mb-2"></i>
                <h6 class="fw-bold">Đã khám xong</h6>
                <h3 class="mb-0">${doneCount}</h3>
            </div>
        </div>
    </div>

</div>

<!-- ================= WAITING PATIENTS ================= -->
<div class="card shadow-sm border-0">
    <div class="card-header bg-white fw-semibold">
        <i class="fa-solid fa-stethoscope me-2 text-success"></i>
        Bệnh nhân đang chờ khám
    </div>

    <div class="card-body p-0">
        <table class="table table-hover align-middle mb-0">
            <thead class="table-light">
                <tr>
                    <th class="text-center" style="width:80px;">STT</th>
                    <th>Bệnh nhân</th>
                    <th>Số điện thoại</th>
                    <th>Giờ check-in</th>
                    <th class="text-center" style="width:160px;">Hành động</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${waitingAppointments}" var="a">
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
                    <td class="text-center">
                        <a href="${pageContext.request.contextPath}/doctor/exam?appointmentId=${a.appointmentId}"
                           class="btn btn-success btn-sm">
                            <i class="fa-solid fa-notes-medical me-1"></i>
                            Khám
                        </a>
                    </td>
                </tr>
            </c:forEach>

            <c:if test="${empty waitingAppointments}">
                <tr>
                    <td colspan="5" class="text-center text-muted py-4">
                        <i class="fa-solid fa-circle-info me-1"></i>
                        Không có bệnh nhân nào đang chờ
                    </td>
                </tr>
            </c:if>

            </tbody>
        </table>
    </div>
</div>

