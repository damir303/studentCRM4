<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../resources/styles/style.css">
</head>
<body>
<div class="title-box">
    <div class="title-item">
        <h1>СИСТЕМА УПРАВЛЕНИЯ СТУДЕНТАМИ И ИХ УСПЕВАЕМОСТЬЮ</h1>
        <a href="/logout" class="gradient-button">Logout</a>
        <p class="gradient-button">${RoleName} ${FirstName} ${LastName}</p>
    </div>
    <c:if test="${isLogin!=1}">
        <div class="title-login">
            <a href="" class="gradient-button-leftside">Войти</a>
            <a href="" class="gradient-button-rightside">Регистрация</a>
        </div>
    </c:if>
</div>
<hr>
<div class="navigation-box">
    <a href="/home" class="gradient-button">Главная</a>
    <a href="/student" class="gradient-button">Студенты</a>
    <a href="disciplines.html" class="gradient-button">Дисциплины</a>
    <a href="terms.html" class="gradient-button">Семестры</a>
    <a href="" class="gradient-button">Контакты</a>
</div>
<div class="content-box">
    <h1>Отображена успеваемость для следующего студента</h1>

    <table class="students-table">
        <tr>
            <th>Фамилия</th>
            <th>Имя</th>
            <th>Группа</th>
            <th>Дата поступления</th>
        </tr>
        <tr>
            <td>${student.surname}</td>
            <td>${student.name}</td>
            <td>${student.group}</td>
            <td>${student.date_enter}</td>
        </tr>
    </table>
    <c:if test="${termNull != '1' }">
        <form action="/studen_progres" method="get" id="studenProgresForm">
            <input type="hidden" name="idStuden" value="${student.id}">
            <div class="grade-box">
                <div display="inline">
                    <b>Выбрать семестр:</b>
                    <select name="selectId" onchange="
                        document.getElementById('studenProgresForm').submit();">
                        <c:forEach items="${allTerms}" var="t">
                            <option
                                    <c:if test="${t eq term}">selected</c:if>
                                    value="${t.id}">${t.name}</option>
                        </c:forEach>

                            <%--                    <select name="selectId" onchange>--%>
                            <%--                        <option value="1">1 Семестр</option>--%>
                            <%--                        <option value="2">2 Семестр</option>--%>
                            <%--                    </select>--%>
                    </select>
                    <input type="submit" value="Выбрать">
                </div>
                <b>Длительность семестра: ${term.duration}</b>
                <b>Средняя оценка: ${avarageMark} </b>
            </div>
            <table class="students-table">
                <tr>
                    <th>Дисциплина</th>
                    <th>Оценка</th>
                </tr>
                <c:forEach items="${diplineMark}" var="dm">
                    <tr>
                        <td>${dm.name}</td>
                        <td>${dm.mark}</td>
                    </tr>
                </c:forEach>
            </table>

        </form>
    </c:if>
    <c:if test="${termNull == '1' }">
        <h2>У данного студента отсутсвубт семетры</h2>
    </c:if>
</div>
<footer>
    Created by Rushan Mukharlyamov &copy 2022
</footer>
</body>
</html>