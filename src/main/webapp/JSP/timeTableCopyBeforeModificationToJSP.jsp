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

        .timetable-item{
            text-align: center;
            text-decoration: none;
            height: 200px;
            width: 14%;
            border-radius: 5px;
            font-family: 'Montserrat', sans-serif;
            background-image: linear-gradient(to right, #34a996 0%, #868396 51%, #b3ffff 100%);
            background-size: 200% auto;
            box-shadow: 0 0 20px rgba(0, 0, 0, .1);
            transition: .5s;
            opacity: 30%;

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
            text-decoration: none;
            font-family: 'Montserrat', sans-serif;
            opacity: 1;
        }
    </style>
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
    <a href="/" class="gradient-button">Главная</a>
    <a href="/students" class="gradient-button">Студенты</a>
    <a href="/timetable" class="gradient-button">Расписание</a>
    <a href="/terms" class="gradient-button">Семестры</a>
    <a href="" class="gradient-button">Контакты</a>
</div>
<div class="content-box">
    <div class="terms-filter-box">
        <br>
        <div display="inline">
            <b>Выбрать группу:</b>
            <select size="1" name="hero[]">
                <option value="1">Первый</option>
                <option selected value="2">Второй</option>
            </select>
        </div>
    </div>
    <h3>Расписание занятий</h3>
    <table class="timeTable">
        <tr>
            <td class="timetable-item">
                <div class="timetable-item-header">
                   (ПН) 09:30 - 10:50
                </div>
                <div class="timetable-item-content">
                    Математический анализ (Султанбеков А.Р.) Механический корпус каб. 2-мех
                </div>
            </td>
            <td class="timetable-item">
                <div class="timetable-item-header">
                   (ВТ) 09:30 - 10:50
                </div>
            </td>
            <td class="timetable-item">
                <div class="timetable-item-header">
                   (СР) 09:30 - 10:50
                </div>
            </td>
            <td class="timetable-item">
                <div class="timetable-item-header">
                   (ЧТ) 09:30 - 10:50
                </div>
            </td>
            <td class="timetable-item">
                <div class="timetable-item-header">
                   (ПТ) 09:30 - 10:50
                </div>
            </td>
            <td class="timetable-item">
                <div class="timetable-item-header">
                   (СБ) 09:30 - 10:50
                </div>
            </td>
        </tr>
        <tr>
            <td class="timetable-item">
                <div class="timetable-item-header">
                    (ПН) 11:10 - 12:30
                </div>
            </td>
            <td class="timetable-item">
                <div class="timetable-item-header">
                    (ВТ) 11:10 - 12:30
                </div>
            </td>
            <td class="timetable-item">
                <div class="timetable-item-header">
                    (СР) 11:10 - 12:30
                </div>
            </td>
            <td class="timetable-item">
                <div class="timetable-item-header">
                    (ЧТ) 11:10 - 12:30
                </div>
            </td>
            <td class="timetable-item">
                <div class="timetable-item-header">
                    (ПТ) 11:10 - 12:30
                </div>
            </td>
            <td class="timetable-item">
                <div class="timetable-item-header">
                    (СБ) 11:10 - 12:30
                </div>
            </td>
        </tr>
        <tr>
            <td class="timetable-item">
                <div class="timetable-item-header">
                    (ПН) 13:00 - 14:20
                </div>
            </td>
            <td class="timetable-item">
                <div class="timetable-item-header">
                    (ВТ) 13:00 - 14:20
                </div>
            </td>
            <td class="timetable-item">
                <div class="timetable-item-header">
                    (СР) 13:00 - 14:20
                </div>
            </td>
            <td class="timetable-item">
                <div class="timetable-item-header">
                    (ЧТ) 13:00 - 14:20
                </div>
            </td>
            <td class="timetable-item">
                <div class="timetable-item-header">
                    (ПТ) 13:00 - 14:20
                </div>
            </td>
            <td class="timetable-item">
                <div class="timetable-item-header">
                    (СБ) 13:00 - 14:20
                </div>
            </td>
        </tr>
        <tr>
            <td class="timetable-item">
                <div class="timetable-item-header">
                    (ПН) 16:20 - 17:40
                </div>
            </td>
            <td class="timetable-item">
                <div class="timetable-item-header">
                    (ВТ) 16:20 - 17:40
                </div>
            </td>
            <td class="timetable-item">
                <div class="timetable-item-header">
                    (СР) 16:20 - 17:40
                </div>
            </td>
            <td class="timetable-item">
                <div class="timetable-item-header">
                    (ЧТ) 16:20 - 17:40
                </div>
            </td>
            <td class="timetable-item">
                <div class="timetable-item-header">
                    (ПТ) 16:20 - 17:40
                </div>
            </td>
            <td class="timetable-item">
                <div class="timetable-item-header">
                    (СБ) 16:20 - 17:40
                </div>
            </td>

        </tr>
        <tr>
            <td class="timetable-item">
                <div class="timetable-item-header">
                    (ПН) 16:20 - 17:40
                </div>
            </td>
            <td class="timetable-item">
                <div class="timetable-item-header">
                    (ВТ) 16:20 - 17:40
                </div>
            </td>
            <td class="timetable-item">
                <div class="timetable-item-header">
                    (СР) 16:20 - 17:40
                </div>
            </td>
            <td class="timetable-item">
                <div class="timetable-item-header">
                    (ЧТ) 16:20 - 17:40
                </div>
            </td>
            <td class="timetable-item">
                <div class="timetable-item-header">
                    (ПТ) 16:20 - 17:40
                </div>
            </td>
            <td class="timetable-item">
                <div class="timetable-item-header">
                    (СБ) 16:20 - 17:40
                </div>
            </td>
        </tr>
        <tr>
            <td class="timetable-item">
                <div class="timetable-item-header">
                    (ПН) 18:00 - 19:20
                </div>
            </td>
            <td class="timetable-item">
                <div class="timetable-item-header">
                    (ВТ) 18:00 - 19:20
                </div>
            </td>
            <td class="timetable-item">
                <div class="timetable-item-header">
                    (СР) 18:00 - 19:20
                </div>
            </td>
            <td class="timetable-item">
                <div class="timetable-item-header">
                    (ЧТ) 18:00 - 19:20
                </div>
            </td>
            <td class="timetable-item">
                <div class="timetable-item-header">
                    (ПТ) 18:00 - 19:20
                </div>
            </td>
            <td class="timetable-item">
                <div class="timetable-item-header">
                    (СБ) 18:00 - 19:20
                </div>
            </td>

        </tr>
        <tr>
            <td class="timetable-item">
                <div class="timetable-item-header">
                    (ПН) 19:40 - 21:00
                </div>
            </td>
            <td class="timetable-item">
                <div class="timetable-item-header">
                    (ВТ) 19:40 - 21:00
                </div>
            </td>
            <td class="timetable-item">
                <div class="timetable-item-header">
                    (СР) 19:40 - 21:00
                </div>
            </td>
            <td class="timetable-item">
                <div class="timetable-item-header">
                    (ЧТ) 19:40 - 21:00
                </div>
            </td>
            <td class="timetable-item">
                <div class="timetable-item-header">
                    (ПТ) 19:40 - 21:00
                </div>
            </td>
            <td class="timetable-item">
                <div class="timetable-item-header">
                    (СБ) 19:40 - 21:00
                </div>
            </td>
        </tr>

    </table>
</div>
<footer>
    Created by Mukhametov Damir &copy 2022
</footer>
</body>
</html>