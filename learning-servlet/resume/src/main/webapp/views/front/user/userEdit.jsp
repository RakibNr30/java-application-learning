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
</head>
<body>

<div class="container">
    <%@ include file="/views/partial/header.jsp" %>

    <div class="card">
        <div class="card-header">
            <h5 class="card-title float-start">Edit User</h5>
            <a href="${pageContext.request.contextPath}/user" class="btn btn-primary btn-sm float-end">User List</a>
        </div>
        <div class="card-body">
            <div class="container">
                <c:if test="${not empty status}">
                    <div class="alert alert-dark" role="alert">
                            ${status}
                        <c:remove var="status" />
                    </div>
                </c:if>
                <form class="row g-3" action="${pageContext.request.contextPath}/user/edit/${user.id}" method="POST">
                    <div class="col-md-6">
                        <label for="name" class="form-label">Name</label>
                        <input type="text" id="name" name="name" placeholder="Enter name" value="${user.name}" class="form-control" required>
                    </div>
                    <div class="col-md-6">
                        <label for="email" class="form-label">Email</label>
                        <input type="email" id="email" name="email" placeholder="Enter email" value="${user.email}" class="form-control" required>
                    </div>
                    <div class="col-md-6">
                        <label for="mobile" class="form-label">Mobile</label>
                        <input type="text" id="mobile" name="mobile" placeholder="Enter mobile" value="${user.mobile}" class="form-control" required>
                    </div>
                    <div class="col-md-6">
                        <label for="dob" class="form-label">Date of Birth</label>
                        <input type="date" id="dob" name="dob" value="${user.dob}" class="form-control" required>
                    </div>

                    <div class="col-12">
                        <div class="float-end">
                            <button type="reset" class="btn btn-danger">Reset</button>
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

</div>

</body>
</html>

