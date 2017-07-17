<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	用户账号<p id="Num">${ workerInfo.workerNum}</p>
	workerId<p id="workerId">${ workerInfo.workerId}</p>
	用户密码<p id="Pwd">${ workerInfo.workerPwd}</p>
	用户角色id<p id="RoleId">${ workerInfo.roleId}</p>
	用户公司id<p id="bId">${ workerInfo.businessId}</p>
	<p>角色拥有权限</p>
	<p id="Res"></p>
	<p>用户拥有权限</p>
	<p id="authority"></p>
	<p>用户参与项目</p>
	<p id="pcode"></p>
	 <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
	 <script type="text/javascript" src="business/js/gerneral.js"></script>
</body>
</html>