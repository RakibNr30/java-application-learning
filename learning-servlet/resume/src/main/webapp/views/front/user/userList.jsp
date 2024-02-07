<%--
  Created by IntelliJ IDEA.
  User: rakib
  Date: 1/29/24
  Time: 12:51 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap-5.0.2.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main.css?v=1">
</head>
<body>

<div class="container">
    <%@ include file="/views/partial/header.jsp" %>

    <div class="card">
        <div class="card-header">
            <h5 class="card-title float-start">User List (Total User: ${users.size()}, Page Visit: ${visitCounter}, Site Visit: ${siteVisitCounter})</h5>
            <a href="${pageContext.request.contextPath}/user/add" class="btn btn-primary btn-sm float-end">Add New</a>
        </div>
        <div class="card-body">
            <c:if test="${not empty status}">
                <div class="alert alert-dark" role="alert">
                        ${status}
                    <c:remove var="status" />
                </div>
            </c:if>
            <div class="table-responsive">
                <table class="table table-striped table-bordered text-center margin-top-10 text-nowrap">
                    <thead>
                    <tr>
                        <th scope="col">SL</th>
                        <th scope="col">Name</th>
                        <th scope="col">E-mail</th>
                        <th scope="col">Mobile</th>
                        <th scope="col">DOB</th>
                        <th scope="col">Created At</th>
                        <th scope="col">Updated At</th>
                        <th scope="col">Action</th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach items="${users}" var="user" varStatus="loop">
                        <tr>
                            <th scope="row">${loop.index + 1}</th>
                            <td>${user.name}</td>
                            <td>${user.email}</td>
                            <td>${user.mobile}</td>
                            <td>${user.dob}</td>
                            <td>${user.createdAt}</td>
                            <td>${user.updatedAt}</td>
                            <td>
                                <div class="btn-group" role="group" aria-label="Action">
                                    <a href="${pageContext.request.contextPath}/user/${user.id}" class="btn btn-outline-secondary">View</a>
                                    <a href="${pageContext.request.contextPath}/user/edit/${user.id}" class="btn btn-outline-primary border-right-none">Edit</a>
                                    <form action="${pageContext.request.contextPath}/user/${user.id}" style="all: unset" method="POST">
                                        <button type="submit" class="btn btn-outline-danger border-bottom-left-radius-0 border-top-left-radius-0">Delete</button>
                                    </form>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>

        </div>
    </div>

</div>

</body>
</html>
