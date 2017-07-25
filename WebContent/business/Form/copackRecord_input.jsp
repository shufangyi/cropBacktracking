<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>copackRecord</title>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<!--dateTables-->
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/v/dt/dt-1.10.15/datatables.min.css" />
<script type="text/javascript"
	src="https://cdn.datatables.net/v/dt/dt-1.10.15/datatables.min.js"></script>
<!--å¯ææ¬ç¼è¾å¨-->
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.4/summernote.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.4/summernote.js"></script>
<!--jquery-ui-->
<link href="https://cdn.bootcss.com/jqueryui/1.12.1/jquery-ui.css"
	rel="stylesheet">
<script src="https://cdn.bootcss.com/jqueryui/1.12.1/jquery-ui.js"></script>
<script
	src="https://cdn.bootcss.com/jquery.qrcode/1.0/jquery.qrcode.min.js"></script>
<script>
	$(function() {
		$(".datepicker").datepicker({
			dateFormat : 'yy-mm-dd'//日期格式
		});
	});
</script>

<link rel="stylesheet" href="business/Form/css/Form.css">
</head>
<body>
	<form class="form-horizontal">
		<fieldset>

			<!-- Form Name -->
			<legend>包装记录表单</legend>

			<!-- Text input-->
			<div class="control-group">
				<div class="controls">
					<label class="control-label" for="checkInSeg_btCode">质检溯源码:</label>
					<input id="checkInSeg_btCode" name="checkInSeg_btCode" type="text"
						placeholder="" class="input-xlarge" required="required"> <span
						class="help-block">输入21位溯源码</span>
				</div>
			</div>

			<!-- Text input-->
			<div class="control-group">
				<div class="controls">
					<label class="control-label" for="copackTime">包装时间:</label> <input
						id="copackTime" name="copackTime" type="date" placeholder=""
						class="datepicker input-xlarge" required="required"> <span
						class="help-block">时间格式：0000-00-00</span>
				</div>
			</div>

			<!-- Text input-->
			<div class="control-group">
				<div class="controls">
					<label class="control-label" for="OrderNum">订单号:</label> <input
						id="OrderNum" name="OrderNum" type="text" placeholder=""
						class="input-xlarge" required="required"> <span
						class="help-block"></span>
				</div>
			</div>

			<!-- Text input-->
			<div class="control-group">
				<div class="controls">
					<label class="control-label" for="copackLocation">包装地点:</label> <input
						id="copackLocation" name="copackLocation" type="text"
						placeholder="" class="input-xlarge" required="required"> <span
						class="help-block"></span>
				</div>
			</div>

			<!-- Text input-->
			<div class="control-group">
				<div class="controls">
					<label class="control-label" for="product_btCode">产品溯源码:</label> <input
						id="product_btCode" name="product_btCode" type="text"
						placeholder="" class="input-xlarge" required="required"
						readonly="readonly" disabled="disabled"> <span
						class="help-block"></span>
				</div>
			</div>

			<!-- Text input-->
			<div class="control-group">
				<div class="controls">
					<label class="control-label" for="copacker">包装员:</label> <input
						id="copacker" name="copacker" type="text" placeholder=""
						class="input-xlarge" required="required"> <span
						class="help-block"></span>
				</div>
			</div>

			<!-- Text input-->
			<div class="control-group">
				<div class="controls">
					<label class="control-label" for="produceDate">生产日期:</label> <input
						id="produceDate" name="produceDate" type="date" placeholder=""
						class="datepicker input-xlarge" required="required"> <span
						class="help-block">时间格式：0000-00-00</span>
				</div>
			</div>

			<!-- Text input-->
			<div class="control-group">
				<div class="controls">
					<label class="control-label" for="ProduceLocation">生产地:</label> <input
						id="ProduceLocation" name="ProduceLocation" type="text"
						placeholder="" class="input-xlarge" required="required"> <span
						class="help-block"></span>
				</div>
			</div>

			<!-- Text input-->
			<div class="control-group">
				<div class="controls">
					<label class="control-label" for="Specifications">规格:</label> <input
						id="Specifications" name="Specifications" type="text"
						placeholder="" class="input-xlarge" required="required"> <span
						class="help-block"></span>
				</div>
			</div>

			<!-- Text input-->
			<div class="control-group">
				<div class="controls">
					<label class="control-label" for="NetContent">净含量:</label> <input
						id="NetContent" name="NetContent" type="text" placeholder=""
						class="input-xlarge" required="required"> <span
						class="help-block"></span>
				</div>
			</div>

			<!-- Text input-->
			<div class="control-group">
				<div class="controls">
					<label class="control-label" for="StorageCondition">贮藏条件:</label> <input
						id="StorageCondition" name="StorageCondition" type="text"
						placeholder="" class="input-xlarge" required="required"> <span
						class="help-block"></span>
				</div>
			</div>

			<!-- 生成二维码 -->
			<div id="codeShow-box"
				style="display: none; position: absolute; top: 100px; right: 15%;background:rgba(255,255,255,0.6)">
				<div id="codeShow"></div>
				<img id='codeShow-imgOne' style="width:128px;"/>
			</div>

			<!-- Textarea -->
			<div class="control-group">
				<div class="controls">
					<label class="control-label" for="Comment">备注:</label>
					<div id="Comment">
						<p>Hello Summernote</p>
					</div>
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
	<script src="business/Form/js/copackRecord_input.js"></script>
</body>
</html>