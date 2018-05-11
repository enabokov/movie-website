<%--
  Created by IntelliJ IDEA.
  User: eduardnabokov
  Date: 5/8/18
  Time: 12:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="base.jsp"/>
<html>
    <head>
        <title>Registration</title>
    </head>
    <body>
        <div class="container">
            <div class="col-xs-6 col-md-4">
                <form action="registration" method="post">
                    <div class="form-group">
                        <label for="email">Email address*</label>
                        <input type="email" class="form-control" id="email" name="email" value="${email}" aria-describedby="emailHelp" placeholder="Enter email">
                        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                    </div>
                    <div class="form-group">
                        <label for="password">Password*</label>
                        <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                    </div>
                    <div class="form-group">
                        <label for="repeatPassword">Repeat password*</label>
                        <input type="password" class="form-control" id="repeatPassword" name="repeatPassword" placeholder="Repeat password">
                    </div>
                    <div class="form-group">
                        <label for="name">Name</label>
                        <input type="text" class="form-control" id="name" name="name" value="${name}" placeholder="Name">
                    </div>
                    <div class="form-group">
                        <label for="surname">Surname</label>
                        <input type="text" class="form-control" id="surname" name="surname" value="${surname}" placeholder="Surname">
                    </div>
                    <div class="form-group">
                        <label for="age">Age</label>
                        <input type="number" min="1" max="99" class="form-control" id="age" name="age" value="${age}" placeholder="Age">
                    </div>
                    <div class="form-group">
                        <label for="sex">Sex</label>
                        <select class="form-control" id="sex" name="sex">
                            <option>male</option>
                            <option>female</option>
                            <option></option>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                    <p>${error}</p>
                </form>
            </div>
        </div>
    </body>
</html>
