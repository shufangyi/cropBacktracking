$(document).ready(function(){	
	//projectBtcode需要到后台进行验证
	$('#projectBtcode').blur(function(){
		var projectBtcode = $(this).val();
		/*先验证是不是9位数字*/
		//code
		$.ajax({
			type: "post",
			url: "business/checkProjectBtcode.do",
			data: {"projectBtcode":projectBtcode},
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
	
	/*
	 * 与后台交互数据
	 */
	var project_btCode=$('#projectBtcode').text();
	var sowTime=$('#projectBtcode').text();
	var sowSeg_btCode=$('#sowSeg_btCode').text();
	var sowLocation=$('#sowLocation').text();
	var productName=$('#productName').text();
	var seedSource=$('#seedSource').text();
	var sowNum=$('#sowNum').text();
	var grower=$('#grower').text();
	var comment=$('#comment').val();

	$('#submit').click(function(){
		//action="business/addSowRecordInfo.do" type="post"
		alert("表单");
		$.ajax({
			type: "post",
			url: "business/addSowRecordInfo.do",
			data:{
				"project_btCode":project_btCode,
				"sowTime":sowTime,
				"sowsegBtcode":sowSeg_btCode,
				"sowLocation":sowLocation,
				"productName":productName,
				"seedSource":seedSource,
				"sowNum":sowNum,
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