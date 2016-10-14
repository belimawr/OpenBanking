<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Open Banking</title>
        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">        
        <link rel="stylesheet" href="${pageContext.request.contextPath}/index_static/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/index_static/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/index_static/css/animate.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/index_static/css/form-elements.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/index_static/css/style.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/index_static/css/media-queries.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>

    <body>
    
        <!-- Loader -->
    	<div class="loader">
    		<div class="loader-img"></div>
    	</div>

		<!-- Top menu -->
		<nav class="navbar navbar-inverse navbar-fixed-top navbar-no-bg" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#top-navbar-1">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="index.html">Jedy - Bootstrap Landing Page</a>
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="top-navbar-1">
				</div>
			</div>
		</nav>

        <!-- Top content -->
        <div class="top-content">
        	
            <div class="inner-bg">
                <div class="container">
                	
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <h1 class="wow fadeInLeftBig">Original <strong>Open Banking</strong></h1>
                            <div class="description wow fadeInLeftBig">
                            	<p>
	                            	Kickstart para realização de transferência entre contas. Primeiro passo,
	                            	faça a conexão com o Original Connect.
                            	</p>
                            </div>
                            <div class="top-big-link wow fadeInUp">
								<input type="submit" class="btn btn-link-1" form="connect" value="Original Connect">
                            	<input type="button" class="btn btn-link-2" value="Download it">
                            	<form action="${pageContext.request.contextPath}/OAuthController" id="connect" method="post">
								</form>
                            </div>
                        </div>
                    </div>
                    
                </div>
            </div>
        </div>

        <!-- Javascript -->
        <script src="${pageContext.request.contextPath}/index_static/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/index_static/bootstrap/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/index_static/js/jquery.backstretch.min.js"></script>
        <script src="${pageContext.request.contextPath}/index_static/js/wow.min.js"></script>
        <script src="${pageContext.request.contextPath}/index_static/js/retina-1.1.0.min.js"></script>
        <script src="${pageContext.request.contextPath}/index_static/js/waypoints.min.js"></script>
        <script src="${pageContext.request.contextPath}/index_static/js/scripts.js"></script>

        <!--[if lt IE 10]>
            <script src="${pageContext.request.contextPath}/index_static/js/placeholder.js"></script>
        <![endif]-->

    </body>

</html>