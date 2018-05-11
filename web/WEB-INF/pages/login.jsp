<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="base.jsp"/>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <div class="container">
        <div class="col-xs-6 col-md-4">
            <form action="login" method="post">
                <div class="form-group">
                    <label for="email">Email address*</label>
                    <input type="email" class="form-control" id="email" placeholder="Enter email">
                </div>
                <div class="form-group">
                    <label for="password">Password*</label>
                    <input type="password" class="form-control" id="password" placeholder="Password">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
                <p>${error}</p>
            </form>
        </div>
    </div>
</body>
</html>
