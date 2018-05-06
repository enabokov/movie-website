<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="base.jsp"/>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form action="login" method="post">
        Name: <input type="text" name="name" width="30"/>
        Password: <input type="password" name="password" width="30"/>
        <button type="submit">Submit</button>
    </form>
</body>
</html>
