<%-- 
    Document   : appointment_create
    Created on : Jan 1, 2026, 10:51:40 AM
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
    <div class="row justify-content-center">
        <div class="col-lg-10 col-xl-9">

            <!-- ================= TITLE ================= -->
            <div class="mb-4">
                <h4 class="fw-bold mb-1">
                    <i class="fa-solid fa-calendar-plus me-2 text-success"></i>
                    Tạo lịch khám
                </h4>
                <p class="text-muted mb-0">
                    Áp dụng cho bệnh nhân mới và bệnh nhân tái khám
                </p>
            </div>

            <form method="POST">

                <!-- ================= SEARCH PATIENT ================= -->
                <div class="card shadow-sm border-0 mb-4">
                    <div class="card-header bg-white fw-semibold">
                        <i class="fa-solid fa-magnifying-glass me-2 text-primary"></i>
                        Tìm bệnh nhân theo số điện thoại
                    </div>

                    <div class="card-body bg-light">
                        <div class="row g-3 align-items-end">

                            <div class="col-md-6">
                                <label class="form-label fw-semibold">
                                    Số điện thoại
                                </label>
                                <div class="input-group">
                                    <span class="input-group-text bg-white">
                                        <i class="fa-solid fa-phone"></i>
                                    </span>
                                    <input type="text"
                                           name="searchPhone"
                                           class="form-control"
                                           placeholder="Nhập số điện thoại bệnh nhân"
                                           value="${param.searchPhone}" />
                                </div>
                            </div>
                               
                                
                             <!--formonvalidate là để bỏ qua validation, vì ở đây cần tìm theo sđt nên tạm thời bỏ qua các fields khác-->
                            <div class="col-md-3">
                                <button type="submit"
                                        name="action"
                                        value="searchPatient"
                                        class="btn btn-primary w-100"
                                        formnovalidate> 
                                    <i class="fa-solid fa-magnifying-glass me-1"></i>
                                    Tìm kiếm
                                </button>
                            </div>

                        </div>

                        <!-- SEARCH ERROR -->
                        <c:if test="${not empty searchError}">
                            <div class="alert alert-warning mt-3 mb-0">
                                <i class="fa-solid fa-circle-info me-1"></i>
                                ${searchError}
                                <a href="${pageContext.request.contextPath}/receptionist/patients/create"
                                   class="fw-semibold">
                                    Tạo bệnh nhân mới
                                </a>
                            </div>
                        </c:if>
                    </div>
                </div>

                <!-- ================= PATIENT INFO ================= -->
                <c:if test="${not empty patient}">
                    <input type="hidden" name="patientId" value="${patient.patientId}" />

                    <div class="card shadow-sm border-0 mb-4">
                        <div class="card-header bg-white fw-semibold">
                            <i class="fa-solid fa-user me-2 text-primary"></i>
                            Thông tin bệnh nhân
                        </div>

                        <div class="card-body bg-light">
                            <div class="row g-3">

                                <div class="col-md-6">
                                    <label class="form-label">Họ tên</label>
                                    <input type="text" class="form-control"
                                           value="${patient.name}" disabled />
                                </div>

                                <div class="col-md-3">
                                    <label class="form-label">Giới tính</label>
                                    <input type="text" class="form-control"
                                           value="${patient.gender}" disabled />
                                </div>

                                <div class="col-md-3">
                                    <label class="form-label">Ngày sinh</label>
                                    <input type="text" class="form-control"
                                           value="${patient.dob}" disabled />
                                </div>

                                <div class="col-md-6">
                                    <label class="form-label">Số điện thoại</label>
                                    <input type="text" class="form-control"
                                           value="${patient.phone}" disabled />
                                </div>

                                <div class="col-md-6">
                                    <label class="form-label">Địa chỉ</label>
                                    <input type="text" class="form-control"
                                           value="${patient.address}" disabled />
                                </div>

                            </div>
                        </div>
                    </div>
                </c:if>

                <!-- ================= APPOINTMENT INFO ================= -->
                <div class="card shadow-sm border-0">
                    <div class="card-header bg-white fw-semibold">
                        <i class="fa-solid fa-clock me-2 text-success"></i>
                        Thông tin lịch khám
                    </div>

                    <div class="card-body bg-light">
                        <div class="row g-3">

                            <!-- Clinic room -->
                            <div class="col-md-6">
                                <label class="form-label fw-semibold">
                                    Phòng khám <span class="text-danger">*</span>
                                </label>
                                <select name="roomId" class="form-select" required>
                                    <option value="">-- Chọn phòng --</option>
                                    <c:forEach items="${rooms}" var="r">
                                        <option value="${r.id}">
                                            ${r.name}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>

                            <!-- Date -->
<!--                            <div class="col-md-6">
                                <label class="form-label fw-semibold">
                                    Ngày khám <span class="text-danger">*</span>
                                </label>
                                <input type="date"
                                       name="appointmentDate"
                                       class="form-control"
                                       required />
                            </div>-->

                            <!-- Note -->
                            <div class="col-12">
                                <label class="form-label">Ghi chú</label>
                                <textarea name="note"
                                          class="form-control"
                                          rows="3"
                                          placeholder="Triệu chứng ban đầu hoặc ghi chú cho bác sĩ..."></textarea>
                            </div>

                        </div>
                    </div>
                </div>

                <!-- ================= ACTIONS ================= -->
                <div class="d-flex justify-content-end mt-4">
                    <a href="${pageContext.request.contextPath}/receptionist/dashboard"
                       class="btn btn-outline-secondary me-2">
                        <i class="fa-solid fa-xmark me-1"></i>
                        Hủy
                    </a>

                    <button type="submit"
                            class="btn btn-success fw-semibold px-4"
                            <c:if test="${empty patient}">disabled</c:if>>
                        <i class="fa-solid fa-save me-1"></i>
                        Lưu lịch khám
                    </button>
                </div>

            </form>

        </div>
    </div>
</div>

    </body>
</html>
