<%--
  Created by IntelliJ IDEA.
  User: eduardnabokov
  Date: 5/6/18
  Time: 9:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%-- TODO: use value form bean. get info if user is logged in--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="base.jsp">
  <jsp:param name="loggedIn" value="false"/>
</jsp:include>
<html>
  <head>
    <title>Index</title>
  </head>
  <body>
    <div class="container">
      <h1>Here is main page of movies</h1>
    </div>
  </body>
</html>
