
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- ================= HEADER ================= -->
<div class="d-flex justify-content-between align-items-center mb-4">
    <h5 class="fw-bold mb-0">
        <i class="fa-solid fa-calendar-check me-2 text-primary"></i>
        Danh sách lượt khám
    </h5>
</div>

<!-- ================= TABLE ================= -->
<div class="card shadow-sm border-0">
    <div class="card-body p-0">

        <table class="table table-hover align-middle mb-0">
            <thead class="table-light">
                <tr>
                    <th style="width:130px;">Ngày khám</th>
                    <th style="width:80px;" class="text-center">STT</th>
                    <th>Bệnh nhân</th>
                    <th style="width:140px;">SĐT</th>
                    <th>Chẩn đoán</th>
                    <th style="width:100px;" class="text-center">Hành động</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach items="${histories}" var="h">
                    <tr>
                        <td>${h.checkinTime}</td>

                        <td class="text-center fw-semibold">
                            ${h.queueNumber}
                        </td>

                        <td>
                            <i class="fa-solid fa-user me-1 text-secondary"></i>
                            ${h.patientName}
                        </td>

                        <td>
                            <i class="fa-solid fa-phone me-1 text-secondary"></i>
                            ${h.patientPhone}
                        </td>

                        <td>${h.diagnosis}</td>

                        <td class="text-center">
                            <a href="${pageContext.request.contextPath}/doctor/exam/detail?examId=${h.examId}"
                               class="btn btn-sm btn-outline-primary">
                                <i class="fa-solid fa-eye"></i>
                                Xem
                            </a>
                        </td>
                    </tr>
                </c:forEach>

                <c:if test="${empty histories}">
                    <tr>
                        <td colspan="6" class="text-center text-muted py-4">
                            <i class="fa-solid fa-circle-info me-1"></i>
                            Chưa có lượt khám nào
                        </td>
                    </tr>
                </c:if>
            </tbody>
        </table>

    </div>
</div>

