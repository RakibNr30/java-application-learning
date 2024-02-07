<%--
  Created by IntelliJ IDEA.
  User: rakib
  Date: 1/24/24
  Time: 4:13 PM
  To change this template use File | Settings | File Templates.
--%>

<%--
    <%@ page import="java.util.*" %> --directive
    <%! System.out.println("abcd"); %> --declaration
    <% ou t("abcd") %> --scriptlet
    <%= value %> --expression
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <jsp:forward page="/home" />
</body>
</html>
