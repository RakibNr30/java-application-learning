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
    <%@ include file="/views/partial/styles.jsp" %>
</head>
<body>

<div class="container">
    <%@ include file="/views/partial/header.jsp" %>

    <div class="card">
        <div class="card-header">
            <h5 class="card-title float-start">Add Note</h5>
            <a href="${pageContext.request.contextPath}/note" class="btn btn-primary btn-sm float-end">Note List</a>
        </div>
        <div class="card-body">
            <div class="container">
                <c:if test="${not empty status}">
                    <div class="alert alert-dark" role="alert">
                            ${status}
                        <c:remove var="status" />
                    </div>
                </c:if>
                <form class="row g-3" action="${pageContext.request.contextPath}/note/add" method="POST">
                    <div class="col-md-12">
                        <label for="title" class="form-label">Title</label>
                        <input type="text" id="title" name="title" placeholder="Enter title" class="form-control" required>
                    </div>
                    <div class="col-md-12">
                        <label for="content" class="form-label">Content</label>
                        <textarea type="text" id="content" name="content" placeholder="Enter title" class="form-control" rows="10" required></textarea>
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

