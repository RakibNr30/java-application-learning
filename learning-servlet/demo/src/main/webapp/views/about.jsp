<%--
  Created by IntelliJ IDEA.
  User: rakib
  Date: 1/23/24
  Time: 5:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<html>
<head>
    <title>About</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/main.css">
</head>
<body>
<div class="container bg-secondary border-radius-5">
    <div class="title-bar text-center">
        <h1 class="title">About Page</h1>
    </div>
    <div class="navbar">
        <ul>
            <li>
                <a href="home">Home</a>
            </li>
            <li class="active">
                <a href="about">About</a>
            </li>
            <li>
                <a href="contact">Contact</a>
            </li>
        </ul>
    </div>

    <%
        double x = 5 / 0;
    %>
</div>
</body>
</html>

