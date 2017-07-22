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
    <title>sowRecord</title>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <!-- boostrap table  -->
   	<script type="text/javascript" src="plugs/jquery-3.1.1.min.js"></script>
	<!-- bootstrap -->
	<link rel="stylesheet" href="plugs/bootstrap/css/bootstrap.min.css">
	<script type="text/javascript" src="plugs/bootstrap/js/bootstrap.min.js"></script>
	<!-- 分页插件 -->
	<link rel="stylesheet" href="plugs/bootstrap-table/bootstrap-table.min.css">
	<script type="text/javascript" src="plugs/bootstrap-table/bootstrap-table.min.js"></script>
	<script type="text/javascript" src="plugs/bootstrap-table/bootstrap-table-locale-all.min.js"></script>
	<!-- 行内编辑 -->
	<script type="text/javascript" src="plugs/editable/bootstrap-editable.js"></script>
	<script type="text/javascript" src="plugs/editable/bootstrap-table-editable.js"></script>

	
	
    <!--富文本编辑器-->
    <link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.4/summernote.css" rel="stylesheet">
    <script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.4/summernote.js"></script>

    <!--jquery-ui-->
    <link href="https://cdn.bootcss.com/jqueryui/1.12.1/jquery-ui.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jqueryui/1.12.1/jquery-ui.js"></script>
    <script>
        $(function() {
            $( ".datepicker" ).datepicker();
        });
    </script>

    <link rel="stylesheet" href="business/Form/css/Form.css">
</head>
<body>
<!--查询列表-->
<div class="container" style="margin-top:20px">
			<div class="row">
				<!-- 表格 -->
				 <div id="toolbar">
        			<input type="button" id="delete" value="删除">
        			<input type="button" id="search" value="搜索">
        			<input type="text" id="searchKey" placeholder="请输入搜索内容">	
				</div>
				
				<div class="col-xs-12">
					<table class="table table-striped table-bordered table-hover" ></table>
				</div>
			</div>
</div>
<script src="../js/buttonStyleCover.js"></script>
<script src="business/Form/js/sowRecords.js"></script>
</body>
</html>