<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ page isELIgnored="false" %>
    <link rel="stylesheet" type="text/css" href="../../resources/css/home_page_style.css">
    <script type="text/javascript" src="../../resources/js/dropzone.js"></script>
    <script type="text/javascript" src="../../resources/js/jquery-3.1.0.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../../resources/css/bootstrap.min.css">
    <script type="text/javascript" src="../../resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../../resources/js/respond.min.js"></script>
    <link href='https://fonts.googleapis.com/css?family=Lobster|Pacifico|Kaushan+Script' rel='stylesheet'
          type='text/css'>
    <title>Account</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-xs-2 col-md-2 icon">FileStorage</div>
        <div class="col-xs-10 col-md-10 header">

            <form class="button">
                <input class="button" type="button" value="Exit">
            </form>
            <form class="button">
                <input class="button" type="button" value="Sort">
            </form>
        </div>
    </div>
    <div class="row">
        <div class="col-xs-2 left-side">
            <div>
                <form class="button" action="/file/new" method="post">
                    <input type="text" placeholder="Enter name of new file here..." name="fileName" />
                    <input class="button" type="submit" value="Create">

                </form>
            </div>
            <div>
                <form class="button" enctype="multipart/form-data" action="/upload" method="post">
                     <input type="file" name="file" value="Upload" multiple/>
                    <input class="button" type="submit" value="Upload">
                </form>
            </div>
            <div>
                <form class="button">
                    <input class="button" type="button" value="Bin">
                </form>
            </div>
        </div>
        <div class="col-xs-10 content">
        </div>
    </div>

    <!-- List of files -->
    <div class="files">

    </div>


    <div class="row">
        <div class="col-xs-12 footer"> footer</div>
    </div>
</div>

<!--div id="icon">
	
</div>
<div id="header">
    <p>email</p>
</div>
<div id="left-side">
    <p>name</p>

</div>

<div>

</div>-->

<!--<div>
    <h3>${errorMessage}</h3>
</div>-->
</body>
</html>