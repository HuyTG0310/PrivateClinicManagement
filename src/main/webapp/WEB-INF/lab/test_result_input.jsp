<%-- 
    Document   : test_result_input
    Created on : Jan 6, 2026, 10:34:43 PM
    Author     : huytr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- ================= HEADER ================= -->
<div class="d-flex justify-content-between align-items-center mb-4">
    <h4 class="fw-bold mb-0">
        <i class="fa-solid fa-vials me-2 text-info"></i>
        Nhập kết quả xét nghiệm
    </h4>

    <a href="${pageContext.request.contextPath}/lab/dashboard"
       class="btn btn-outline-secondary btn-sm">
        <i class="fa-solid fa-arrow-left me-1"></i>
        Quay lại
    </a>
</div>

<form method="POST">

    <input type="hidden" name="requestId" value="${testRequest.testRequestId}" />

    <!-- ================= PATIENT INFO ================= -->
    <div class="card shadow-sm border-0 mb-4">
        <div class="card-header bg-white fw-semibold">
            <i class="fa-solid fa-user me-2 text-primary"></i>
            Thông tin bệnh nhân
        </div>

        <div class="card-body bg-light">
            <div class="row g-3">

                <div class="col-md-4">
                    <label class="form-label">Bệnh nhân</label>
                    <input type="text"
                           class="form-control"
                           value="${testRequest.patientName}"
                           disabled>
                </div>

                <div class="col-md-4">
                    <label class="form-label">Xét nghiệm</label>
                    <input type="text"
                           class="form-control"
                           value="${testRequest.testTypeName}"
                           disabled>
                </div>

                <div class="col-md-4">
                    <label class="form-label">Ngày yêu cầu</label>
                    <input type="text"
                           class="form-control"
                           value="${testRequest.requestDate}"
                           disabled>
                </div>

            </div>
        </div>
    </div>

    <!-- ================= RESULT INPUT ================= -->
    <div class="card shadow-sm border-0 mb-4">
        <div class="card-header bg-white fw-semibold">
            <i class="fa-solid fa-flask me-2 text-success"></i>
            Kết quả xét nghiệm
        </div>

        <div class="card-body bg-light">

            <div class="mb-3">
                <label class="form-label fw-semibold">
                    Kết quả <span class="text-danger">*</span>
                </label>

                <textarea name="resultValue"
                          class="form-control"
                          rows="4"
                          placeholder="Nhập kết quả xét nghiệm..."
                          required></textarea>

                <div class="form-text">
                    Ví dụ: Hb = 13.5 g/dL, Bạch cầu tăng nhẹ...
                </div>
            </div>

        </div>
    </div>

    <!-- ================= ACTIONS ================= -->
    <div class="d-flex justify-content-end">
        <button type="submit"
                class="btn btn-success fw-semibold px-4">
            <i class="fa-solid fa-check me-1"></i>
            Hoàn tất xét nghiệm
        </button>
    </div>

</form>