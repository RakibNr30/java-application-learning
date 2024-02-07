<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>${ title }</title>
    <%@ include file="/views/partials/front/style.jsp" %>
</head>
<body>

<div class="container">
    <%@ include file="/views/partials/front/header.jsp" %>

    <div class="card">
        <div class="card-header">
            <h5 class="card-title float-start">${user.name}</h5>
            <a href="/user" class="btn btn-primary btn-sm float-end">User List</a>
        </div>
        <div class="card-body">
            <div class="container">
                <table class="table">
                    <tr>
                        <th>E-mail</th>
                        <td>${user.email}</td>
                    </tr>
                    <tr>
                        <th>Address</th>
                        <td>${user.address}</td>
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