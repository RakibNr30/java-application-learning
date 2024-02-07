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
            <h5 class="card-title float-start">${ title }</h5>
        </div>
        <div class="card-body">
            <div class="contact-form">
                <form action="/contact/update" method="POST">
                    <div class="row">
                        <input type="hidden" name="id" value="${contact.id}">
                        <div class="col-md-4 mb-3">
                            <label for="email">E-mail</label>
                            <input id="email" name="email" type="email" placeholder="Enter email" class="form-control" value="${contact.email}" />
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="mobile">Mobile</label>
                            <input id="mobile" name="mobile" type="text" placeholder="Enter mobile" class="form-control" value="${contact.mobile}" />
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="location">Location</label>
                            <input id="location" name="location" type="text" placeholder="Enter location" class="form-control" value="${contact.location}" />
                        </div>
                        <div class="col-md-12 mb-3">
                            <label for="details" class="form-label">Details</label>
                            <textarea type="text" id="details" name="details" placeholder="Enter details" class="form-control" rows="8" required>${contact.details}</textarea>
                        </div>
                        <div class="col-12">
                            <div class="float-end">
                                <button type="reset" class="btn btn-danger">Reset</button>
                                <button type="submit" class="btn btn-primary">Submit</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>