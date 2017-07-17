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
    <title>产品列表</title>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

    <link rel="stylesheet" href="supersivor/css/productlist.css">
    <link rel="stylesheet" href="supersivor/css/supersivor.css">
    <script src="supersivor/js/goTop.js"></script>


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
                    <li><a href="supersivor.html"><span class="glyphicon glyphicon-home"></span>首页</a></li>
                    <li class="active"><a href="#"><span class="glyphicon glyphicon-th-large"></span>中粮<span class="sr-only">(current)</span></a></li>

                </ul>

                <form class="navbar-form navbar-right">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search">
                    </div>
                    <button type="submit" class="btn btn-default">
                        <span class="glyphicon glyphicon-search"></span>
                    </button>
                </form>

                <ul class="nav navbar-nav navbar-right">
                    <li class="btn-group" role="group" aria-label="...">
                        <button type="button" class="btn btn-default">退出登录</button>

                    </li>
                    <li>
                        <a href="#">${ user.supersivorNum}</a>
                    </li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>

<!--轮播-->
<div class="container">
    <div id="myCarousel" class="carousel slide">
        <!-- 轮播（Carousel）指标 -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        <!-- 轮播（Carousel）项目 -->
        <div class="carousel-inner">
            <div class="item active">
                <img src="supersivor/img/zl1.png" alt="First slide">
            </div>
            <div class="item">
                <img src="supersivor/img/zl2.png" alt="Second slide">
            </div>
            <div class="item">
                <img src="supersivor/img/zl3.png" alt="Third slide">
            </div>
        </div>
        <!-- 轮播（Carousel）导航 -->
        <a class="carousel-control left" href="#myCarousel"
           data-slide="prev">&lsaquo;
        </a>
        <a class="carousel-control right" href="#myCarousel"
           data-slide="next">&rsaquo;
        </a>
    </div>

<!--侧边栏小按钮-->
    <div class="sorted">
        <button class="btn btn-default" id="time">
            <span class="glyphicon glyphicon-time"></span>
        </button><br>
        <button class="btn btn-default" id="hot">
            <span class="glyphicon glyphicon-fire"></span>
        </button><br>
        <button class="btn btn-default" id="goTop">
            <span class="glyphicon glyphicon-chevron-up"></span>
        </button>
    </div>


<!--内容-->
    <div id="cool">
        <div class="row">
            <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6 text-center">
<!--企业信息-->
                <div id="bignavi">
                    <div class="panel panel-default biz">
                        <div class="panel-body">
                            <h3>企业信息</h3>
                            <span>立足中粮国际大粮仓</span>
                        </div>
                    </div>
                </div>
                <div class="panel-body text-center">
                    <p style="font-size:12px; line-height:170%; color:#8d8d8d;">
                        中粮集团有限公司（COFCO）是国际领先的全球大粮商之一，是中国独一无二的全球布局、全产业链、拥有最大市场和发展潜力的农业及粮油食品企业，在全球粮食主产地和需求增量最大的新兴市场间搭设稳定的粮食走廊。
                    </p>
                </div>
<!--人员表单-->
                <div class="panel panel-default qyry">
                    <div class="panel-body">
                        <div class="col-xs-3 col-sm-3 col-md-3 col-lg-2">
                            <div class="hellospace">
                                <span class="glyphicon glyphicon-user"></span>
                            </div>
                        </div>
                        <div class="col-xs-9 col-sm-9 col-md-9 col-lg-10">
                            <h4 class="list-group-item-heading">
                                <span class="ry-name">赵双连</span>
                                <span class="ry-zhiwei">董事长</span>
                            </h4>
                            <div style="font-size:12px; line-height:170%;">
                                <span class="color_gray_01">联系方式：11111111</span><br/>

                            </div>
                        </div>
                    </div>
                </div>

        
            </div>
<!--产品列表头部-->
            <div id="product_list" class="col-xs-12 col-sm-6 col-md-6 col-lg-6">

                <div id="bignavii" class="text-center">
                    <div class="panel panel-default mode">
                        <div class="panel-body">
                            <h3>产品列表</h3>
                            <span>产品、产品、产品</span>
                        </div>
                    </div>
                </div>
<!--产品列表-->
            </div>
        </div>
    </div>
</div>
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
<script src="supersivor/js/productlist.js"></script>

</body>
</html>