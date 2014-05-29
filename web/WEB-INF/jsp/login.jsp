<%--
  Created by IntelliJ IDEA.
  User: shakhawat.hossain
  Date: 5/19/14
  Time: 11:52 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>

<html>
<head>
    <title>login</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
<form action="<c:url value="/login"/>" method="POST">
    <div id="login">
        <table>
            <tr>
                <td>
                    <input class="uidfield" type="text" name="userId" placeholder="user id">
                <td>
            <tr>
            <tr>
                <td>
                    <input class="passfield" type="password" name="password" placeholder="password">
                <td>
            <tr>
            <tr>
                <td>
                    <input type="checkbox" name="admin" value="1"> admin
                    <input type="submit" id="loginButton" value="Login">
                </td>

            </tr>
            <tr>
                <td>
                    <c:if test="${message != null}">
                        <p class="login_failed"><c:out value="${message}"/> &nbsp</p>
                    </c:if>
                </td>
            </tr>
        </table>
    </div>

</form>

</body>
</html>