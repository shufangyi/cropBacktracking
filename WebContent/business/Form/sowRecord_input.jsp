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
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <!-- boostrap table  -->
	<!-- bootstrap -->
	<link rel="stylesheet" href="plugs/bootstrap/css/bootstrap.min.css">
	<script type="text/javascript" src="plugs/bootstrap/js/bootstrap.min.js"></script>
	<!-- 分页插件 -->
	<link rel="stylesheet" href="plugs/bootstrap-table/bootstrap-table.min.css">
	<script type="text/javascript" src="plugs/bootstrap-table/bootstrap-table.min.js"></script>
	<script type="text/javascript" src="plugs/bootstrap-table/bootstrap-table-locale-all.min.js"></script>
    <!--富文本编辑器-->
    <link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.4/summernote.css" rel="stylesheet">
    <script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.4/summernote.js"></script>

    <!--jquery-ui-->
    <link href="https://cdn.bootcss.com/jqueryui/1.12.1/jquery-ui.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jqueryui/1.12.1/jquery-ui.js"></script>
    <script>
	    $(function() {
	        $( ".datepicker" ).datepicker({
	            dateFormat: 'yy-mm-dd'//日期格式
	        });
	    });
    </script>

    <link rel="stylesheet" href="business/Form/css/Form.css">
</head>
<body>
<script>
<!--查询列表-->
/*
<div class="container" style="margin-top:100px">
			<div class="row">
				<!-- 表格 -->
				 <div id="toolbar">
        			<button value="新增" id="add">新增</button>
        			<button value="删除" id="del">删除</button>
        			<button value="修改" id="upd">修改</button>
				</div>
				<div class="col-xs-12">
					<table class="table table-striped table-bordered table-hover" ></table>
				</div>
			</div>
</div>
<!-- Text input-->
<div class="control-group">
    <div class="controls">
        <label class="control-label" for="sowSeg_btCode">播种环节溯源码:</label>
        <input id="sowsegBtcode" name="sowsegBtcode" type="text" placeholder="" class="input-xlarge" required="" readonly="readonly">
    </div>
</div>
*/
</script>
<form class="form-horizontal" >
    <fieldset>
        <!-- Form Name -->
        <legend>播种记录表单</legend>
        <!-- Text input-->
        <div class="control-group" >
            <div class="controls" >
                <label class="control-label" for="projectBtcode">项目溯源码:</label>
                <input id="projectBtcode" name="projectBtcode" type="text" placeholder="" class="input-xlarge" required="">
                <span class="help-block">1</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="control-group" >
            <div class="controls" >
                <label class="control-label" for="sowTime">播种时间:</label>
                <input id="sowtime" name="sowtime" type="date" class="datepicker input-xlarge" required="">
                <span class="help-block">1</span>
            </div>
        </div>
        
            <!-- Text input-->
        <div class="control-group" >
            <div class="controls" >
                <label class="control-label" for="sowSeg_btCode">播种溯源码:</label>
                <input id="sowSeg_btCode" name="sowSeg_btCode" type="text" placeholder="" class="input-xlarge" required="required" disabled="disabled">
                <span class="help-block">1</span>
            </div>
        </div>
       
        
        <!-- Text input-->
        <div class="control-group">
            <div class="controls">
                <label class="control-label" for="SowLocation">播种地点:</label>
                <input id="SowLocation" name="sowlocation" type="text" placeholder="" class="input-xlarge" required="required">
                <span class="help-block">1</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="control-group">
            <div class="controls">
                <label class="control-label" for="productName">作物名称:</label>
                <input id="productName" name="productname" type="text" placeholder="" class="input-xlarge" required="required">
                <span class="help-block">1</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="control-group">
            <div class="controls">
                <label class="control-label" for="seedSource">种子来源:</label>
                <input id="seedSource" name="seedsource" type="text" placeholder="" class="input-xlarge" required="required">
                <span class="help-block">1</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="control-group">
            <div class="controls">
                <label class="control-label" for="sowNum">播种量（KG）:</label>
                <input id="sowNum" name="sownum" type="number" placeholder="" class="input-xlarge" required="required">
                <span class="help-block">1</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="control-group">
            <div class="controls">
                <label class="control-label" for="grower">种植员:</label>
                <input id="grower" name="grower" type="text" placeholder="" class="input-xlarge" required="required">
                <span class="help-block">1</span>
            </div>
        </div>

        <!-- Textarea -->
        <div class="control-group">
            <div class="controls">
                <label class="control-label" for="Comment">备注</label>
                <div id="comment" name="comment"><p>Hello Summernote</p></div>
                <script>
                    $(document).ready(function() {
                        $('#comment').summernote();
                    });
                </script>
            </div>
        </div>
        <div>
            <button type="button" id="submit" name="submit" class="btn btn-info">提交</button>
        </div>
    </fieldset>
</form>
<script src="business/Form/js/sowRecord_input.js"></script>
</body>
</html>