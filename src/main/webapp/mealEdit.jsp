<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="meal" scope="request" type="ru.javawebinar.topjava.model.Meal"/>

<html>
<head>
    <title>Meal form</title>
</head>

<body>
    <h3><a href="index.html">Home</a></h3>
    <hr>
    <h2>${meal.isNewMeal()  ? "Add new meal": 'Edit meal'}</h2>

    <form method="post" action="meals">
        <input name="id" type="hidden" value="${meal.id}">
        <input name="isNewMeal" type="hidden" value="${meal.isNewMeal()}">
        <table>
            <tr>
                <td>Date time:</td>
                <td><label><input type="datetime-local" name="datetime" value="${meal.dateTime}"/></label></td>
            </tr>
            <tr>
                <td>Description:</td>
                <td><label><input type="text" name="description" value="${meal.description}" size="50"></label></td>
            </tr>
            <tr>
                <td>Calories:</td>
                <td><label><input type="text" name="calories" value="${meal.calories}" size="50"></label></td>
            </tr>
        </table>
        <p><input type="submit" value="Save">
            <input type="button" onclick="history.back();" value="Cancel"/>
        </p>
    </form>
</body>
</html>