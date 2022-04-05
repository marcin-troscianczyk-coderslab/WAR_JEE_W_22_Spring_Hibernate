<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Search books</title>
</head>
<body>


<table>
    <tr>
        <th>Lp.</th>
        <th>Title</th>
        <th>Rating</th>
        <th>Description</th>
        <th>Publisher</th>
        <th>Authors</th>
        <th>Pages</th>
    </tr>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.rating}</td>
            <td>${book.description}</td>
            <td>${book.publisher.name}</td>
            <td>${book.authors}</td>
            <td>${book.pages}</td>
            <td><a href="book/edit?id=${book.id}">Edit</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
