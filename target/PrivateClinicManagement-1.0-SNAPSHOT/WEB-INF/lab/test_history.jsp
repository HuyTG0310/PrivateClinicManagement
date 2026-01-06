<%-- 
    Document   : test_history
    Created on : Jan 6, 2026, 10:14:20 PM
    Author     : huytr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h5 class="fw-bold mb-3">
    <i class="fa-solid fa-clock-rotate-left me-2 text-secondary"></i>
    Lịch sử xét nghiệm
</h5>

<div class="card shadow-sm border-0">
    <div class="card-body p-0">

        <table class="table table-hover align-middle mb-0">
            <thead class="table-light">
                <tr>
                    <th>Bệnh nhân</th>
                    <th>Xét nghiệm</th>
                    <th>Ngày</th>
                    <th>Kết quả</th>
                </tr>
            </thead>

            <tbody>
            <c:forEach items="${history}" var="h">
                <tr>
                    <td>${h.patientName}</td>
                    <td>${h.testTypeName}</td>
                    <td>${h.resultDate}</td>
                    <td class="fw-semibold text-success">
                        ${h.resultValue}
                    </td>
                </tr>
            </c:forEach>
            </tbody>

        </table>

    </div>
</div>
