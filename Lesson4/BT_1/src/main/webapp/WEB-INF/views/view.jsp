<%--
  Created by IntelliJ IDEA.
  User: phama
  Date: 10/8/2020
  Time: 10:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>View email configuration</title>
</head>
<body>
    <h2>Email configuration</h2>
    <table>
        <tr>
            <td>Language:</td>
            <td>${emailConfig.language}</td>
        </tr>
        <tr>
            <td>Page size:</td>
            <td>${emailConfig.pageSize}</td>
        </tr>
        <tr>
            <td>Enable Spam Filter:</td>
            <td>${emailConfig.enableSpamFilter}</td>
        </tr>
        <tr>
            <td>Signature:</td>
            <td>${emailConfig.signature}</td>
        </tr>
    </table>
</body>
</html>
