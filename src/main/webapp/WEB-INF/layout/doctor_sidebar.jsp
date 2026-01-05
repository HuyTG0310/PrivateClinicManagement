<%-- 
    Document   : doctor_sidebar
    Created on : Jan 1, 2026, 9:53:31 PM
    Author     : huytr
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- DOCTOR SIDEBAR -->
<div class="col-md-3 col-lg-2 sidebar min-vh-100 p-3">

    <h5 class="text-center mb-4 sidebar-title">
        <i class="fa-solid fa-user-doctor me-1"></i>
        Doctor System
    </h5>

    <ul class="nav nav-pills flex-column gap-2 sidebar-menu">

        <!-- Dashboard -->
        <li class="nav-item">
            <a class="nav-link ${activePage == 'doctorDashboard' ? 'active' : ''}"
               href="${pageContext.request.contextPath}/doctor/dashboard">
                <i class="fa-solid fa-gauge me-2"></i>
                Dashboard
            </a>
        </li>

        <!-- Waiting Patients -->
        <li class="nav-item">
            <a class="nav-link ${activePage == 'waitingPatients' ? 'active' : ''}"
               href="${pageContext.request.contextPath}/doctor/patients/waiting">
                <i class="fa-solid fa-stethoscope me-2"></i>
                Bệnh nhân chờ khám
            </a>
        </li>

        <li class="nav-item">
            <a class="nav-link ${activePage == 'examiningPatients' ? 'active' : ''}"
               href="${pageContext.request.contextPath}/doctor/examining">
                <i class="fa-solid fa-hourglass-half me-2"></i>
                Đang khám
            </a>
        </li>

        <!-- Medical History -->
        <li class="nav-item">
            <a class="nav-link ${activePage == 'medicalHistory' ? 'active' : ''}"
               href="${pageContext.request.contextPath}/doctor/history">
                <i class="fa-solid fa-file-medical me-2"></i>
                Lịch sử khám
            </a>
        </li>


        <!-- Logout -->
        <li class="nav-item mt-3">
            <a class="nav-link logout"
               href="${pageContext.request.contextPath}/logout">
                <i class="fa-solid fa-right-from-bracket me-2"></i>
                Đăng xuất
            </a>
        </li>

    </ul>
</div>
