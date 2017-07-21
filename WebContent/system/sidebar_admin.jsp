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
    <link rel="stylesheet" href="system/css/left-bar.css">

</head>
<body>
    <div id="wrapper">
        <!--<div class="overlay"></div>-->
        <!-- Sidebar -->
        <nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper" role="navigation">
            <ul class="nav sidebar-nav">
                <li>
                </li>
                <li class="dropdown">
                    <a onclick="return false" href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-fw fa-plus"></i> 角色管理 <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <!--<li class="dropdown-header">Dropdown heading</li>-->
                        <li><a onclick="return false" class="useful" href="./Form/roles.html">系统角色</a></li>
                        <li><a onclick="return false" class="useful" href="./Form/addrole.html">新增角色</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a onclick="return false" href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-fw fa-plus"></i> 生产模板<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <!--<li class="dropdown-header">Dropdown heading</li>-->
                        <li><a onclick="return false" class="useful" href="./Form/plans.html">模板列表</a></li>
                        <li><a onclick="return false" class="useful" href="./Form/addplan.html">新增模板</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a onclick="return false" href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-fw fa-plus"></i> 企业管理 <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <!--<li class="dropdown-header">Dropdown heading</li>-->
                        <li><a onclick="return false" class="useful" href="./Form/businessinfo.html">企业信息列表</a></li>
                        <li><a onclick="return false" class="useful" href="./Form/managers.html">企业账户列表</a></li>
                        <li><a onclick="return false" class="useful" href="./Form/addmanager.html">注册企业账户</a></li>
                    </ul>
                </li>
                
                <li class="dropdown">
                    <a onclick="return false" href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-fw fa-plus"></i> 作物编码 <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <!--<li class="dropdown-header">Dropdown heading</li>-->
                        <li><a onclick="return false" class="useful" href="./Form/crops.html">编码列表</a></li>
                    </ul>
                </li>
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