<%-- 
    Document   : exam_history_detail
    Created on : Jan 5, 2026, 2:59:37 PM
    Author     : huytr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- ================= HEADER ================= -->
<div class="d-flex justify-content-between align-items-center mb-4">
    <h4 class="fw-bold mb-0">
        <i class="fa-solid fa-notes-medical me-2 text-success"></i>
        Chi tiết lần khám
    </h4>

    <a href="${pageContext.request.contextPath}/doctor/history"
       class="btn btn-outline-secondary btn-sm">
        <i class="fa-solid fa-arrow-left me-1"></i>
        Quay lại
    </a>
</div>

<!-- ================= PATIENT INFO ================= -->
<div class="card shadow-sm border-0 mb-4">
    <div class="card-header bg-white fw-semibold">
        <i class="fa-solid fa-user me-2 text-primary"></i>
        Thông tin bệnh nhân
    </div>

    <div class="card-body bg-light">
        <div class="row g-3">
            <div class="col-md-4">
                <label class="form-label">Số thứ tự</label>
                <input type="text" class="form-control"
                       value="${exam.queueNumber}" disabled>
            </div>

            <div class="col-md-4">
                <label class="form-label">Họ tên</label>
                <input type="text" class="form-control"
                       value="${exam.patientName}" disabled>
            </div>

            <div class="col-md-4">
                <label class="form-label">Ngày khám</label>
                <input type="text" class="form-control"
                       value="${exam.checkinTime}" disabled>
            </div>
        </div>
    </div>
</div>

<!-- ================= DIAGNOSIS ================= -->
<div class="card shadow-sm border-0 mb-4">
    <div class="card-header bg-white fw-semibold">
        <i class="fa-solid fa-stethoscope me-2 text-danger"></i>
        Chẩn đoán
    </div>

    <div class="card-body bg-light">
        <textarea class="form-control"
                  rows="3"
                  disabled>${exam.diagnosis}</textarea>
    </div>
</div>

<!-- ================= LAB TEST ================= -->
<div class="card shadow-sm border-0 mb-4">
    <div class="card-header bg-white fw-semibold">
        <i class="fa-solid fa-vials me-2 text-info"></i>
        Xét nghiệm
    </div>

    <div class="card-body bg-light p-0">
        <table class="table table-sm table-bordered mb-0 bg-white">
            <thead class="table-light">
                <tr>
                    <th>Xét nghiệm</th>
                    <th>Trạng thái</th>
                    <th>Kết quả</th>
                </tr>
            </thead>
            <tbody>

                <c:forEach items="${testRequests}" var="t">
                    <tr>
                        <td>${t.testTypeName}</td>
                        <td>${t.status}</td>
                        <td>${t.resultValue}</td>
                    </tr>
                </c:forEach>

                <c:if test="${empty testRequests}">
                    <tr>
                        <td colspan="3" class="text-center text-muted py-3">
                            Không có xét nghiệm
                        </td>
                    </tr>
                </c:if>
            </tbody>
        </table>
    </div>
</div>

<!-- ================= PRESCRIPTION ================= -->
<div class="card shadow-sm border-0">
    <div class="card-header bg-white fw-semibold">
        <i class="fa-solid fa-pills me-2 text-warning"></i>
        Đơn thuốc
    </div>

    <div class="card-body bg-light p-0">
        <table class="table table-sm table-bordered mb-0 bg-white">
            <thead class="table-light">
                <tr>
                    <th>Thuốc</th>
                    <th>SL</th>
                    <th>Liều dùng</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${prescriptionDetails}" var="d">
                    <tr>
                        <td>${d.medicineName}</td>
                        <td>${d.quantity}</td>
                        <td>${d.dosage}</td>
                    </tr>
                </c:forEach>

                <c:if test="${empty prescriptionDetails}">
                    <tr>
                        <td colspan="3" class="text-center text-muted py-3">
                            Không có đơn thuốc
                        </td>
                    </tr>
                </c:if>
            </tbody>
        </table>
    </div>
</div>

