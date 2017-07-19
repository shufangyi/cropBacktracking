$(document).ready(function(){	
	//projectBtcode需要到后台进行验证
	$('#OrderNum').blur(function(){
		var OrderNum = $(this).val();
		/*先验证是不是9位数字*/
		//code
		$.ajax({
			type: "post",
			url: "business/checkConfirmRecipientOrderNum.do",
			data: {"ordernum":OrderNum},
			success:function(data,status)
			{
				if(data=="true")
				{
					$('#OrderNum').parent().find('.help-block').text("correct");
				}
				else
				{
					$('#OrderNum').parent().find('.help-block').text("无权限");
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
	var OrderNum=$('#OrderNum').text;
	var receipientTime=$('#receipientTime').text;
	var LogisticsNum=$('#LogisticsNum').text;
	var distributor=$('#distributor').text;
	var Comment=$('#Comment').val;

	$('#submit').click(function(){
		//action="business/addSowRecordInfo.do" type="post"
		alert("表单");
		$.ajax({
			type: "post",
			url: "business/addConfirmRecipientRecordInfo.do",
			data:{
				"ordernum":OrderNum,
				"receipienttime":receipientTime,
				"logisticsNum":LogisticsNum,
				"distributor":distributor,
				"comment":Comment	
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