<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div class="col-md-3 col-lg-2 sidebar min-vh-100 p-3">
    <h5 class="text-center mb-4 sidebar-title">
        <i class="fa-solid fa-hospital me-1"></i>
        Clinic System
    </h5>

    <ul class="nav nav-pills flex-column gap-2 sidebar-menu">

        <li class="nav-item">
            <a class="nav-link ${activePage == 'dashboard' ? 'active' : ''}" href="${pageContext.request.contextPath}/receptionist/dashboard">
                <i class="fa-solid fa-gauge me-2"></i>
                Dashboard
            </a>
        </li>

        <li class="nav-item">
            <a class="nav-link  ${activePage == 'appointments' ? 'active' : ''}"
               href="${pageContext.request.contextPath}/receptionist/appointments/list">
                <i class="fa-solid fa-calendar-check me-2"></i>
                Lịch khám
            </a>
        </li>

        <li class="nav-item">
            <a class="nav-link  ${activePage == 'createAppointment' ? 'active' : ''}"
               href="${pageContext.request.contextPath}/receptionist/appointments/create">
                <i class="fa-solid fa-calendar-plus me-2"></i>
                Tạo lịch khám
            </a>
        </li>

        <li class="nav-item">
            <a class="nav-link  ${activePage == 'createPatient' ? 'active' : ''}"
               href="${pageContext.request.contextPath}/receptionist/patients/create">
                <i class="fa-solid fa-user-plus me-2"></i>
                Tạo bệnh nhân
            </a>
        </li>

        <li class="nav-item mt-3">
            <a class="nav-link logout"
               href="${pageContext.request.contextPath}/logout">
                <i class="fa-solid fa-right-from-bracket me-2"></i>
                Đăng xuất
            </a>
        </li>

    </ul>
</div>
