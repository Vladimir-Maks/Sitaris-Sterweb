<%@ page import="java.util.List" %>
<%@ page import="entities.Book" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        TABLE {
            width: 800px; /* Ширина таблицы */
            border-collapse: collapse; /* Убираем двойные линии между ячейками */
        }
        TD, TH {
            padding: 3px; /* Поля вокруг содержимого таблицы */
            border: 1px solid black; /* Параметры рамки */
        }
        TH {
            background: #b0e0e6; /* Цвет фона */
        }
    </style>
</head>
<body>
<table>
    <tr>
        <th>Название</th>
        <th>Автор</th>
        <th>Год выпуска</th>
        <th>Издательство</th>
        <th>Стоимость</th>
        <th>Количество</th>
    </tr>

        <c:forEach var="book" items="${bookList}">
            <tr>
                <td><c:out value="${book.title}" /></td>
                <td><c:out value="${book.author}" /></td>
                <td><c:out value="${book.date}" /></td>
                <td><c:out value="${book.publisher}" /></td>
                <td><c:out value="${book.cost}" /></td>
                <td><c:out value="${book.count}" /></td>
            </tr>

        </c:forEach>
    <tr>
        <td>&nbsp</td>
        <td>&nbsp</td>
        <td>&nbsp</td>
        <td>&nbsp</td>
       <td><c:out value="${Book.totalPrice(bookList)}" /></td>
        <td><c:out value="${Book.totalCount(bookList)}" /></td> 

    </tr>

</table>
</body>
</html>
