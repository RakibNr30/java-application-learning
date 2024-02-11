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
            <h5 class="card-title float-start">Add Skill</h5>
            <a href="/skill" class="btn btn-primary btn-sm float-end">Skill List</a>
        </div>
        <div class="card-body">
            <div class="container">
                <%-- notifier --%>
                <%@ include file="/views/partials/front/notifier.jsp" %>

                <form class="row g-3" action="/skill/store" method="POST">
                    <div class="col-md-6">
                        <label for="name" class="form-label">Name</label>
                        <input type="text" id="name" name="name" placeholder="Enter name" class="form-control" required>
                    </div>
                    <div class="col-md-6">
                        <label for="proficiency" class="form-label">Proficiency</label>
                        <select id="proficiency" name="proficiency" class="form-select" aria-label="Select Proficiency" required>
                            <option selected>Select Proficiency</option>
                            <option value="1">Basic</option>
                            <option value="2">Intermediate</option>
                            <option value="3">Advanced</option>
                        </select>
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