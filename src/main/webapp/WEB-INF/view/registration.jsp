<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
</head>
<body>
<h1>Registration form</h1>
    <form:form action="menu" method="post" modelAttribute = "user">
        Login <form:input type="text" path = "login"/> <form:errors path = "login" />
        <br>
        Password <form:input type="password" path = "password"/> <form:errors path = "password" />
        <br>
        Email <form:input type="email" path = "email"/> <form:errors path = "email" />
        <br>
        Age <form:input type="number" path = "age"/> <form:errors path = "age" />
        <br>
        Sex <form:input type="text" path = "sex"/> <form:errors path = "sex" />
        <br>
        <input type="submit" value = "send"/>
    </form:form>
</body>
</html>