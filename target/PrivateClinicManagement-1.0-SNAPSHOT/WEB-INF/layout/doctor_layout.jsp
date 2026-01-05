<%-- 
    Document   : doctor_layout
    Created on : Jan 1, 2026, 9:54:17 PM
    Author     : huytr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <title>${pageTitle}</title>

        <!-- Bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" rel="stylesheet">

        <!-- Shared style -->
        <link href="${pageContext.request.contextPath}/assets/style.css" rel="stylesheet">
    </head>

    <body class="bg-light">

        <div class="container-fluid">
            <div class="row">

                <%-- SIDEBAR --%>
                <jsp:include page="/WEB-INF/layout/doctor_sidebar.jsp"/>

                <%-- MAIN CONTENT --%>
                <div class="col-md-9 col-lg-10 p-4">
                    <jsp:include page="${contentPage}" />
                </div>

            </div>
        </div>

    </body>
</html>
