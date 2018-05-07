<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="/">Movies</a>
                </div>
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1
                            <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Page-1</a></li>
                        </ul>
                    </li>
                    <li><a href="#">About</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <c:choose>
                        <c:when test="${email != null}">
                            <li><a href="#">${email}</a></li>
                            <li><a href="#"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="registration"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                            <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
        </nav>
    </body>
</html>
