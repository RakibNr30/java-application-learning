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
            <h5 class="card-title float-start">User List (${ users.size() })</h5>
            <a href="/user/create" class="btn btn-primary btn-sm float-end">Add New</a>
        </div>
        <div class="card-body">
            <div class="container">
                <%-- notifier --%>
                <%@ include file="/views/partials/front/notifier.jsp" %>

                <div class="table-responsive">
                    <table class="table table-striped table-bordered text-center margin-top-10 text-nowrap">
                        <thead>
                        <tr>
                            <th scope="col">SL</th>
                            <th scope="col">Name</th>
                            <th scope="col">DOB</th>
                            <th scope="col">E-mail</th>
                            <th scope="col">Address</th>
                            <th scope="col">Created At</th>
                            <th scope="col">Updated At</th>
                            <th scope="col">Action</th>
                        </tr>
                        </thead>
                        <tbody>

                        <c:choose>
                            <c:when test="${users.size() > 0}">
                                <c:forEach items="${users}" var="user" varStatus="loop">
                                    <tr>
                                        <th scope="row">${loop.index + 1}</th>
                                        <td>${user.name}</td>
                                        <td>${user.dob}</td>
                                        <td>${user.email}</td>
                                        <td>${user.address}</td>
                                        <td>${user.createdAt}</td>
                                        <td>${user.updatedAt}</td>
                                        <td>
                                            <div class="btn-group" role="group" aria-label="Action">
                                                <a href="/user/${user.id}" class="btn btn-outline-secondary">View</a>
                                                <a href="/user/${user.id}/edit" class="btn btn-outline-primary border-right-none">Edit</a>
                                                <form action="/user/${user.id}/destroy" style="all: unset" method="POST">
                                                    <button type="submit" class="btn btn-outline-danger border-bottom-left-radius-0 border-top-left-radius-0">Delete</button>
                                                </form>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <tr>
                                    <td colspan="8">No user found.</td>
                                </tr>
                            </c:otherwise>
                        </c:choose>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

</div>

</body>
</html>