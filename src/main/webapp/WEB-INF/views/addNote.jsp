<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="icon" href="asset/images/pencil.png">
    <title>Note Taking</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="Onur Solmaz" />

    <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
    <link rel="shortcut icon" href="favicon.ico">
    <!-- Google Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Playfair+Display:400,700,400italic|Roboto:400,300,700' rel='stylesheet' type='text/css'>
    <!-- Animate -->
    <link rel="stylesheet" href="asset/css/animate.css">
    <!-- Icomoon -->
    <link rel="stylesheet" href="asset/css/icomoon.css">
    <!-- Bootstrap  -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">

    <link rel="stylesheet" href="asset/css/style.css">


    <!-- Modernizr JS -->
    <script src="asset/js/modernizr-2.6.2.min.js"></script>
    <script src="Custom/sweetalert2.all.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/11.1.0/sweetalert2.css" />


</head>
<body>
<div id="fh5co-offcanvas">
    <a href="#" class="fh5co-close-offcanvas js-fh5co-close-offcanvas"><span><i class="icon-cross3"></i> <span>Close</span></span></a>
    <div class="fh5co-bio">
        <figure>
            <img src="https://pbs.twimg.com/profile_images/1353846387406991363/UqSX4NnH_400x400.jpg" alt="Free HTML5 Bootstrap Template" class="img-responsive">
        </figure>
        <h3 class="heading">Hakkımda</h3>
        <h2>${user.name} ${user.surname}</h2>
        <p>I am working as a Java developer at Renova.</p>
        <ul class="fh5co-social">
            <li><a href="#"><i class="icon-twitter"></i></a></li>
            <li><a href="#"><i class="icon-facebook"></i></a></li>
            <li><a href="#"><i class="icon-instagram"></i></a></li>
        </ul>
        <a type="button" href="logout" class="btn btn-primary">Sign out</a>
    </div>
</div>

<!-- END #fh5co-offcanvas -->
<header id="fh5co-header">

    <div class="container-fluid">

        <div class="row">
            <a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle"><i></i></a>
            <ul class="fh5co-social">
                <li><a href="#"><i class="icon-twitter"></i></a></li>
                <li><a href="#"><i class="icon-facebook"></i></a></li>
                <li><a href="#"><i class="icon-instagram"></i></a></li>
            </ul>
            <div class="col-lg-12 col-md-12 text-center">
                <h1 id="fh5co-logo"><a href="/">MY NOTE</a></h1>
            </div>

        </div>

    </div>

</header>
<!-- END #fh5co-header -->
<div class="container-fluid">
    <div class="row fh5co-post-entry single-entry d-flex justify-content-center">
        <article class="col-lg-8 col-lg-offset-2 col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2 col-xs-12 col-xs-offset-0">

            <h2 class="fh5co-article-title animate-box"><input type="text" id="note_title" placeholder="Title" autocomplete="off"></h2>
<%--            <span class="fh5co-meta fh5co-date animate-box">6 Martt 2021</span>--%>

            <div class="col-lg-12 col-lg-offset-0 col-md-12 col-md-offset-0 col-sm-12 col-sm-offset-0 col-xs-12 col-xs-offset-0 text-left content-article">
                <div class="row">
                    <div class="col-lg-8 cp-r animate-box">
                        <textarea class="form form-control" id="note_content" style="width: 100%; height: 400px"></textarea>

                    </div>
                    <div class="col-lg-4 animate-box">
                        <div class="fh5co-highlight right">
                           <button class="btn btn-success btn-block" type="submit" onclick="addNote()">Save</button>
                        </div>
                    </div>
                </div>

            </div>
        </article>
    </div>
</div>

<footer id="fh5co-footer">
    <p><small>&copy; 2021.</small></p>
</footer>

<!-- jQuery -->
<script src="asset/js/jquery.min.js"></script>
<!-- jQuery Easing -->
<script src="asset/js/jquery.easing.1.3.js"></script>
<!-- Bootstrap -->
<script src="asset/js/bootstrap.min.js"></script>
<!-- Waypoints -->
<script src="asset/js/jquery.waypoints.min.js"></script>
<!-- Main JS -->
<script src="asset/js/main.js"></script>

<script src="Custom/note.js"></script>

</body>
</html>

