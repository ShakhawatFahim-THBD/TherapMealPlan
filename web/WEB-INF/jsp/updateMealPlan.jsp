<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Meal Plan</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/adminpage.js"/>"></script>

</head>

<body>
<a style="color: #77b55a">active users :  <c:out value="${loggedInUserCount}"> </c:out>   </a>   </br>
<a  href="<c:url value="/logout"/>"> logout</a>
 <a></a>
<h2 class="title"> Meal Plan : Admin Panel</h2>
<hr>

<div class="mealplan">
    <table>
        <tr>
            <td>Day</td>
            <td>BreakFast</td>
            <td>Lunch</td>
            <td>&nbsp</td>
        </tr>
        <c:forEach var="mealPlan" items="${mealPlans}" varStatus="itemCount">
            <tr>
                <form method="POST" action="<c:url value="/update-meal-plan"/>">

                    <td><c:out value="${mealPlan.getDay()}"> </c:out></td>

                    <td style="padding : 0px">
                        <textarea name="breakfast" id="<c:out value = '${itemCount.count}'> </c:out>breakfast"
                                  readonly><c:out value="${mealPlan.getBreakfastMenu()}"> </c:out></textarea>
                    </td>

                    <td style="padding : 0px;">
                        <textarea name="lunch" id="<c:out value='${itemCount.count}'> </c:out>lunch" readonly><c:out
                                value="${mealPlan.getLunchMenu()}"> </c:out></textarea>
                    </td>

                    <td>
                        <a class="edit" href="#" id="1"
                           onClick="setEditable(<c:out value='${itemCount.count}'></c:out>+'breakfast', <c:out
                                   value='${itemCount.count}'></c:out>+'lunch')">&nbsp;&nbsp;edit </a>

                        <input type="submit" value="save" id="button_save">
                    </td>

                    <input type="hidden" name="day" value="<c:out value="${mealPlan.getDay()}"> </c:out>">
                </form>

            </tr>

        </c:forEach>

    </table>

</div>

</body>
</html>