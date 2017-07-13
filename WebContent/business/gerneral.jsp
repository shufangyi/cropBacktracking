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
    <title>二维码</title>

    <link rel="stylesheet" href="business/css/frame.css">
</head>

<body>
    <iframe src="business/topFrame.jsp" class="topFrame" name="topFrame" height="50px" width="100%" frameborder="0"></iframe>
    <iframe id="sidebar" src="business/sidebar_gerneral.jsp" class="leftFrame1" name="leftFrame1" frameborder="0"></iframe>
    <iframe src="business/two-bar-text.html" scrolling="yes" class="myframe1"  frameborder="0"></iframe>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.js"></script>
    <script>
        $(function () {
            window.setInterval(function () {
                var clientWidth = $(window).width();
                var clientHeight = $(window).height();
                // alert(clientHeight+" | "+clientWidth);
                $('.myframe1').css('height', clientHeight - 50 + 'px');
                $('.myframe1').css('width', clientWidth - 200 + 'px');
            }, 50);
        });
    </script>
</body>
</html>