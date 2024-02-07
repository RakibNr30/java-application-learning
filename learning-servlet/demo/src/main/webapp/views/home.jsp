<%--
  Created by IntelliJ IDEA.
  User: rakib
  Date: 1/23/24
  Time: 5:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/main.css">
</head>
<body>
<div class="container bg-secondary border-radius-5">
    <div class="title-bar text-center">
        <h1 class="title">Home Page</h1>
        <h2>Total Visit: (<c:out value="${visitCounter}" />)</h2>
    </div>
    <div class="navbar">
        <ul>
            <li class="active">
                <a href="home">Home</a>
            </li>
            <li>
                <a href="about">About</a>
            </li>
            <li>
                <a href="contact">Contact</a>
            </li>
        </ul>
    </div>
    <div class="body">
        <%= request.getAttribute("servletName") %>, <br>

        <c:out value="${servletName}" /> <br>

        <c:forEach items="${users}" var="user">
            ${user} <br>
        </c:forEach>
    </div>
</div>
</body>
</html>
