<%--
  Created by IntelliJ IDEA.
  User: rusanmuharlamov
  Date: 30.11.2022
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="ru">
<head>

  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
  <a href="/students" class="gradient-button">Учащиеся</a>
  <a href="/timetable" class="gradient-button-selected">Расписание</a>
  <a href="/terms" class="gradient-button">Семестры</a>
  <a href="" class="gradient-button">Контакты</a>
</div>
<form  action="/timetableEditing?id=${timeTableItem.id}&groupId=${timeTableItem.groupId}&dayOfWeek=${timeTableItem.dayOfWeek}&pairInIndex=${timeTableItem.pairInIndex}" class="content-box" method="post" accept-charset="UTF-8">
  <h3>Редактирование расписания ${timeTableItem.header} для группы ${groupName}</h3>
  <p>
    <b>Содержание</b>
    <br>
    <textarea name="content" cols="40" rows="3" accept-charset="UTF-8" >${timeTableItem.content}</textarea>
  </p>
  <input class="gradient-button" type="submit" value="Сохранить" accept-charset="UTF-8">
</form>
<footer>
  Created by Mukhametov Damir &copy 2022
</footer>
</body>
</html>
