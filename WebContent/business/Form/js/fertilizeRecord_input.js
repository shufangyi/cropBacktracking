$(document).ready(function(){	
	//projectBtcode需要到后台进行验证
	$('#sowSeg_btCode').blur(function(){
		var sowSeg_btCode = $(this).val();
		var workerId = $(window.parent.parent.frames["topFrame"].document).find('#workerId').text();
		/*先验证是不是13位数字*/
		
		if(sowSeg_btCode.length!=13)
		{
			$('#sowSeg_btCode').parent().find('.help-block').text("请输入13位溯源码");
			$('#sowSeg_btCode').parent().find('.help-block').css("color","red");
		}
		else
		{
			
			
			//code
			$.ajax({
				type: "post",
				url: "business/checkSowSegBtCode.do",
				data: {"sowsegBtcode":sowSeg_btCode,"workerId":workerId},
				success:function(data,status)
				{
					if(data=="true")
					{
						$('#sowSeg_btCode').parent().find('.help-block').text("allow");
						$('#sowSeg_btCode').parent().find('.help-block').css("color","green");
					}
					else
					{
						$('#sowSeg_btCode').parent().find('.help-block').text("forbidden");
						$('#sowSeg_btCode').parent().find('.help-block').css("color","red");
					}
				},
				error:function(data,status)
				{
					alert("server error!")
				}
			});
		}
		
	});
	
	/*
	 * 与后台交互数据
	 */

	$('#submit').click(function(){
		//action="business/addSowRecordInfo.do" type="post"
		var sowsegBtcode=$('#sowSeg_btCode').val();
		var fertilizername=$('#fertilizerName').val();
		var fertilizetime=$('#FertilizeTime').val();
		var fertilizernum=$('#FertilizerNum').val();
		var fertilizerfrequency=$('#FertilizerFrequency').val();
		var grower=$('#grower').val();
		var comment= $('#Comment').summernote('code');
		if(sowsegBtcode==""||fertilizername==""||fertilizetime==""||fertilizernum==""||
				fertilizerfrequency==""||grower==""||comment==""){
			alert("表单信息不完整");
		}
		else
		{
			if($('#sowSeg_btCode').parent().find('.help-block').text()!="allow")
			{
				alert("无权提交");
				return;
			}
			else
			{
				$.ajax({
					type: "post",
					url: "business/addFertilizerRecordInfo.do",
					data:{
						"sowsegBtcode":sowsegBtcode,
						"fertilizername":fertilizername,
						"fertilizertime":fertilizetime,
						"fertilizernum":fertilizernum,
						"fertilizerfrequency":fertilizerfrequency,
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
			
			
		}
	});
	
});