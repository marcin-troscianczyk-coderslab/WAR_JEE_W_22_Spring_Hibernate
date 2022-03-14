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
        <span>Title:<form:input path="title"/></span>
        <span>Rating: <form:input path="rating"/></span>
        <span>Description: <form:input path="description"/></span>
        <span>Publisher: <form:select path="publisher.id" items="${publishers}" itemLabel="name" itemValue="id"/></span>
    </div>
    <input type="submit" value="Add book">
</form:form>
</body>
</html>
