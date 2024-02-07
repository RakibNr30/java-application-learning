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
    <%@ include file="/views/partial/styles.jsp" %>
</head>
<body>

<div class="container">
    <%@ include file="/views/partial/header.jsp" %>

    <div class="card">
        <div class="card-header">
            <h5 class="card-title float-start">Notes (${notes.size()})</h5>
            <a href="${pageContext.request.contextPath}/note/add" class="btn btn-primary btn-sm float-end">Add New</a>
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
                        <th scope="col">Title</th>
                        <th scope="col">Created At</th>
                        <th scope="col">Updated At</th>
                        <th scope="col">Action</th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:choose>
                        <c:when test="${notes.size() > 0}">
                            <c:forEach items="${notes}" var="note" varStatus="loop">
                                <tr>
                                    <th scope="row">${loop.index + 1}</th>
                                    <td>${note.title}</td>
                                    <td>${note.createdAt}</td>
                                    <td>${note.updatedAt}</td>
                                    <td>
                                        <div class="btn-group" role="group" aria-label="Action">
                                            <a href="${pageContext.request.contextPath}/note/${note.id}" class="btn btn-outline-secondary">View</a>
                                            <a href="${pageContext.request.contextPath}/note/edit/${note.id}" class="btn btn-outline-primary border-right-none">Edit</a>
                                            <form action="${pageContext.request.contextPath}/note/${note.id}" style="all: unset" method="POST">
                                                <button type="submit" class="btn btn-outline-danger border-bottom-left-radius-0 border-top-left-radius-0">Delete</button>
                                            </form>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <tr>
                                <td colspan="5" class="text-center">
                                    No notes found...
                                </td>
                            </tr>
                        </c:otherwise>
                    </c:choose>

                    </tbody>
                </table>
            </div>

        </div>
    </div>

</div>

</body>
</html>
