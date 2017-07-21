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
    <title>企业员工</title>
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="business/css/frame.css">
</head>

<body>
    <iframe src="business/topFrame.jsp" class="topFrame" name="topFrame" height="50px" width="100%" frameborder="0"></iframe>
    <iframe id="sidebar" src="business/sidebar_gerneral.jsp" class="leftFrame1" name="leftFrame1" frameborder="0"></iframe>
    <iframe src="business/two-bar-text.html" scrolling="yes" class="myframe1"  frameborder="0"></iframe>
   	<!-- 顶部个人信息修改 -->
    <div id="changeInfo">
        <form class="form-horizontal">
            <fieldset>
                <!-- Form Name -->
                <legend>密码修改</legend>
                <!-- Password input-->
                <div class="control-group">
                    <label class="control-label" for="passwordinput-0"><span class="need">*</span> 输入旧密码</label>
                    <div class="controls inline">
                        <input id="passwordinput-0" name="passwordinput-0" type="password" placeholder="旧密码" class="input-xlarge">
                        <p class="help-block"></p>
                    </div>
                </div>

                <!-- Password input-->
                <div class="control-group">
                    <label class="control-label" for="passwordinput-2"><span class="need">*</span> 输入新密码</label>
                    <div class="controls">
                        <input id="passwordinput-2" name="passwordinput-2" type="password" placeholder="新密码" class="input-xlarge">
                        <p class="help-block"></p>
                    </div>
                </div>

                <!-- Password input-->
                <div class="control-group">
                    <label class="control-label" for="passwordinput-1"><span class="need">*</span> 确认新密码</label>
                    <div class="controls">
                        <input id="passwordinput-1" name="passwordinput-1" type="password" placeholder="确认密码" class="input-xlarge">
                        <p class="help-block"></p>
                    </div>
                </div>

                <!-- Button (Double) -->
                <div class="control-group">
                    <!--<label class="control-label" for="doublebutton-0">Double Button</label>-->
                    <div class="controls btns">
                        <button type="reset" id="doublebutton-0" name="doublebutton-0" class="btn  btn-success"> 重 置 </button>
                        <button type="submit" id="doublebutton2-0" name="doublebutton2-0" class="btn btn-danger"> 确 认 </button>
                    </div>
                </div>

            </fieldset>
        </form>

    </div>
    <div id="mask"></div>
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
            
            
            $("#doublebutton2-0").bind('click', function (event) {
                event.preventDefault();
                var userName = $(window.frames["topFrame"].document).find('button#login-name').text().trim();
                var oldP = $("#passwordinput-0").val();
                var newP1 = $("#passwordinput-1").val();
                var newP2 = $("#passwordinput-2").val();
                alert(userName);
                if (oldP.length == 0 || newP1.length == 0 || newP2.length == 0) {
                    alert("不能为空！");
                } else {
                    if (newP1 != newP2) {
                        alert("新密码不相同！")
                    } else {
                        $.ajax({
                            type: 'POST',
                            url: "business/updateWorkerPwd.do",
                            data: {
                                "workerNum": userName,
                                "workerOldPwd": oldP,
                                "workerNewPwd": newP1
                            },
                            success: function (data) {
                                if (data == "2") {
                                    alert("密码修改成功！");
                                } else if (data == "0") {
                                    alert("旧密码错误！");
                                } else if (data == "1") {
                                    alert("密码修改失败，稍后重试！");
                                }
                            },
                            error: function (status) {
                                alert("发生未知错误！稍后重试！");
                            }
                        });
                    }
                }
            });
            $("#changeInfo").keydown(function () {
                if (event.keyCode == "13") { //keyCode=13是回车键
                    $('#doublebutton2-0').trigger('click');
                }
            });
            
            
        });
    </script>
</body>
</html>