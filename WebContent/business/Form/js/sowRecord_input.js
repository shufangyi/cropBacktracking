$(document).ready(function(){	
	//projectBtcode需要到后台进行验证
	$('#projectBtcode').blur(function(){
		var projectBtcode = $(this).val();
		if(projectBtcode.length!=9)
		{
			$('#projectBtcode').parent().find('.help-block').text("请输入9位溯源码");
			$('#projectBtcode').parent().find('.help-block').css("color","red");
		}
		else
		{
			var workerId = $(window.parent.parent.frames["topFrame"].document).find('#workerId').text();
			//code
			$.ajax({
				type: "post",
				url: "business/checkProjectBtcode.do",
				data: {"projectBtcode":projectBtcode,"workerId":workerId},
				success:function(data,status)
				{
					if(data=="true")
					{
						$('#projectBtcode').parent().find('.help-block').text("allow");
						$('#projectBtcode').parent().find('.help-block').css("color","green");
					}
					else
					{
						$('#projectBtcode').parent().find('.help-block').text("forbidden");
						$('#projectBtcode').parent().find('.help-block').css("color","red");
						
					}
				},
				error:function(data,status)
				{
					alert("server error!")
				}
			});
		}
	});
	$('#sowtime').focus(function()
	{
		if($('#projectBtcode').parent().find('.help-block').text()!="allow")
		{
			$('#sowtime').parent().find('.help-block').text("请确定溯源码输入正确");
			$('#sowtime').parent().find('.help-block').css("color","red");
		}
		else
		{
			$('#sowtime').parent().find('.help-block').text("输入日期格式如2017-08-09");
			$('#sowtime').parent().find('.help-block').css("color","green");
		}
	});
	
	$('#sowtime').change(function()
	{
		var time = $(this).val();
		var code = time[5]+time[6]+time[8]+time[9];
		var sowSeg_btCode=$('#projectBtcode').val()+code
		$('#sowSeg_btCode').val($('#projectBtcode').val()+code);
		if(sowSeg_btCode.length!=13)
		{
			$('#sowSeg_btCode').parent().find('.help-block').text("先正确输入溯源码，再选择时间");
			$('#sowSeg_btCode').parent().find('.help-block').css("color","red");
		}
		else
		{
			$('#sowSeg_btCode').parent().find('.help-block').text("correct");
			$('#sowSeg_btCode').parent().find('.help-block').css("color","green");
		}
	});
	/*
	 * 与后台交互数据
	 */


	$('#submit').click(function(){
		//action="business/addSowRecordInfo.do" type="post"
		var project_btCode=$('#projectBtcode').val();
		//alert(project_btCode);
		var sowTime=$('#sowtime').val();
		var sowSeg_btCode=$('#sowSeg_btCode').val();
		var sowLocation=$('#SowLocation').val();
		//alert(sowLocation);
		var productName=$('#productName').val();
		var seedSource=$('#seedSource').val();
		var sowNum=$('#sowNum').val();
		var grower=$('#grower').val();
		var comment= $('#comment').summernote('code');
		if(project_btCode==""||sowTime==""||sowSeg_btCode==""||productName==""||seedSource==""||sowNum==""||
				grower==""||comment=="")
		{
			alert("表单信息不完整");
		}
		else
		{
			if($('#projectBtcode').parent().find('.help-block').text()!="allow"||
					$('#sowSeg_btCode').parent().find('.help-block').text()!="correct")
			{
				alert("无权提交");
				return;
			}
			$.ajax({
						url: "business/addSowRecordInfo.do",
						type: "post",	
						data:{
							"projectBtcode":project_btCode,
							"sowtime":sowTime,
							"sowsegBtcode":sowSeg_btCode,
							"sowlocation":sowLocation,
							"productname":productName,
							"seedsource":seedSource,
							"sownum":sowNum,
							"grower":grower,
							"comment":comment	
						},
						success:function(data,status)
						{
							alert("添加成功");
						},
						error:function(data,status)
						{
							alert("server error!");
						}
					});
		}
	});
	
	
	
});