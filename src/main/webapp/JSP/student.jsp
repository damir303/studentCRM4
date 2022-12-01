<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href= "../resources/styles/style.css">
</head>
<body>
<div class="title-box">
    <div class="title-item">
        <h1>СИСТЕМА УПРАВЛЕНИЯ СТУДЕНТАМИ И ИХ УСПЕВАЕМОСТЬЮ</h1>
    </div>
    <div class="title-login">
        <a href="" class="gradient-button-leftside">Войти</a>
        <a href="" class="gradient-button-rightside">Регистрация</a>
    </div>
</div>
<hr>
<div class="navigation-box">
    <a href="index.html" class="gradient-button">Главная</a>
    <a href="students.html" class="gradient-button">Студенты</a>
    <a href="disciplines.html" class="gradient-button">Дисциплины</a>
    <a href="terms.html" class="gradient-button">Семестры</a>
    <a href="" class="gradient-button">Контакты</a>
</div>
<div class="content-box">
    <a href="studentProgress.html" class="action-button">Посмотреть успеваемость</a>
    <a href="studentCreating.html" class="action-button"><img class="prefix-button" src="../resources/img/add.png"  width="18px" alt="">Добавить нового студента</a>
    <table class="students-table">
        <tr>
            <th>Фамилия</th>
            <th>Имя</th>
            <th>Отчество</th>
            <th>Группа</th>
            <th>Номер</th>
            <th>E-mail</th>
            <th>Дата поступления</th>
            <th></th>
        </tr>
        <c:forEach items="${allStudents}" var="s">
            <tr>
                <td>${s.surname}</td>
                <td>${s.name}</td>
                <td>Ринатович</td>
                <td>${s.group}</td>
                <td>+7 (906) 325 74 39</td>
                <td>muhr@1ccl.ru</td>
                <td>23.11.2022</td>
                <td display="inline">
                    <a class="editing-box-button" href=""><img src="../resources/img/pencil.png"  width="18px" alt=""></a>
                    <a class="trashing-box-button" href=""><img src="../resources/img/trash.png" width="18px" alt=""></a>
                </td>
            </tr>
        </c:forEach>
        </tr>
    </table>
</div>
<footer>
    Created by Rushan Mukharlyamov &copy 2022
</footer>
</body>
</html>