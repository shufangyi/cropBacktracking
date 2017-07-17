<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<base href="<%=basePath%>">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>监管部门企业信息</title>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="supersivor/css/supersivor.css">
    <link rel="stylesheet" type="text/css" href="supersivor/css/normalize.css" />
    <link rel="stylesheet" href="supersivor/css/magic.min.css" />
    <script src="supersivor/js/goTop.js"></script>
    <script type="text/javascript" src="supersivor/js/jquery.min.js" ></script>
    <script type="text/javascript" src="supersivor/js/supervisor_event.js" ></script>


</head>
<body>
    <!--导航栏-->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">监管平台</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#"><span class="glyphicon glyphicon-home"></span>首页<span class="sr-only">(current)</span></a></li>
                </ul>

                <ul class="nav navbar-nav navbar-right">
                    <li class="btn-group" role="group" aria-label="...">
                        <button type="button" class="btn btn-default" onclick="logout()">退出登录</button>
                    </li>
                    <li>
                        <a href="test.html"><span id="user">${ user.supersivorNum}
                        </span></a>
                    </li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>

<!--监管平台首页简介-->
    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
        <div class="container" >
            <p>监管平台</p>
        </div>
        <form class="navbar-form navbar-right">
            <div class="form-group">
                <input id="search_key" type="text" class="form-control" placeholder="search">
            </div>
            <button  id="search" type="submit" class="btn btn-default" onclick="getSearchKey()">
                <span class="glyphicon glyphicon-search"></span>
            </button>
        </form>
    </div>

    <!--侧边栏小按钮-->
    <div class="sorted">
        <button class="btn btn-default" id="goTop">
            <span class="glyphicon glyphicon-chevron-up"></span>
        </button>
    </div>



<!--公司列表-->
    <div id="container" class="container"> 
    </div>
    
    <script src="supersivor/js/supersivor.js"></script>


    <footer id="footer">
        <!-- 页脚 -->
        <div class="footer-content">
            <ul class="share-group">
                <li><a href="http://weibo.com/u/2661020885?refer_flag=1001030201_"><i class="fa fa-weibo"></i></a></li>
                <li><a href="#"><i class="fa fa-wechat"></i></a></li>
                <li><a href="#"><i class="fa fa-qq"></i></a></li>
                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                <li><a href="#"><i class="fa fa-facebook-square"></i></a></li>
            </ul>
            <div class="copy">
                &copy SuperTeam&nbsp;&nbsp; - &nbsp;&nbsp;2099&nbsp;&nbsp;苏ICP备17028767号
            </div>
        </div>
    </footer>
    <script src="supersivor/js/footer.js"></script>


</body>
</html>