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
	
	$('#submit').click(function(){
		//获得表单数据
		
		
		
		//action="business/addSowRecordInfo.do" type="post"
		alert("表单");
		$.ajax({
			type: "post",
			url: "business/addSowRecordInfo.do",
			data: 
			success:function(data,status)
			{
				alert("可能成功");
			},
			error:function(data,status)
			{
				alert("server error!")
			}
		});
		
	});
	
	
	
});