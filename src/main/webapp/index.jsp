<html>
<head>
    <title>Cloud</title>
    <meta charset="UTF-8">
    <script src="resources/js/jquery-1.12.3.min.js"></script>
    <script src="resources/js/modal.js"></script>
    <link rel="stylesheet" type="text/css" href="resources/css/cloud.css">
    <link rel="shortcut icon" href="resources/mini-logo.png" type="image/png">
</head>
<body>
<div class="main-signin">
    <div class="main-signin_head">
        <p style="margin: 5px;"><img src="resources/logo.png"></p>
        <p style="font-size: 40px; color: #DFE8FF; margin: 0 0 30px 0">File Storage</p>
    </div>
    <div class="main-signin_middle">
        <div class="middle_form">
            <form action="user/auth" method="post">
                <input type="text" placeholder="Email" id="email" name="email">
                <input type="password" placeholder="Password" id="pass" name="pass">
                <input type="submit" value="Sign in">
            </form>
        </div>
    </div>
    <div class="main-signin_foot">
        <div class="foot_form">
            <a href="#dialog" name="modal"><input type="button" value="Sign up"></a>
        </div>
    </div>
</div>
<div id="main-signup">
    <div id="dialog" class="window">
        <div class="header">Sign up</div>
        <div class="middle_form">
            <input type="text" placeholder="Name">
            <input type="text" placeholder="Last name">
            <input type="text" placeholder="Email">
            <input type="password" placeholder="Password">
        </div>
        <div class="footer">
            <input type="submit" value="Send">
            <a href="#" id="close"/><input type="button" value="Cancel"></a>
        </div>
    </div>
    <div id="mask"></div>
</div>
<div id="footer">
    <p>Copyright &copy </p>
</div>
</body>
</html>
