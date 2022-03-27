<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit book</title>

    <style>
        .flex-container {
            display: flex;
            flex-direction: column;
        }
    </style>
</head>
<body>
<c:choose>
    <c:when test="${notfound}">
        <h2>Nie znaleziono ksążki</h2>
    </c:when>
    <c:otherwise>
        <h1>Edit book</h1>
        <form:form method="post" modelAttribute="book">
            <div class="flex-container">
                <span>Title:<form:input path="title"/></span>
                <span>Rating: <form:input path="rating"/></span>
                <span>Description: <form:input path="description"/></span>
                <span>Publisher: <form:select path="publisher" items="${publishers}" itemLabel="name" itemValue="id"/></span>
                <span>Authors: <form:select path="authors" items="${authors}" itemLabel="name" itemValue="id"/></span>
                <span>Pages: <form:input path="pages"/></span>
            </div>
            <form:hidden path="id"/>
            <input type="submit" value="Save changes">
        </form:form>
    </c:otherwise>
</c:choose>
</body>
</html>
