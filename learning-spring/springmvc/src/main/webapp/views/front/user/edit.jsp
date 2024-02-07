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
            <h5 class="card-title float-start">Edit User (${user.name})</h5>
            <a href="/user" class="btn btn-primary btn-sm float-end">User List</a>
        </div>
        <div class="card-body">
            <div class="container">
                <c:if test="${not empty status}">
                    <div class="alert alert-dark" role="alert">
                            ${status}
                        <c:remove var="status" />
                    </div>
                </c:if>
                <form class="row g-3" action="/user/${user.id}/update" method="POST">
                    <div class="col-md-6">
                        <label for="name" class="form-label">Name</label>
                        <input type="text" id="name" name="name" placeholder="Enter name" class="form-control" value="${user.name}" required>
                    </div>
                    <div class="col-md-6">
                        <label for="email" class="form-label">E-mail</label>
                        <input type="email" id="email" name="email" placeholder="Enter email" class="form-control" value="${user.email}" required>
                    </div>
                    <div class="col-md-12">
                        <label for="address" class="form-label">E-mail</label>
                        <input type="text" id="address" name="address" placeholder="Enter address" class="form-control" value="${user.address}" required>
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