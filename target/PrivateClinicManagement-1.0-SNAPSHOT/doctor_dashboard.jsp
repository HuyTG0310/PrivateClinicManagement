<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <title>Doctor Dashboard</title>

        <!-- Bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" rel="stylesheet">
    </head>

    <body class="bg-light">

        <div class="container my-4">

            <!-- HEADER -->
            <div class="d-flex justify-content-between align-items-center mb-4">
                <h4 class="fw-bold mb-0">
                    <i class="fa-solid fa-user-doctor me-2 text-success"></i>
                    Doctor Dashboard
                </h4>
                <span class="text-muted">
                    Xin chào, <b>Bác sĩ Nguyễn Văn A</b>
                </span>
            </div>

            <!-- STATS -->
            <div class="row g-4 mb-4">

                <div class="col-md-4">
                    <div class="card shadow-sm border-0">
                        <div class="card-body text-center">
                            <i class="fa-solid fa-users fa-2x text-primary mb-2"></i>
                            <h6 class="fw-bold">Bệnh nhân hôm nay</h6>
                            <h3 class="mb-0">12</h3>
                        </div>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="card shadow-sm border-0">
                        <div class="card-body text-center">
                            <i class="fa-solid fa-clock fa-2x text-warning mb-2"></i>
                            <h6 class="fw-bold">Đang chờ khám</h6>
                            <h3 class="mb-0">5</h3>
                        </div>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="card shadow-sm border-0">
                        <div class="card-body text-center">
                            <i class="fa-solid fa-check fa-2x text-success mb-2"></i>
                            <h6 class="fw-bold">Đã khám xong</h6>
                            <h3 class="mb-0">7</h3>
                        </div>
                    </div>
                </div>

            </div>

            <!-- PATIENT LIST -->
            <div class="card shadow-sm border-0">
                <div class="card-header bg-white fw-semibold">
                    <i class="fa-solid fa-stethoscope me-2 text-success"></i>
                    Danh sách bệnh nhân chờ khám
                </div>

                <div class="card-body p-0">
                    <table class="table table-hover align-middle mb-0">
                        <thead class="table-light">
                            <tr>
                                <th class="text-center" style="width:80px;">STT</th>
                                <th>Bệnh nhân</th>
                                <th>Số điện thoại</th>
                                <th>Giờ check-in</th>
                                <th style="width:160px;" class="text-center">Hành động</th>
                            </tr>
                        </thead>
                        <tbody>

                            <tr>
                                <td class="text-center fw-bold text-primary">1</td>
                                <td>
                                    <i class="fa-solid fa-user me-1 text-secondary"></i>
                                    Phạm Công Phúc
                                </td>
                                <td>0969666999</td>
                                <td>13:41</td>
                                <td class="text-center">
                                    <a href="#"
                                       class="btn btn-success btn-sm">
                                        <i class="fa-solid fa-notes-medical me-1"></i>
                                        Khám
                                    </a>
                                </td>
                            </tr>

                            <tr>
                                <td class="text-center fw-bold text-primary">2</td>
                                <td>
                                    <i class="fa-solid fa-user me-1 text-secondary"></i>
                                    Trần Gia Huy
                                </td>
                                <td>0373347253</td>
                                <td>13:03</td>
                                <td class="text-center">
                                    <a href="#"
                                       class="btn btn-success btn-sm">
                                        <i class="fa-solid fa-notes-medical me-1"></i>
                                        Khám
                                    </a>
                                </td>
                            </tr>

                        </tbody>
                    </table>
                </div>
            </div>

        </div>

    </body>
</html>
