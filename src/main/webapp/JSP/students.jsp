<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: rusanmuharlamov
  Date: 29.11.2022
  Time: 11:46
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

        .student-box{
            text-decoration: none;
            text-align: left;
            vertical-align: middle;
            color: rgb(0, 0, 0);
            border-radius: 8%;
            background-color: #2b2bcc;
            font-family: 'Montserrat', sans-serif;
            text-transform: uppercase;
            box-shadow: 0 0 10px rgba(0, 0, 0, .1);
            transition: .5s;
        }

        .student-box:hover {
            background-color: aqua;
        }
        .students-list-box-container {
            color: black;
            border-radius: 10px;
            width: 98%;
        }

        students-list-box {
            color: black;
            border-radius: 10px;
            width: 99%;
        }
        .students-info{
            text-align: left;
            vertical-align: middle;
            font-size: 90%;
            padding: 10px;
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
    <a href="/students" class="gradient-button-selected">Учащиеся</a>
    <a href="/timetable" class="gradient-button">Расписание</a>
    <a href="/terms" class="gradient-button">Семестры</a>
    <a href="" class="gradient-button">Контакты</a>
</div>

<div class="content-box">
    <div class="groupSelectionForm">
        <b class="course-label">Курс:</b>
        <a class=<c:choose><c:when test="${selectedCourse == 1}">"course-button-selected"</c:when><c:otherwise>"course-button"</c:otherwise></c:choose> href="#" onclick="studentsGroupIsChanged(1,'')">Первый</a>
        <a class=<c:choose><c:when test="${selectedCourse == 2}">"course-button-selected"</c:when><c:otherwise>"course-button"</c:otherwise></c:choose> href="#" onclick="studentsGroupIsChanged(2,'')">Второй</a>
        <a class=<c:choose><c:when test="${selectedCourse == 3}">"course-button-selected"</c:when><c:otherwise>"course-button"</c:otherwise></c:choose> href="#" onclick="studentsGroupIsChanged(3,'')">Третий</a>
        <a class=<c:choose><c:when test="${selectedCourse == 4}">"course-button-selected"</c:when><c:otherwise>"course-button"</c:otherwise></c:choose> href="#" onclick="studentsGroupIsChanged(4,'')">Четвертый</a>

        <b <c:choose> <c:when test="${noData}"> hidden </c:when> </c:choose> class="group-label">Группа:</b>
        <c:forEach items="${groups}" var="groupItem">
            <a class=<c:choose><c:when test="${selectedGroup == groupItem.groupID}">"group-button-selected"</c:when><c:otherwise>"group-button"</c:otherwise></c:choose> href="#" onclick="studentsGroupIsChanged(${groupItem.courseIndex},${groupItem.groupID})">${groupItem.groupName}</a>
        </c:forEach>

        <form hidden action="/" method="POST" id="studentsGroupSelectionForm">
            <input type="button" name="test" value="test">
        </form>
    </div>
    <a href="/studentProfile" class="action-button"><img class="prefix-button" src="../resources/img/add.png"  width="18px" alt="">Добавить нового студента</a>
    <br>
    <div class="students-list-box-container">
        <div class="students-list-box">
            <c:forEach items="${students}" var="student">
                <a href="/studentProfile?id=${student.id}" class="student-box">
                    <div class="students-info">
                            ${student.lastname} ${student.firstname} ${student.middlename}
                    </div>
                </a>
            </c:forEach>
        </div>
    </div>

</div>

<footer>
    Created by Mukhametov Damir &copy 2022
</footer>
</body>
</html>
