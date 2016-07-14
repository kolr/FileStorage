<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Родион
  Date: 11.03.2016
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ page isELIgnored="false" %>
    <title>Users</title>
</head>
<body>
<c:forEach var="user" items="${lst}">
    <p>${user.email} - ${user.name} <span>${user.lastName}</span></p>
</c:forEach>
<h3>${errorMessage}</h3>
</body>
</html>
