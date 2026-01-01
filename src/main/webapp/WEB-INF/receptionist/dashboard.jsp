<%@ page contentType="text/html;charset=UTF-8" %>

<!-- TOP BAR -->
<div class="d-flex justify-content-between align-items-center mb-4">
    <h4 class="fw-bold mb-0">
        <i class="fa-solid fa-user-nurse me-2 text-primary"></i>
        Receptionist Dashboard
    </h4>
    <span class="text-muted">
        Xin chào,
        <b>${sessionScope.user.fullName}</b>
    </span>
</div>

<!-- FUNCTION CARDS -->
<div class="row g-4">

    <!-- Card: Appointment List -->
    <div class="col-md-6 col-lg-4">
        <div class="card shadow-sm h-100 border-2 border-primary">
            <div class="card-body text-center">
                <i class="fa-solid fa-calendar-check fa-3x text-primary mb-3"></i>
                <h5 class="fw-bold">Danh sách lịch khám</h5>
                <p class="text-muted small">
                    Xem và quản lý các lịch khám của bệnh nhân
                </p>
                <a href="${pageContext.request.contextPath}/receptionist/appointments/list"
                   class="btn btn-outline-primary">
                    Truy cập
                </a>
            </div>
        </div>
    </div>

    <!-- Card: Create Appointment -->
    <div class="col-md-6 col-lg-4">
        <div class="card shadow-sm h-100 border-2 border-success">
            <div class="card-body text-center">
                <i class="fa-solid fa-calendar-plus fa-3x text-success mb-3"></i>
                <h5 class="fw-bold">Tạo lịch khám</h5>
                <p class="text-muted small">
                    Đặt lịch khám cho bệnh nhân đã có hồ sơ
                </p>
                <a href="${pageContext.request.contextPath}/receptionist/appointments/create"
                   class="btn btn-outline-success">
                    Tạo lịch
                </a>
            </div>
        </div>
    </div>

    <!-- Card: Create Patient -->
    <div class="col-md-6 col-lg-4">
        <div class="card shadow-sm h-100 border-start border-2 border-warning">
            <div class="card-body text-center">
                <i class="fa-solid fa-user-plus fa-3x text-warning mb-3"></i>
                <h5 class="fw-bold">Tạo bệnh nhân mới</h5>
                <p class="text-muted small">
                    Dành cho bệnh nhân lần đầu đến khám
                </p>
                <a href="${pageContext.request.contextPath}/receptionist/patients/create"
                   class="btn btn-outline-warning">
                    Tạo hồ sơ
                </a>
            </div>
        </div>
    </div>

</div>
