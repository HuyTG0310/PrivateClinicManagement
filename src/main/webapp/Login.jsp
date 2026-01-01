<%-- 
    Document   : Login
    Created on : Dec 31, 2025, 2:00:17 PM
    Author     : huytr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <title>Clinic Management - Login</title>
        <link href="bootstrap.min.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" rel="stylesheet">
    </head>

    <body class="bg-light d-flex align-items-center vh-100">

        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-5 col-lg-4">
                    <div class="card shadow border-0">
                        <div class="card-body p-4">

                            <!-- FORM START -->
                            <form action="login" method="post">

                                <!-- ERROR -->
                                <c:if test="${not empty error}">
                                    <div class="alert alert-danger d-flex align-items-center mb-3" role="alert">
                                        <i class="fa-solid fa-triangle-exclamation me-2"></i>
                                        <span>${error}</span>
                                    </div>
                                </c:if>

                                <!-- Header -->
                                <div class="text-center mb-4">
                                    <i class="fa-solid fa-hospital fa-3x text-primary mb-2"></i>
                                    <h4 class="fw-bold">Clinic Management System</h4>
                                    <p class="text-muted mb-0">Đăng nhập hệ thống nội bộ</p>
                                </div>

                                <!-- Username -->
                                <div class="mb-3">
                                    <label class="form-label">Username</label>
                                    <div class="input-group">
                                        <span class="input-group-text">
                                            <i class="fa-solid fa-user"></i>
                                        </span>
                                        <input type="text"
                                               name="username"
                                               class="form-control"
                                               placeholder="Nhập username"
                                               value="${username}"
                                               required>
                                    </div>
                                </div>

                                <!-- Password -->
                                <div class="mb-3">
                                    <label class="form-label">Password</label>
                                    <div class="input-group">
                                        <span class="input-group-text">
                                            <i class="fa-solid fa-lock"></i>
                                        </span>
                                        <input type="password"
                                               name="password"
                                               class="form-control"
                                               placeholder="Nhập mật khẩu"
                                               value="${password}"
                                               required>
                                    </div>
                                </div>

                                <!-- Login button -->
                                <div class="d-grid mb-3">
                                    <button type="submit" class="btn btn-primary fw-bold">
                                        <i class="fa-solid fa-right-to-bracket me-1"></i>
                                        Đăng nhập
                                    </button>
                                </div>

                                <!-- Notice -->
                                <div class="alert alert-info small mb-0">
                                    <i class="fa-solid fa-circle-info me-1"></i>
                                    Nếu quên mật khẩu, vui lòng liên hệ
                                    <b>1900 1889</b> để được cấp lại.
                                </div>

                            </form>
                            <!-- FORM END -->

                        </div>
                    </div>
                </div>
            </div>
        </div>

    </body>

</html>

