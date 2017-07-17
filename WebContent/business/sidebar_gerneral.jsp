<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>侧边栏菜单</title>
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="business/css/left-bar.css">

</head>
<body>

    <div id="wrapper">
        <!--<div class="overlay"></div>-->

        <!-- Sidebar -->
        <nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper" role="navigation">
            <ul class="nav sidebar-nav">
                <li>
                </li>
				<c:forEach items="${menus }" var="pmenu">
				<c:if test="${pmenu.menuPid==0 }">	
				<li class="dropdown">
				<a href="#user-menu${pmenu.menuId }" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-fw fa-plus"></i> ${pmenu.menuName } <span class="caret"></span></a>		
                <ul class="dropdown-menu" role="menu">
						<c:forEach items="${menus }" var="menu">
						<c:if test="${menu.menuPid==pmenu.menuId}">
						<li><a class="useful" href="./Form/${menu.menuUrl }">${menu.menuName }</a></li>
						</c:if>
						</c:forEach>
					</ul>
				</li>
				</c:if>
				</c:forEach>
        </nav>


        <!-- /#sidebar-wrapper -->

        <!-- Page Content -->
        <!--<div id="page-content-wrapper">
            <button type="button" class="hamburger is-closed animated fadeInLeft" data-toggle="offcanvas">
            <span class="hamb-top"></span>
            <span class="hamb-middle"></span>
            <span class="hamb-bottom"></span>
            </button>
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2">
                        <h1 class="page-header">Awesome Bootstrap 3 Sidebar Navigation</h1>
                    </div>
                </div>
            </div>
        </div>-->
        <!-- /#page-content-wrapper -->

    </div>
    <!-- /#wrapper -->

    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.js"></script>
    <script type="text/javascript">
        // $(document).ready(function () {
        //     var trigger = $('.hamburger'),
        //         overlay = $('.overlay'),
        //         isClosed = false;

        //     trigger.click(function () {
        //         hamburger_cross();
        //     });

        //     function hamburger_cross() {

        //         if (isClosed == true) {
        //             overlay.hide();
        //             trigger.removeClass('is-open');
        //             trigger.addClass('is-closed');
        //             isClosed = false;
        //         } else {
        //             overlay.show();
        //             trigger.removeClass('is-closed');
        //             trigger.addClass('is-open');
        //             isClosed = true;
        //         }
        //     }

        //     $('[data-toggle="offcanvas"]').click(function () {
        //         $('#wrapper').toggleClass('toggled');
        //     });
        // });
    </script>
</body>

</html>