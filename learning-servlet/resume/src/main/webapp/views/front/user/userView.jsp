<%--
  Created by IntelliJ IDEA.
  User: rakib
  Date: 1/29/24
  Time: 4:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap-5.0.2.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main.css">
</head>
<body>

<div class="container">
    <%@ include file="/views/partial/header.jsp" %>

    <div class="card">
        <div class="card-header">
            <h5 class="card-title float-start">${user.name}</h5>
            <a href="${pageContext.request.contextPath}/user" class="btn btn-primary btn-sm float-end">User List</a>
        </div>
        <div class="card-body">
            <div class="container">
                <table class="table">
                    <tr>
                        <th>E-mail</th>
                        <td>${user.email}</td>
                    </tr>
                    <tr>
                        <th>Mobile</th>
                        <td>${user.mobile}</td>
                    </tr>
                    <tr>
                        <th>Date of Birth</th>
                        <td>${user.dob}</td>
                    </tr>
                    <tr>
                        <th>Created At</th>
                        <td>${user.createdAt}</td>
                    </tr>
                    <tr>
                        <th>Updated At</th>
                        <td>${user.updatedAt}</td>
                    </tr>
                </table>
            </div>
        </div>
    </div>

</div>

</body>
</html>

