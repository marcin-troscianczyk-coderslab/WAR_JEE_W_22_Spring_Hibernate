<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add book</title>

    <style>
        .flex-container {
            display: flex;
            flex-direction: column;
        }

        .error {
            color: red;
        }
    </style>
</head>
<body>
<h1>Add book</h1>
<form:form method="post" modelAttribute="book">
    <div class="flex-container">
        <span>Title:<form:input path="title"/></span><form:errors path="title"/>
        <span>Rating: <form:input path="rating"/></span><form:errors path="rating"/>
        <span>Description: <form:input path="description"/></span><form:errors path="description"/>
        <span>Publisher: <form:select path="publisher.id" items="${publishers}" itemLabel="name" itemValue="id"/></span><form:errors path="publisher"/>
        <span>Authors: <form:select path="authors" items="${authors}" itemLabel="name" itemValue="id"/></span><form:errors path="authors"/>
        <span>Pages: <form:input path="pages"/></span><form:errors path="pages"/>
    </div>
    <input type="submit" value="Add book">
</form:form>
</body>
</html>
