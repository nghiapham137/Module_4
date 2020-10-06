<%--
  Created by IntelliJ IDEA.
  User: phama
  Date: 10/6/2020
  Time: 10:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
    <form action="/translate" method="post">
        <h1>Dictionary</h1>
        <label for="word">Input word:</label>
        <input id="word" type="text" name="word" value="${word}">
        <button type="submit">Search</button>
        <p>${output}</p>
    </form>
</body>
</html>
