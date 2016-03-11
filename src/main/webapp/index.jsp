<html>
<head>
    <title>Cloud</title>
    <link rel="stylesheet" type="text/css" href="resources/css/cloud.css">
</head>
<body>
<h2>Hello World!</h2>
<%--<form action="/user/registration" method="post">--%>
    <%--<input type="text" name="login" id="login" placeholder="Login"/>--%>
    <%--<input type="text" name="name" id="name" placeholder="Login"/>--%>
    <%--<input type="text" name="lastname" id="lastname" placeholder="Login"/>--%>
    <%--<input type="password" name="pass" id="pass" placeholder="Password"/>--%>
    <%--<input type="text" name="role" id="role" placeholder="Role(Admin/Client)"/>--%>
    <%--<input type="submit"/>--%>
<%--</form>--%>
<div class="index-sign-in-to-cloud">
    <form action="/user/auth" method="post">
        <div class="index-sign-in-input-container">
            <input class="index-sign-in-input index-sign-in-input-top" type="text" name="login" placeholder="Login"/>
            <input class="index-sign-in-input index-sign-in-input-bottom" type="password" name="pass" placeholder="Password"/>
        </div>
        <input type="submit"/>
    </form>
</div>
</body>
</html>
