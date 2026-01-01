<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- PAGE WRAPPER -->
<div class="container my-4">
    <div class="row justify-content-center">
        <div class="col-lg-10 col-xl-9">

            <!-- TITLE -->
            <div class="mb-4">
                <h4 class="fw-bold mb-1">
                    <i class="fa-solid fa-user-plus me-2 text-warning"></i>
                    Tạo bệnh nhân mới
                </h4>
                <p class="text-muted mb-0">
                    Dành cho bệnh nhân lần đầu đến khám
                </p>
            </div>

            <!-- ERROR -->
            <c:if test="${not empty error}">
                <div class="alert alert-danger d-flex align-items-center mb-3">
                    <i class="fa-solid fa-triangle-exclamation me-2"></i>
                    ${error}
                </div>
            </c:if>

            <!-- FORM CARD -->
            <div class="card shadow border-0">
                <div class="card-body p-4 bg-light">

                    <!-- form POST về chính URL hiện tại -->
                    <form method="POST" class="row g-4">

                        <!-- Họ tên -->
                        <div class="col-md-6">
                            <label class="form-label fw-semibold">
                                Họ tên <span class="text-danger">*</span>
                            </label>
                            <div class="input-group">
                                <span class="input-group-text bg-white">
                                    <i class="fa-solid fa-user"></i>
                                </span>
                                <input type="text"
                                       name="name"
                                       class="form-control"
                                       placeholder="Nguyễn Văn A"
                                       required />
                            </div>
                        </div>

                        <!-- Giới tính -->
                        <div class="col-md-3">
                            <label class="form-label fw-semibold">Giới tính</label>
                            <div class="input-group">
                                <span class="input-group-text bg-white">
                                    <i class="fa-solid fa-venus-mars"></i>
                                </span>
                                <select name="gender" class="form-select">
                                    <option value="">-- Chọn --</option>
                                    <option value="Male">Nam</option>
                                    <option value="Female">Nữ</option>
                                </select>
                            </div>
                        </div>

                        <!-- Ngày sinh -->
                        <div class="col-md-3">
                            <label class="form-label fw-semibold">Ngày sinh</label>
                            <div class="input-group">
                                <span class="input-group-text bg-white">
                                    <i class="fa-solid fa-cake-candles"></i>
                                </span>
                                <input type="date"
                                       name="dob"
                                       class="form-control" />
                            </div>
                        </div>

                        <!-- Số điện thoại -->
                        <div class="col-md-6">
                            <label class="form-label fw-semibold">
                                Số điện thoại <span class="text-danger">*</span>
                            </label>
                            <div class="input-group">
                                <span class="input-group-text bg-white">
                                    <i class="fa-solid fa-phone"></i>
                                </span>
                                <input type="text"
                                       name="phone"
                                       class="form-control"
                                       placeholder="0xxx xxx xxx"
                                       required />
                            </div>
                            <div class="form-text">
                                Dùng để tra cứu nhanh bệnh nhân trong các lần khám sau
                            </div>
                        </div>

                        <!-- Địa chỉ -->
                        <div class="col-md-6">
                            <label class="form-label fw-semibold">Địa chỉ</label>
                            <div class="input-group">
                                <span class="input-group-text bg-white">
                                    <i class="fa-solid fa-location-dot"></i>
                                </span>
                                <input type="text"
                                       name="address"
                                       class="form-control"
                                       placeholder="Quận / Thành phố" />
                            </div>
                        </div>

                        <!-- ACTIONS -->
                        <div class="col-12 d-flex justify-content-end pt-3 border-top">
                            <a href="${pageContext.request.contextPath}/receptionist/dashboard"
                               class="btn btn-outline-secondary me-2">
                                <i class="fa-solid fa-xmark me-1"></i>
                                Hủy
                            </a>

                            <button type="submit"
                                    class="btn btn-warning fw-semibold px-4">
                                <i class="fa-solid fa-save me-1"></i>
                                Lưu bệnh nhân
                            </button>
                        </div>

                    </form>

                </div>
            </div>

        </div>
    </div>
</div>
