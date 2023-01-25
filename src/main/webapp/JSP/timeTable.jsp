<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: rusanmuharlamov
  Date: 29.11.2022
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href= "../resources/styles/style.css">
    <script type='text/javascript' src='../resources/js/fieldEvents.js'></script>
    <style>
        th {
            text-align: left;
            width: 14%;
        }
        td {
            min-width: 14%;
            margin: 10px;
            vertical-align: top;
        }

        tr{
            margin: 10px;
        }

        table {
            min-width: 99%;
            margin: 0 auto;
        }

        td {
            width: 14%;
        }

        .timetable-item-today{
            text-align: center;
            text-decoration: none;
            height: 150px;
            width: 100%;
            border-radius: 5px;
            font-family: 'Montserrat', sans-serif;
            background-color: rgb(66, 190, 57);
            background-size: 200% auto;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.05);
            transition: .5s;
            opacity: 1;
        }

        .timetable-item-today:hover{
            background-color: #8779e2;
            opacity: 1;
        }

        .timetable-item{
            text-align: center;
            text-decoration: none;
            height: 150px;
            width: 100%;
            border-radius: 5px;
            font-family: 'Montserrat', sans-serif;
            background-color: rgba(0, 0, 0, .1);
            background-size: 200% auto;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.05);
            transition: .5s;
            opacity: .4;
        }

        .timetable-item:hover{
            background-color: #8779e2;
            opacity: 1;
        }

        .timetable-item-selected{
            text-align: center;
            text-decoration: none;
            height: 150px;
            width: 100%;
            border-radius: 5px;
            font-family: 'Montserrat', sans-serif;
            background-color: rgb(68, 186, 239);
            background-size: 200% auto;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.05);
            transition: .5s;
            opacity: 1;
        }

        .timetable-item-header{
            text-align: left;
            padding: 10px;
            text-decoration: none;
            font-family: 'Montserrat', sans-serif;
            font-weight: bold;
            opacity: 1;
        }

        .timetable-item-content{
            text-align: left;
            padding: 10px;
            padding: 14px;
            width: 90%;
            height: 100%;
            border-radius: 5px;
            text-decoration: none;
            vertical-align: top;
            font-family: 'Montserrat', sans-serif;
            font-size: 13px;
            opacity: 1;
        }

        .timetable-item-selected:hover{
            background-color: #8779e2;
        }

        a {
            text-decoration: none;
            color: black;
        }

        .groupSelectionForm{
            border-radius: 10px;
            padding: 10px;
            display: flex;
            justify-content: flex-start;
            align-items: center;


        }

        .course-button{
            background-color: #c6faf3;
            margin: 5px;
            padding: 10px;
            border-radius: 10px;
        }

        .course-button-selected{
            background-color: #34cbb8;
            margin: 5px;
            padding: 10px;
            border-radius: 10px;
        }

        .course-button:hover{
            background-color: #34cbb8;
        }

        .group-button{
            background-color: #c6faf3;
            padding: 10px;
            margin: 5px;
            border-radius: 10px;
        }

        .group-button-selected{
            background-color: #34cbb8;
            padding: 10px;
            margin: 5px;
            border-radius: 10px;
        }

        .group-button:hover{
            background-color: #34cbb8;
        }

        .course-label{
            margin-right: 5px;
            padding-right: 5px;
        }

        .group-label{
            margin-right: 5px;
            margin-left: 5px;
            padding-right: 5px;
            padding-left: 5px;
        }

        .content-box {
            margin: 10px;
            padding: 1px 20px 20px 20px;
            color: black;
            border-radius: 0px 10px 10px 10px;
            background-color: #cafff6;
        }
    </style>
</head>
<body>
<div class="title-box">
    <img class="logo" src="../resources/img/logo.png">
    <div class="title-item">
        <h1>ЭЛЕКТРОННЫЙ УНИВЕРСИТЕТ</h1>
    </div>
</div>
<div class="navigation-box">
    <a href="/" class="gradient-button">Объявления</a>
    <a href="/students" class="gradient-button">Учащиеся</a>
    <a href="/timetable" class="gradient-button-selected">Расписание</a>
    <a href="/terms" class="gradient-button">Семестры</a>
    <a href="" class="gradient-button">Контакты</a>
</div>
<div class="content-box">
    <div class="groupSelectionForm">
        <b class="course-label">Курс:</b>
        <a class=<c:choose><c:when test="${selectedCourse == 1}">"course-button-selected"</c:when><c:otherwise>"course-button"</c:otherwise></c:choose> href="#" onclick="timetableGroupIsChanged(1,'')">Первый</a>
        <a class=<c:choose><c:when test="${selectedCourse == 2}">"course-button-selected"</c:when><c:otherwise>"course-button"</c:otherwise></c:choose> href="#" onclick="timetableGroupIsChanged(2,'')">Второй</a>
        <a class=<c:choose><c:when test="${selectedCourse == 3}">"course-button-selected"</c:when><c:otherwise>"course-button"</c:otherwise></c:choose> href="#" onclick="timetableGroupIsChanged(3,'')">Третий</a>
        <a class=<c:choose><c:when test="${selectedCourse == 4}">"course-button-selected"</c:when><c:otherwise>"course-button"</c:otherwise></c:choose> href="#" onclick="timetableGroupIsChanged(4,'')">Четвертый</a>

        <b <c:choose> <c:when test="${noData}"> hidden </c:when> </c:choose> class="group-label">Группа:</b>
        <c:forEach items="${groups}" var="groupItem">
            <a class=<c:choose><c:when test="${selectedGroup == groupItem.groupID}">"group-button-selected"</c:when><c:otherwise>"group-button"</c:otherwise></c:choose> href="#" onclick="timetableGroupIsChanged(${groupItem.courseIndex},${groupItem.groupID})">${groupItem.groupName}</a>
        </c:forEach>

        <form hidden action="/" method="POST" id="timetableGroupSelectionForm">
            <input type="button" name="test" value="test">
        </form>
    </div>

    <c:choose>
        <c:when test="${noData}">
            <h1> На данном курсе еще нет учащихся </h1>
        </c:when>
        <c:otherwise>
            <table class="timeTable">
                <c:forEach items="${timetable}" var="timetableitem">
                    <tr>
                        <c:forEach items="${timetableitem}" var="timetableitemMap">
                            <td>
                                <a href="/timetableEditing?id=${timetableitemMap.id}&groupId=${timetableitemMap.groupId}&dayOfWeek=${timetableitemMap.dayOfWeek}&pairInIndex=${timetableitemMap.pairInIndex}">
                                    <div class=<c:choose><c:when test="${timetableitemMap.content == ''}">"timetable-item"</c:when><c:when test="${timetableitemMap.dayOfWeek == (today-1)}">"timetable-item-today"</c:when><c:otherwise>"timetable-item-selected"</c:otherwise></c:choose>>
                                        <div class="timetable-item-header">
                                            ${timetableitemMap.header}
                                        </div>
                                        <div class="timetable-item-content">
                                            ${timetableitemMap.content}
                                        </div>
                                    </div>
                                </a>
                            </td>
                        </c:forEach>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>
</div>
<footer>
    Created by Mukhametov Damir &copy 2022
</footer>
</body>
</html>