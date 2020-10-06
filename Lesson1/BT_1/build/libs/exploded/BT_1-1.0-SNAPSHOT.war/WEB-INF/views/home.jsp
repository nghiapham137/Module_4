<%--
  Created by IntelliJ IDEA.
  User: phama
  Date: 10/6/2020
  Time: 9:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Money Exchange</title>
</head>
<body>
    <form method="post" action="/exchange">
        <h1>Money Exchanger</h1>
        <label for="usd">USD</label>
        <input type="number" step="any" id="usd" name="usd" placeholder="input usd">
        <button type="submit">Exchange</button>
        <p>${usd}</p>
    </form>

</body>
</html>
