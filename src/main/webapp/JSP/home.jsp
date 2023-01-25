<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: rusanmuharlamov
  Date: 29.11.2022
  Time: 10:39
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
        <a href="/" class="gradient-button-selected">Объявления</a>
        <a href="/students" class="gradient-button">Учащиеся</a>
        <a href="/timetable" class="gradient-button">Расписание</a>
        <a href="/terms" class="gradient-button">Семестры</a>
        <a href="" class="gradient-button">Контакты</a>
    </div>
    <div class="content-box">
        <div class="grade-box">
            <a href="/createNews" class="action-button" ><img class="prefix-button" src="../resources/img/add.png" width="18px" alt="">Добавить объявление</a>
        </div>
        <c:forEach items="${allNews}" var="allNews">
            <div class="inline-box">
                <h1 display="inline">
                    ${allNews.header}
                    <a class="editing-box-button" href="/editnews?id=${allNews.id}"><img src="../resources/img/pencil.png" width="18px" alt=""></a>
                    <a class="trashing-box-button" href="/deletenews?id=${allNews.id}"><img src="../resources/img/trash.png" width="18px" alt=""></a>
                </h1>
            </div>
            ${allNews.content}
        </c:forEach>
    </div>
<footer>
    Created by Mukhametov Damir &copy 2022
</footer>
</body>
</html>
