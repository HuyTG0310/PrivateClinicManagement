<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- ================= HEADER ================= -->
<div class="d-flex justify-content-between align-items-center mb-4">
    <h5 class="fw-bold mb-0">
        <i class="fa-solid fa-vials me-2 text-info"></i>
        Danh sách xét nghiệm
    </h5>
</div>

<!-- ================= TABLE ================= -->
<div class="card shadow-sm border-0">
    <div class="card-body p-0">

        <table class="table table-hover align-middle mb-0">
            <thead class="table-light">
                <tr>
                    <th>Bệnh nhân</th>
                    <th>Số điện thoại</th>
                    <th>Xét nghiệm</th>
                    <th>Yêu cầu lúc</th>
                    <th class="text-center">Hành động</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach items="${waitingTests}" var="t">
                    <tr>
                        <!-- Patient -->
                        <td>
                            <i class="fa-solid fa-user me-1 text-secondary"></i>
                            ${t.patientName}
                        </td>
                        
                        
                         <td>
                            <i class="fa-solid fa-user me-1 text-secondary"></i>
                            ${t.patientPhone}
                        </td>

                        <!-- Test Type -->
                        <td class="fw-semibold">
                            ${t.testTypeName}
                        </td>

                        <!-- Request Date -->
                        <td>
                            ${t.requestDate}
                        </td>


                        <!-- Action -->
                        <td class="text-center">
                            <a href="${pageContext.request.contextPath}/lab/result?requestId=${t.testRequestId}"
                               class="btn btn-sm btn-outline-primary">
                                <i class="fa-solid fa-pen-to-square me-1"></i>
                                Nhập kết quả
                            </a>
                        </td>
                    </tr>
                </c:forEach>

                <!-- EMPTY -->
                <c:if test="${empty testRequests}">
                    <tr>
                        <td colspan="5" class="text-center text-muted py-4">
                            <i class="fa-solid fa-circle-info me-1"></i>
                            Không có yêu cầu xét nghiệm
                        </td>
                    </tr>
                </c:if>

            </tbody>
        </table>

    </div>
</div>
