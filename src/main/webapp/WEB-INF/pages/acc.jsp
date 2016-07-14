<%--
  Created by IntelliJ IDEA.
  User: Родион
  Date: 11.03.2016
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ page isELIgnored="false" %>
    <title>Account</title>
</head>
<body>
<h3>${currentUser.name}</h3>
<h3>${currentUser.lastName}</h3>
<h2>${currentUser.email}</h2>

<div>
    <h3>${errorMessage}</h3>
</div>
</body>
</html>
