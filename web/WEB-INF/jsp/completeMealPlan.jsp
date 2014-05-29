<%--
  Created by IntelliJ IDEA.
  User: shakhawat.hossain
  Date: 5/19/14
  Time: 12:09 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>
    <title>Meal plan</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>

<body>
<a class="logout" href="<c:url value="/logout"/>"> Logout</a>

<h2 class="title"> Meal Plan</h2>
<hr>
<div class="mealplan">
    <table>
        <tr>
            <td> Day</td>
            <td> BreakFast</td>
            <td> Lunch</td>
        </tr>

        <c:forEach var="mealPlan" items="${mealPlans}">
            <tr>
                <td><c:out value="${mealPlan.getDay()}"> </c:out></td>
                <td><c:out value="${mealPlan.getBreakfastMenu()}"> </c:out></td>
                <td><c:out value="${mealPlan.getLunchMenu()}"> </c:out></td>
            </tr>
        </c:forEach>

    </table>

</div>

<div class="full_less">
    <a href="<c:url value="/home"/>"> today's meal plan </a>
</div>

</body>
</html>