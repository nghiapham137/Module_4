<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: phama
  Date: 10/8/2020
  Time: 3:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Form</title>
</head>
<body>
<h1>Setting</h1>
<form:form method="post" action="addconfig" modelAttribute="emailConfig">
    <table>
        <tr>
            <td><form:label path="language">Language:</form:label></td>
            <td>
                <form:select path="language">
                    <form:option value="NONE" label="Select"/>
                    <form:options items="${listLanguage}"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><form:label path="pageSize">Page Size:</form:label></td>
            <td>Show
                <form:select path="pageSize">
<%--                    <form:option value="NONE" label="Select2"/>--%>
                    <form:options items="${listPageSize}"/>
                </form:select>
                emails per page
            </td>
        </tr>
        <tr>
            <td><form:label path="enableSpamFilter">Spam filter:</form:label></td>
            <td><form:checkbox path="enableSpamFilter" value="true"/> Enable spam filter </td>
        </tr>
        <tr>
            <td><form:label path="signature">Signature:</form:label></td>
            <td><form:textarea path="signature" rows="5"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Update"/></td>
            <td><input type="button" value="Cancel"></td>
        </tr>
    </table>
</form:form>

</body>
</html>
