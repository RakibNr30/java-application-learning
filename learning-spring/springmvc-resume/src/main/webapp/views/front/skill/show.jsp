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
            <h5 class="card-title float-start">Skill</h5>
            <a href="/skill" class="btn btn-primary btn-sm float-end">Skill List</a>
        </div>
        <div class="card-body">
            <div class="container">
                <table class="table">
                    <tr>
                        <th>Name</th>
                        <td>${skill.name}</td>
                    </tr>
                    <tr>
                        <th>Proficiency</th>
                        <td>${skill.proficiency}</td>
                    </tr>
                    <tr>
                        <th>Created At</th>
                        <td>${skill.createdAt}</td>
                    </tr>
                    <tr>
                        <th>Updated At</th>
                        <td>${skill.updatedAt}</td>
                    </tr>
                </table>
            </div>
        </div>
    </div>

</div>

</body>
</html>