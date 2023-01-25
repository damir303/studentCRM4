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
    <br>
    <h3>Редактирование студента</h3>
    <br>
    <form action="/studentProfile?id=${studentid}" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
        <div class="student-editing-box">
            <div class="avatar-editing">
                <div class="large_avatar_box" >
                    <img src=${avatarFilePath}>
                </div>
                <br>
                <p><input type="file" name="avatarfile"></p>
            </div>
            <div>
                <input class="field" placeholder="Имя" type="text" name="firstname" size="50" accept-charset="UTF-8" value="${firstname}" ><br>
                <input class="field" placeholder="Фамилия" type="text" name="lastname" size="50" accept-charset="UTF-8" value="${lastname}"><br>
                <input class="field" placeholder="Отчество" type="text" name="middlename" size="50" accept-charset="UTF-8" value="${middlename}"><br>
                <input class="field" placeholder="Группа" type="number" name="groupid" size="50" accept-charset="UTF-8" value="${groupid}"><br>
                <input class="field" placeholder="Эл. почта" type="email" name="email" size="50" accept-charset="UTF-8" value="${email}"><br>
                <input class="field" placeholder="Телефон" type="tel" name="phonenumber" size="50" accept-charset="UTF-8" value="${phonenumber}"><br>
                <p>Дата поступления:<input class="field" placeholder="Дата поступления" type="date" name="recieptdate" size="50" accept-charset="UTF-8" value="${recieptdate}"></p>
                <p>Действующий:<input type="checkbox" name="status" size="50" accept-charset="UTF-8" checked="${status}"></p><br>
                <input class="gradient-button" type="submit" value="Сохранить" accept-charset="UTF-8">
            </div>
        </div>
    </form>

</div>

<footer>
    Created by Mukhametov Damir &copy 2022
</footer>
</body>
</html>
