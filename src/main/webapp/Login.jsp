<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <title>Clinic Management - Login</title>

        <!-- Bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" rel="stylesheet">

        <!-- Custom style -->
        <style>
            body {
                background: linear-gradient(135deg, #e9f2ff, #f8fbff);
            }

            .login-card {
                border: 0;
                border-radius: 14px;
                position: relative;
            }

            .login-card::before {
                content: "";
                position: absolute;
                top: 0;
                left: 0;
                height: 5px;
                width: 100%;
                background: linear-gradient(90deg, #0d6efd, #3b82f6);
                border-top-left-radius: 14px;
                border-top-right-radius: 14px;
            }

            .login-icon {
                width: 64px;
                height: 64px;
                border-radius: 50%;
                background-color: #e7f0ff;
                display: inline-flex;
                align-items: center;
                justify-content: center;
                margin-bottom: 12px;
            }

            .login-icon i {
                font-size: 28px;
                color: #0d6efd;
            }

            .btn-login {
                padding: 10px;
                font-weight: 600;
            }
        </style>
    </head>

    <body class="d-flex align-items-center vh-100">

        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-5 col-lg-4">

                    <div class="card shadow-sm login-card">
                        <div class="card-body p-4">

                            <!-- ERROR -->
                            <c:if test="${not empty error}">
                                <div class="alert alert-danger d-flex align-items-center mb-3">
                                    <i class="fa-solid fa-triangle-exclamation me-2"></i>
                                    ${error}
                                </div>
                            </c:if>

                            <!-- HEADER -->
                            <div class="text-center mb-4">
                                <div class="login-icon mx-auto">
                                    <i class="fa-solid fa-hospital"></i>
                                </div>
                                <h5 class="fw-bold mb-1">Clinic Management System</h5>
                                <p class="text-muted small mb-0">
                                    Đăng nhập hệ thống nội bộ
                                </p>
                            </div>

                            <!-- FORM -->
                            <form action="login" method="post">

                                <!-- Username -->
                                <div class="mb-3">
                                    <label class="form-label">Username</label>
                                    <div class="input-group">
                                        <span class="input-group-text bg-white">
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
                                        <span class="input-group-text bg-white">
                                            <i class="fa-solid fa-lock"></i>
                                        </span>
                                        <input type="password"
                                               name="password"
                                               class="form-control"
                                               placeholder="Nhập mật khẩu"
                                               required>
                                    </div>
                                </div>

                                <!-- Button -->
                                <div class="d-grid mb-3">
                                    <button type="submit"
                                            class="btn btn-primary btn-login">
                                        <i class="fa-solid fa-right-to-bracket me-1"></i>
                                        Đăng nhập
                                    </button>
                                </div>

                                <!-- Notice -->
                                <div class="alert alert-info small mb-0">
                                    <i class="fa-solid fa-circle-info me-1"></i>
                                    Nếu quên mật khẩu, vui lòng liên hệ
                                    <b>1900 1889</b>
                                </div>

                            </form>

                        </div>
                    </div>

                </div>
            </div>
        </div>

    </body>
</html>
