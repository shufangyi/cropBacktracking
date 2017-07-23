<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>导航栏</title>

<link
	href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css"
	rel="stylesheet">
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.js"></script>

<link href="https://cdn.bootcss.com/animate.css/3.5.2/animate.min.css"
	rel="stylesheet">

<link rel="stylesheet" href="supersivor/css/supersivor.css">
<link rel="stylesheet" href="supersivor/css/footer.css">
<script src="supersivor/js/goTop.js"></script>


</head>

<body>
	<!--顶部导航栏-->
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"> <img alt="cropbacktracking"
					src="assets/logo.png" /> <span class="navbar-brand-name">cropbacktracking</span>
				</a>&nbsp;
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="index.html">首页<span
							class="sr-only">(current)</span></a></li>
				</ul>
				<div class="navbar-right">
					<form class="navbar-form" id="searchE" style="display:inline-block">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Search"
								id="searchCont">
						</div>
						<button class="btn btn-default" style="outline:none;" id="startBtn">
							<span class="glyphicon glyphicon-search"></span>
						</button>
					</form>

					<ul class="nav navbar-nav navbar-right"
						style="padding-right: 40px;">
						<li class="btn-group" role="group" aria-label="...">
							<button type="button" id="loginBtn" class="btn btn-info">
								<b id="user">${ user.supersivorNum}</b>&nbsp; <span
									class="glyphicon glyphicon-user"></span>
							</button> <!-- <button type="button" class="btn btn-danger">SignOut&nbsp;
                            <span class="glyphicon glyphicon-log-out"></span>
                        </button> -->
						</li>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
		</div>
		<!-- /.container-fluid -->
	</nav>

	<div class="title">
		<center>
			<h1>农产品溯源监管平台</h1>
			<p>督查农产品质量，保证人们放心吃到健康食品</p>
		</center>
		<iframe
			src="http://www.17sucai.com/preview/384839/2015-12-11/动态背景/index.html"
			height="300px" width="100%" scrolling="no" frameborder="no"
			style="position: absolute; top: 52px"></iframe>

	</div>


	<!--内容-->
	<div class="container">

		<div class="company" id="company">
			<!--js动态加载-->

		</div>

		<!--侧边栏小按钮-->
		<div class="sorted">
			<button class="btn btn-default" id="goTop">
				<span class="glyphicon glyphicon-chevron-up"></span>
			</button>
		</div>
	</div>

	<footer id="footer">
		<!-- 页脚 -->
		<div class="footer-content">
			<ul class="share-group">
				<li><a
					href="http://weibo.com/u/2661020885?refer_flag=1001030201_"><i
						class="fa fa-weibo"></i></a></li>
				<li><a href="#"><i class="fa fa-wechat"></i></a></li>
				<li><a href="#"><i class="fa fa-qq"></i></a></li>
				<li><a href="#"><i class="fa fa-twitter"></i></a></li>
				<li><a href="#"><i class="fa fa-facebook-square"></i></a></li>
			</ul>
			<div class="copy">&copy SuperTeam&nbsp;&nbsp; -
				&nbsp;&nbsp;2099&nbsp;&nbsp;苏ICP备17028767号</div>
		</div>
	</footer>
	<div id="changeInfo">
		<form class="form-horizontal">
			<fieldset>
				<!-- Form Name -->
				<legend>密码修改</legend>
				<!-- Password input-->
				<div class="control-group">
					<label class="control-label" for="passwordinput-0"><span
						class="need">*</span> 输入旧密码</label>
					<div class="controls inline">
						<input id="passwordinput-0" name="passwordinput-0" type="password"
							placeholder="旧密码" class="input-xlarge">
						<p class="help-block"></p>
					</div>
				</div>

				<!-- Password input-->
				<div class="control-group">
					<label class="control-label" for="passwordinput-2"><span
						class="need">*</span> 输入新密码</label>
					<div class="controls">
						<input id="passwordinput-2" name="passwordinput-2" type="password"
							placeholder="新密码" class="input-xlarge">
						<p class="help-block"></p>
					</div>
				</div>

				<!-- Password input-->
				<div class="control-group">
					<label class="control-label" for="passwordinput-1"><span
						class="need">*</span> 确认新密码</label>
					<div class="controls">
						<input id="passwordinput-1" name="passwordinput-1" type="password"
							placeholder="确认密码" class="input-xlarge">
						<p class="help-block"></p>
					</div>
				</div>

				<!-- Button (Double) -->
				<div class="control-group">
					<!--<label class="control-label" for="doublebutton-0">Double Button</label>-->
					<div class="controls btns">
						<button type="reset" id="doublebutton-0" name="doublebutton-0"
							class="btn  btn-success">重 置</button>
						<button type="submit" id="doublebutton2-0" name="doublebutton2-0"
							class="btn btn-danger">确 认</button>
					</div>
				</div>

			</fieldset>
		</form>

	</div>
	<div id="mask"></div>
	<script src="supersivor/js/footer.js"></script>
	<script>
    //页面功能js
        $(document).ready(function ()
        {

            window.setInterval(function () {
                var clientWidth = $(window).width();
                var clientHeight = $(document.body).height();
                $('#bg').css('height', clientHeight + 'px');
                $('#bg').css('width', clientWidth + 'px');
            }, 50);
            
            
            $("#doublebutton2-0").bind('click', function (event) {
            	 alert("hello");
            	event.preventDefault();
                var userName = $('#user').text();
                alert(userName);
                var oldP = $("#passwordinput-0").val();
                var newP1 = $("#passwordinput-1").val();
                var newP2 = $("#passwordinput-2").val();
               
                if (oldP.length == 0 || newP1.length == 0 || newP2.length == 0) {
                    alert("不能为空！");
                } else {
                    if (newP1 != newP2) {
                        alert("新密码不相同！")
                    } else {
                        $.ajax({
                            type: 'POST',
                            url: "supersivor/updateSupersivorPwd.do",
                            data: {
                                "supersivorNum": userName,
                                "supersivorOldPwd": oldP,
                                "supersivorNewPwd": newP1
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
            

            $('#loginBtn').bind('click', function () {
                var clientWidth = $(window).width();
                var baifenbi = ((clientWidth - 400) / 2) / clientWidth * 100;
                $('#changeInfo').css('left', baifenbi + '%');
                $('#changeInfo').css('transition', 'left 0.8s');
                $("#mask").css('display', 'block');
            });

            $("#mask").bind('click', function () {
                $('#changeInfo').css('left', '-100%');
                $('#changeInfo').css('transition', 'left 0.8s');
                $("#mask").css('display', 'none');
            });

            
            //数据加载         
            $.ajax({
        		type:"post",
        		url:'supersivor/getAllBusiness.do',
        		dataType:"json",
        		success:function(data)
        		{
        			fillContainer(data);
        		},
        		failure:function(data)
        		{
        			alert("error");
        		}
        	});
            
            //搜索功能
           /* $('#search').click(function(){
            	var searchKey = $('#searchKey').val();
            	if(searchKey == null || searchKey == "")
            	{
            		return null;
            	}
            });*/
            $("#startBtn").bind('click', function (event) {
                event.stopPropagation();
            	event.preventDefault();
                var sCont = $("#searchCont").val();
                if (sCont.length == 0) {
                    alert("请输入公司名称！");
                } else {
                	var search_flag = -1;
                	 $(".com-name").each(function (index) {
                         if ($(this).text().indexOf(sCont) > -1) {
                        	 if(search_flag == -1){
                        	 search_flag = index;
                        	 }
                        	$(this).parent().parent().css('box-shadow','0 1px 30px rgba(7, 76, 213, 0.87');
                         }
                     });
                	 if(search_flag == -1){
                 		 alert("没找到");
                	 }else{
                		 $('html, body').animate({  
                    	     scrollTop: $('.comlist:eq('+search_flag+')').offset().top-80
                   	  }, 800);
                	 }
                }
            });
            $('body').bind('click',function(){
        		$('.comlist').css('box-shadow','0 1px 30px rgba(255, 255, 255, 0');
        	})
            
        	//填充企业表格
        	function fillContainer(data)
        	{
        		/*
        		 * 后台读取数据。动态渲染网页
        		 */
        		
        		var qiyeNum = data.list.length;
        		//var user="tom";
        		var qiyeId=new Array(1,2,3,4);
        		var url="supersivor/productsList.html?businessId=";
        		//填充用户名
        		//$('#user').text(user);
        		
        		//渲染企业列表
        		var container=$('#container');
        		var output="";
        		for(var i=0;i<qiyeNum;i++)
        		{
        			
        			var logo = data.list[i].businessLogo;
        			var name = data.list[i].businessName;
        			var note = data.list[i].businessDesc;
        			var businessId = data.list[i].businessId;
        			var burl = data.list[i].businessUrl;
        			var phone = data.list[i].businessMobile;
        			var email = data.list[i].businessEmail;
        			var desc = data.list[i].businessDesc;
        			var user = $('#loginBtn').text();
       				var thisurl = url+businessId+"&"+"businessName="+name+"&businessDesc="+note+"&"+"user="+user;
                    if (i % 2 === 0) {
                    	  output += "<div class='row'><div class='col-md-6 left animated fadeInLeft'>";
                    } else {
                        output += "<div class='col-md-6 right animated fadeInRight'>";

                    }
                    output +=
                        "<a href='"+thisurl+"' class='cominfo'>" +
                        "<div class='comlist'>" +
                        "<h2 class='com-name'>"+name+"</h2>" +
                        "<div class='com-card'>" +
                        "<div class='com-content clear'>" +
                        "<div class='com-pic'>" +
                        "<img src='"+logo+"'/>" +
                        "</div>" +
                        "<p class='com-p'>"+desc+"</p>" +
                        "</div>" +
                        "<div class='com-icon clear'>" +
                        "<a href='"+burl+"' class='com-url' target='_blank'><span>&nbsp;企业官网&nbsp;</span></a>&nbsp;" +
                        "<span class='com-phone'>&nbsp;<span class='glyphicon glyphicon-earphone'></span>&nbsp;"+phone+"&nbsp;</span>&nbsp;" +
                        "<span class='com-email'>&nbsp;<span class='glyphicon glyphicon-envelope'></span>&nbsp;"+email+"&nbsp;</span>" +
                        "</div>" +
                        "</div>" +
                        "</div>" +
                        "</a>" +
                        "</div>";
                    if (i % 2 === 1) {
                        output += "</div>";
                       
                    }                 
                }  
                $("#company").append(output);
                //alert("hello");
            //公司数据加载
        	};
        });
            
       
    </script>
</body>

</html>