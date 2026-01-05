<%-- 
    Document   : doctor_exam
    Created on : Jan 2, 2026, 8:18:49 AM
    Author     : huytr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="d-flex justify-content-between align-items-center mb-4">
    <h4 class="fw-bold mb-0">
        <i class="fa-solid fa-notes-medical me-2 text-success"></i>
        Khám bệnh
    </h4>
    <a href="${pageContext.request.contextPath}/doctor/dashboard"
       class="btn btn-outline-secondary btn-sm">
        <i class="fa-solid fa-arrow-left me-1"></i>
        Quay lại
    </a>
</div>


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
                       value="${queueNumber}" disabled>
            </div>

            <div class="col-md-4">
                <label class="form-label">Họ tên</label>
                <input type="text" class="form-control"
                       value="${patient.name}" disabled>
            </div>


            <div class="col-md-4">
                <label class="form-label">Ngày sinh</label>
                <input type="text" class="form-control"
                       value="${patient.dob}" disabled>
            </div>



        </div>
    </div>
</div>


<form method="post"
      action="${pageContext.request.contextPath}/doctor/exam/save_diagnosis"
      class="mb-4">

    <input type="hidden" name="appointmentId" value="${appointmentId}" />

    <div class="card shadow-sm border-0">
        <div class="card-header bg-white fw-semibold">
            <i class="fa-solid fa-stethoscope me-2 text-danger"></i>
            Chẩn đoán
        </div>

        <div class="card-body bg-light">
            <textarea name="diagnosis"
                      class="form-control"
                      rows="3"
                      placeholder="Nhập chẩn đoán bệnh...">${exam.diagnosis}</textarea>

            <div class="text-end mt-3">
                <button class="btn btn-outline-primary btn-sm">
                    Lưu chẩn đoán
                </button>
            </div>
        </div>
    </div>
</form>



<form method="post"
      action="${pageContext.request.contextPath}/doctor/exam/request_test"
      class="mb-4">

    <input type="hidden" name="appointmentId" value="${appointmentId}" />

    <div class="card shadow-sm border-0">
        <div class="card-header bg-white fw-semibold">
            <i class="fa-solid fa-vials me-2 text-info"></i>
            Xét nghiệm
        </div>

        <div class="card-body bg-light">

            <div class="row g-3">
                <c:forEach items="${testTypes}" var="t">
                    <div class="col-md-4">
                        <div class="form-check">
                            <input class="form-check-input"
                                   type="checkbox"
                                   name="testTypeIds"
                                   value="${t.testTypeId}">
                            <label class="form-check-label">
                                ${t.testTypeName}
                            </label>
                        </div>
                    </div>
                </c:forEach>
            </div>

            <div class="text-end mt-3">
                <button class="btn btn-outline-primary btn-sm">
                    Gửi yêu cầu xét nghiệm
                </button>
            </div>

        </div>
    </div>
</form>

<c:if test="${not empty testRequests}">
    <div class="card shadow-sm border-0 mb-4">

        <div class="card-header bg-white fw-semibold">
            <i class="fa-solid fa-flask me-2 text-success"></i>
            Kết quả xét nghiệm
        </div>

        <div class="card-body bg-light p-0">

            <table class="table table-sm table-bordered align-middle mb-0 bg-white">
                <thead class="table-light">
                    <tr>
                        <th>Xét nghiệm</th>
                        <th>Ngày yêu cầu</th>
                        <th>Trạng thái</th>
                        <th>Kết quả</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${testRequests}" var="t">
                        <tr>
                            <td>${t.testTypeName}</td>
                            <td>${t.requestDate}</td>

                            <td>
                                <c:choose>
                                    <c:when test="${t.status == 'WAITING'}">
                                        <span class="badge bg-warning text-dark">
                                            Đang chờ
                                        </span>
                                    </c:when>
                                    <c:when test="${t.status == 'DONE'}">
                                        <span class="badge bg-success">
                                            Có kết quả
                                        </span>
                                    </c:when>
                                </c:choose>
                            </td>

                            <td>
                                <c:if test="${t.status == 'DONE'}">
                                    <span class="fw-semibold text-success">
                                        ${t.resultValue}
                                    </span>
                                </c:if>
                                <c:if test="${t.status != 'DONE'}">
                                    —
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
</c:if>




<form method="post"
      action="${pageContext.request.contextPath}/doctor/exam/save_prescription"
      class="mb-4">

    <input type="hidden" name="appointmentId" value="${appointmentId}" />

    <div class="card shadow-sm border-0">
        <div class="card-header bg-white fw-semibold d-flex justify-content-between align-items-center">
            <span>
                <i class="fa-solid fa-pills me-2 text-warning"></i>
                Đơn thuốc
            </span>

            <button type="button"
                    id="btnAddMedicine"
                    class="btn btn-sm btn-outline-primary">
                <i class="fa-solid fa-plus me-1"></i>
                Thêm thuốc
            </button>
        </div>
        <div class="card-body p-0">
            <table class="table table-bordered align-middle mb-0">
                <thead class="table-light">
                    <tr>
                        <th>Thuốc</th>
                        <th style="width:100px;">SL</th>
                        <th>Liều dùng</th>
                        <th style="width:60px;"></th>
                    </tr>
                </thead>

                <tbody id="medicineTableBody">

                    <!-- DÒNG THUỐC -->
                    <tr class="medicine-row">
                        <td>
                            <input type="text"
                                   name="medicineName[]"
                                   class="form-control"
                                   list="medicineList"
                                   placeholder="Gõ tên thuốc..."
                                   autocomplete="off">
                            <!--datalist chỉ trả về name-->
                            <datalist id="medicineList">
                                <c:forEach items="${medicines}" var="m">
                                    <option value="${m.name}">
                                        ${m.unit}
                                    </option>
                                </c:forEach>
                            </datalist>
                        </td>

                        <td>
                            <input type="number"
                                   name="quantity[]"
                                   class="form-control"
                                   min="1">
                        </td>

                        <td>
                            <input type="text"
                                   name="dosage[]"
                                   class="form-control"
                                   placeholder="VD: 2 viên/ngày">
                        </td>

                        <td class="text-center">
                            <button type="button"
                                    class="btn btn-sm btn-outline-danger btn-remove">
                                <i class="fa-solid fa-trash"></i>
                            </button>
                        </td>
                    </tr>

                </tbody>
            </table>
        </div>


        <div class="text-end p-3">
            <button class="btn btn-outline-primary btn-sm">
                Lưu đơn thuốc
            </button>
        </div>
    </div>
</form>


<script>
    document.getElementById("btnAddMedicine")
            .addEventListener("click", function () {

                const tbody = document.getElementById("medicineTableBody");
                const firstRow = tbody.querySelector(".medicine-row");

                // clone dòng đầu
                const newRow = firstRow.cloneNode(true);

                // clear value
                newRow.querySelectorAll("input").forEach(i => i.value = "");

                tbody.appendChild(newRow);
            });

    // delegate remove
    document.addEventListener("click", function (e) {
        if (e.target.closest(".btn-remove")) {
            const rows = document.querySelectorAll(".medicine-row");
            if (rows.length > 1) {
                e.target.closest("tr").remove();
            }
        }
    });
</script>
