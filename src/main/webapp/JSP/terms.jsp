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
  <a href="/timetable" class="gradient-button">Расписание</a>
  <a href="/terms" class="gradient-button-selected">Семестры</a>
  <a href="" class="gradient-button">Контакты</a>
</div>
<div class="content-box">
  <div class="terms-filter-box">
    <br>
    <div display="inline">
      <b>Выбрать семестр:</b>
      <select size="1" name="hero[]">
        <option value="1">Первый</option>
        <option selected value="2">Второй</option>
      </select>
    </div>
    <b>Длительность семестра: 24 недели</b>
  </div>
  <a href="termCreating.html" class="action-button"><img class="prefix-button" src="img/add.png"  width="18px" alt="">Создать семестр</a>
  <a href="termModifying.html" class="action-button">Изменить текущий семестр</a>
  <a href="" class="action-button"><img class="prefix-button" src="img/trash.png"  width="18px" alt="">Удалить текущий семестр</a>
  <h3>Список дисциплин семестра</h3>
  <table>
    <c:forEach items="${allTerms}" var="allTerms">
      <tr>
        <td>${allTerms.name}</td>
        <td display="inline">
          <a class="editing-box-button" href=""><img src="../resources/img/pencil.png"  width="18px" alt=""></a>
          <a class="trashing-box-button" href=""><img src="../resources/img/trash.png" width="18px" alt=""></a>
        </td>
      </tr>
    </c:forEach>
  </table>
</div>
<footer>
  Created by Mukhametov Damir &copy 2022
</footer>
</body>
</html>