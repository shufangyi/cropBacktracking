$(document).ready(function(){	
	//projectBtcode需要到后台进行验证
	$('#projectBtcode').blur(function(){
		var projectBtcode = $(this).val();
		var workerId = $(window.parent.parent.frames["topFrame"].document).find('#workerId').text();
		/*先验证是不是9位数字*/
		//code
		$.ajax({
			type: "post",
			url: "business/checkProjectBtcode.do",
			data: {"projectBtcode":projectBtcode,"workerId":workerId},
			success:function(data,status)
			{
				if(data=="true")
				{
					$('#projectBtcode').parent().find('.help-block').text("correct");
				}
				else
				{
					$('#projectBtcode').parent().find('.help-block').text("无权限");
				}
			},
			error:function(data,status)
			{
				alert("server error!")
			}
		});
	});
	$('#sowtime').change(function()
	{
		var time = $(this).val();
		var code = time[5]+time[6]+time[8]+time[9];
		$('#sowSeg_btCode').val($('#projectBtcode').val()+code);
	}		
	);
	/*
	 * 与后台交互数据
	 */


	$('#submit').click(function(){
		//action="business/addSowRecordInfo.do" type="post"
		var project_btCode=$('#projectBtcode').val();
		alert(project_btCode);
		var sowTime=$('#sowtime').val();
		var sowSeg_btCode=$('#sowSeg_btCode').val();
		var sowLocation=$('#SowLocation').val();
		alert(sowLocation);
		var productName=$('#productName').val();
		var seedSource=$('#seedSource').val();
		var sowNum=$('#sowNum').val();
		var grower=$('#grower').val();
		var comment= $('#comment').summernote('code');
		alert(grower);
		$.ajax(
		{
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
				alert("server error!")
			}
		});
		
	});
	
	
	
});