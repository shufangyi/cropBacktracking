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
	<title>Insert title here</title>
	
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="business/css/leftframe1.css">
</head>
<body  style="background: rgb(249,249,249);">
<!--左侧导航栏-->


	<div>
	<span>
	<p>${workerInfo.workerId } </p>
	<p>${workerInfo.businessId } </p>
	<p>${workerInfo.workerName } </p>
	<p>${workerInfo.workerNum } </p>
	<p>${workerInfo.workerPwd } </p>
	</span>
	</div>
    <div class='sidebar-nav' >
        <div class='sidebar-nav-ft'>
            
            	<c:forEach items="${menus }" var="pmenu">
				<c:if test="${pmenu.menuPid==0 }">	
				<div class='sidebar-nav-block'>			
                <a href="#user-menu${pmenu.menuId }" class='nav-header' data-toggle="collapse">
                    <span class='glyphicon glyphicon-cog'></span>
                  	 ${pmenu.menuName }
                </a>
                	<ul id="user-menu${pmenu.menuId }" class='nav nav-list collapse'>
						<c:forEach items="${menus }" var="menu">
						<c:if test="${menu.menuPid==pmenu.menuId}">
						<li ><a href="#">${menu.menuName }</a></li>
						</c:if>
						</c:forEach>
					</ul>
			</div>
			</c:if>
			</c:forEach>
          </div>
       </div>
</body>
</html>


</html>









