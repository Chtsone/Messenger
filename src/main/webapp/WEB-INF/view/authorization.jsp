<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Main</title>
</head>
<body>
    <h1> Authorization form </h1>
<form:form action = "check" method = "post" modelAttribute ="user">
    Login <form:input type = "text" path = "login"/>
    </br>
    Password <form:input type = "password" path = "password"/>
    </br>
    <button type="submit"> Send dates </button>

</form:form>
    <a href = "registration">Registration</a>
</body>
</html>