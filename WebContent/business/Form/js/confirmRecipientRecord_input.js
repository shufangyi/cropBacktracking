$(document).ready(function(){	
	//projectBtcode需要到后台进行验证
	$('#OrderNum').blur(function(){
		var OrderNum = $(this).val();
		var workerId = $(window.parent.parent.frames["topFrame"].document).find('#workerId').text();
		/*先验证是不是9位数字*/
		//code
		$.ajax({
			type: "post",
			url: "business/checkConfirmRecipientOrderNum.do",
			data: {"ordernum":OrderNum,"workerId":workerId},
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
	

	$('#submit').click(function(){
		//action="business/addSowRecordInfo.do" type="post"
		var OrderNum=$('#OrderNum').val();
		var receipientTime=$('#receipientTime').val();
		var LogisticsNum=$('#LogisticsNum').val();
		var distributor=$('#distributor').val();
		var Comment= $('#Comment').summernote('code');
		if(OrderNum==""||receipientTime==""||LogisticsNum==""||distributor==""||Comment=="")
		{
			alert("表单数据不完整");
		}
		else
		{
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
					alert("server error!");
				}
			});
		}
	});	
	
});