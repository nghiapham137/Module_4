<%--
  Created by IntelliJ IDEA.
  User: phama
  Date: 10/8/2020
  Time: 9:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
</head>
<body>
    <h1>Welcome</h1>
    <h3>Account: ${user.account}</h3>
    <h3>Password: ${user.password}</h3>
    <h3>Name: ${user.name}</h3>
    <h3>Email: ${user.email}</h3>
    <h3>Age: ${user.age}</h3>
    <a href="/home">Back to Login</a>
</body>
</html>
