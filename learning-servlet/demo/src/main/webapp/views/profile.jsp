<%--
  Created by IntelliJ IDEA.
  User: rakib
  Date: 1/24/24
  Time: 6:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<%
    String url = "jdbc:postgresql://localhost:5432/test";
    String username = "postgres";
    String password = "postgres";

    String query = "SELECT * FROM users";

    try {
        Class.forName("org.postgresql.Driver");
    } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    }
    Connection connection = null;
    try {
        connection = DriverManager.getConnection(url, username, password);
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    Statement statement = null;
    try {
        statement = connection.createStatement();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    ResultSet resultSet = null;
    try {
        resultSet = statement.executeQuery(query);
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    try {
        resultSet.next();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
%>

Name: <%= resultSet.getString(1) %>
Email: <%= resultSet.getString(2) %>
Mobile: <%= resultSet.getString(3) %>
</body>
</html>
