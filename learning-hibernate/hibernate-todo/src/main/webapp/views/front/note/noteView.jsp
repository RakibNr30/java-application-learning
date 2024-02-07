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
            <h5 class="card-title float-start">${note.title}</h5>
            <a href="${pageContext.request.contextPath}/note" class="btn btn-primary btn-sm float-end">Note List</a>
        </div>
        <div class="card-body">
            <p>
                ${note.content}
            </p>
        </div>
    </div>
</div>

</body>
</html>

