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
    <title>deliverRecord</title>

    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <!--dateTables-->
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.15/datatables.min.css"/>
    <script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.15/datatables.min.js"></script>
    <!--å¯ææ¬ç¼è¾å¨-->
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



<form class="form-horizontal" >
    <fieldset>

        <!-- Form Name -->
        <legend>运输记录表单</legend>

		    <!-- Text input-->
        <div class="control-group" >
            <div class="controls" >
                <label class="control-label" for="OrderNum">订单号:</label>
                <input id="OrderNum" name="OrderNum" type="text" placeholder="" class="input-xlarge" required="required">
                <span class="help-block"></span>
            </div>
        </div>
        
        <!-- Text input-->
        <div class="control-group" >
            <div class="controls" >
                <label class="control-label" for="deliverTime">运输时间:</label>
                <input id="deliverTime" name="deliverTime" type="date" placeholder="" class="datepicker input-xlarge" required="required">
                <span class="help-block">时间格式：0000-00-00</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="control-group" >
            <div class="controls" >
                <label class="control-label" for="deliverAddress">运输起点:</label>
                <input id="deliverAddress" name="deliverAddress" type="text" placeholder="" class="input-xlarge" required="required">
                <span class="help-block"></span>
            </div>
        </div>

        <!-- Text input-->
        <div class="control-group" >
            <div class="controls" >
                <label class="control-label" for="LogisticsCompany">运输部门:</label>
                <input id="LogisticsCompany" name="LogisticsCompany" type="text" placeholder="" class="input-xlarge" required="required">
                <span class="help-block"></span>
            </div>
        </div>


    

        <!-- Text input-->
        <div class="control-group" >
            <div class="controls" >
                <label class="control-label" for="LogisticsNum">物流单号:</label>
                <input id="LogisticsNum" name="LogisticsNum" type="text" placeholder="" class="input-xlarge" required="required">
                <span class="help-block"></span>
            </div>
        </div>

        <!-- Text input-->
        <div class="control-group" >
            <div class="controls" >
                <label class="control-label" for="Distributor">物流负责人账号:</label>
                <input id="Distributor" name="Distributor" type="text" placeholder="" class="input-xlarge" required="required">
                <span class="help-block">登录账号</span>
            </div>
        </div>


        <!-- Text input-->
        <div class="control-group">
            <div class="controls">
                <label class="control-label" for="Logistics">运输人员:</label>
                <input id="Logistics" name="Logistics" type="text" placeholder="" class="input-xlarge" required="required">
                <span class="help-block"></span>
            </div>
        </div>

        <!-- Textarea -->
        <div class="control-group">
            <div class="controls">
                <label class="control-label" for="Comment">备注:</label>
                <div id="Comment"><p>Hello Summernote</p></div>
                <script>
                    $(document).ready(function() {
                        $('#Comment').summernote();
                    });
                </script>
            </div>
        </div>

        <div>
            <button type="button" id="submit" name="submit" class="btn btn-info">提交</button>
        </div>

    </fieldset>
</form>
<script src="business/Form/js/deliverRecord_input.js"></script>
</body>
</html>