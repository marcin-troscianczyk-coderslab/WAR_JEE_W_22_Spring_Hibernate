<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Person Form</title>
</head>
<body>
<h1>Person Form</h1>
<form:form method="post" modelAttribute="person">
    Login: <form:input path="login"/>
    Password: <form:password path="password"/>
    E-mail: <form:input path="email" type="email"/>
    <input type="submit" value="Wyślij">
</form:form>
</body>
</html>
