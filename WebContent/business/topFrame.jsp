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
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>TopFrame</title>
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">

    <link rel="stylesheet" href="business/css/topframe1.css">


</head>

<body>
    <!--é¡¶é¨å¯¼èªæ -->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <!--<button type='button' class='navbar-toggle collapsed' data-toggle='collapse' data-target='#bs-example-navbar-collapse-1' aria-expanded='false'>-->
                <!--<span class='sr-only'>Toggle navigation</span>-->
                <!--<span class='icon-bar'></span>-->
                <!--<span class='icon-bar'></span>-->
                <!--<span class='icon-bar'></span>-->
                <!--</button>-->
                <span class="navbar-brand"><img src="business/img/logo.png"/></span>&nbsp;
                <span class="navbar-brand-name">${businessInfo.businessName }</span>
                 <span class="navbar-brand-name" id="businessId" style="display:none">${businessInfo.businessId }</span>
            </div>

            <ul class="nav navbar-nav navbar-right">
                <li class="btn-group" role="group" aria-label="...">
                	<span class="navbar-brand-name" id="workerId" style="display:none">${workerInfo.workerId }</span>
                    <button type="button" id="login-name" class="btn btn-info">${workerInfo.workerNum }&nbsp;<span class="glyphicon glyphicon-user"></span></button>
                    <button type="button" id="logout" class="btn btn-danger">退出&nbsp;<span class="glyphicon glyphicon-log-out"></span> </button>
                </li>

            </ul>
        </div>
        <!-- /.container-fluid -->
    </nav>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.js"></script>
     <script>
        $(function () {
            var $changeInfo = $(window.parent.document).find('#changeInfo');
            var $mask = $(window.parent.document).find('#mask');

            $('#login-name').bind('click', function () {
                var clientWidth = $(window).width();
                var baifenbi = ((clientWidth - 400) / 2) / clientWidth * 100;
                $changeInfo.css('left', baifenbi + '%');
                $changeInfo.css('transition', 'left 0.8s');
                $mask.css('display', 'block');
            });

            $mask.bind('click', function () {
                $changeInfo.css('left', '-100%');
                $changeInfo.css('transition', 'left 1.2s');
                $mask.css('display', 'none');
            });
        });
    </script>
    
    
    <script>
    	//退出登录js代码
    	$(document).ready(function()
    			{
    				
    				$('#logout').click(function()
    						{
    							$.ajax({
    							type:"post",
    							url:'business/logout.do',
    							success:function(data)
    							{
    								//alert(data);
    								window.top.location="business/login.html";
    								
    							},
    							failure:function(data)
    							{
    								//alert("error");
    							}
    							});
    						});
    			});
    	
    	
    </script>
</body>

</html>