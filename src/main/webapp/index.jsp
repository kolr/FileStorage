<html>
<head>
    <title>Cloud</title>
    <meta charset="UTF-8">
    <script src="resources/js/jquery-1.12.3.min.js"></script>
    <script src="resources/js/modal.js"></script>
    <link rel="stylesheet" type="text/css" href="resources/css/cloud.css">
</head>
<body>
<div class="main-signin">
    <div class="main-signin_head">
        <p style="margin: 0px;"><img src="resources/logo.png"></p>
        <p style="font-size: 40px; color: #DFE8FF; margin: 0 0 50px 0">File Storage</p>
    </div>
    <div class="main-signin_middle">
        <div class="middle_form">
            <input type="text" placeholder="Login">
            <input type="password" placeholder="Password">
            <input type="submit" value="Sign in">
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
            <input type="text" placeholder="First name">
            <input type="text" placeholder="Second name">
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
</body>
</html>
