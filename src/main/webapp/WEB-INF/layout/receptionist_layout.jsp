<%-- 
    Document   : receptionist_layout
    Created on : Jan 1, 2026, 2:17:17 PM
    Author     : huytr
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.User" %>

<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <title>${pageTitle}</title>

        <!-- Bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/assets/style.css" rel="stylesheet">

        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" rel="stylesheet">

    </head>

    <body class="bg-light">

        <div class="container-fluid">
            <div class="row">
                <!--SIDEBAR-->
                <jsp:include page="/WEB-INF/layout/receptionist_sidebar.jsp"/>

                <!--MAIN CONTENT-->
                <div class="col p-4">
                    <jsp:include page="${contentPage}"/>
                </div>
                
            </div>
        </div>

    </body>
</html>


