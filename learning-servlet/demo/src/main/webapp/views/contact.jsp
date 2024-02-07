<%--
  Created by IntelliJ IDEA.
  User: rakib
  Date: 1/23/24
  Time: 5:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Contact</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/main.css">
</head>
<body>
<div class="container bg-secondary border-radius-5">
    <div class="title-bar text-center">
        <h1 class="title">Contact Page</h1>
    </div>
    <div class="navbar">
        <ul>
            <li>
                <a href="home">Home</a>
            </li>
            <li>
                <a href="about">About</a>
            </li>
            <li class="active">
                <a href="contact">Contact</a>
            </li>
        </ul>
    </div>
    <div class="contact-form">
        <form action="add-contact" method="POST">
            <div class="form-group">
                <label for="name">Name</label>
                <input id="name" name="name" type="text" class="form-control" value="Abdur Rakib" />
            </div>
            <div class="form-group">
                <label for="email">E-mail</label>
                <input id="email" name="email" type="email" class="form-control" value="abdur.rakib@dsinnovators.com" />
            </div>
            <div class="form-group">
                <label for="mobile">Mobile</label>
                <input id="mobile" name="mobile" type="text" class="form-control" value="01710115566" />
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>

    <sql:setDataSource var="postgres" driver="org.postgresql.Driver" url="jdbc:postgresql://localhost:5432/test" user="postgres" password="postgres" />
    <sql:query var="resultSet" dataSource="${postgres}">SELECT * FROM users</sql:query>

    <c:forEach items="${resultSet.rows}" var="user">
        <c:out value="${user.id}" /> -> <c:out value="${user.name}" />, <c:out value="${user.email}" />, <c:out value="${user.mobile}" /> <br>
    </c:forEach>

    <c:set var="strs" value="This is functionalities of function." />

    Length: ${fn:length(strs)} <br>

    Splits:
    <c:forEach items="${fn:split(strs, ' ')}" var="str">
        <c:out value="${str}" />, &nbsp;
    </c:forEach>

    <br>
    Apply Test (if/else):
    <c:if test="${fn:contains(strs, 'of')}" >
        Preposition is there.
    </c:if>

</div>
</body>
</html>

