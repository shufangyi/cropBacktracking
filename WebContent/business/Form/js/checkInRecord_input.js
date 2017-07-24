$(document).ready(function(){	
	//projectBtcode需要到后台进行验证
	$('#pickSeg_btCode').blur(function(){
		var pickSeg_btCode = $(this).val();
		var workerId = $(window.parent.parent.frames["topFrame"].document).find('#workerId').text();
		/*先验证是不是17位数字*/
		if(pickSeg_btCode.length!=17)
		{
			$('#pickSeg_btCode').parent().find('.help-block').text("请输入17位溯源码");
			$('#pickSeg_btCode').parent().find('.help-block').css("color","red");
		}
		else
		{
			//code
			$.ajax({
				type: "post",
				url: "business/checkPickSegBtCode.do",
				data: {"picksegBtcode":pickSeg_btCode,"workerId":workerId},
				success:function(data,status)
				{
					if(data=="true")
					{
						$('#pickSeg_btCode').parent().find('.help-block').text("allow");
						$('#pickSeg_btCode').parent().find('.help-block').css("color","green");
					}
					else
					{
						$('#pickSeg_btCode').parent().find('.help-block').text("forbidden");
						$('#pickSeg_btCode').parent().find('.help-block').css("color","red");
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
				if($('#pickSeg_btCode').parent().find('.help-block').text()!="allow")
				{
					$('#pickSeg_btCode').parent().find('.help-block').text("请确定溯源码输入正确");
					$('#pickSeg_btCode').parent().find('.help-block').css("color","red");
				}
				else
				{
					$('#pickSeg_btCode').parent().find('.help-block').text("输入日期格式如2017-08-09");
					$('#pickSeg_btCode').parent().find('.help-block').css("color","green");
				}
			});
	
	$('#checkInTime').change(function()
			{
				var time = $(this).val();
				var code = time[5]+time[6]+time[8]+time[9];
				var checkInSeg_btCode = $('#pickSeg_btCode').val()+code;
				$('#checkInSeg_btCode').val($('#pickSeg_btCode').val()+code);
				if(checkInSeg_btCode.length!=21)
				{
					$('#checkInSeg_btCode').parent().find('.help-block').text("先正确输入溯源码，再选择时间");
					$('#checkInSeg_btCode').parent().find('.help-block').css("color","red");
				}
				else
				{
					$('#checkInSeg_btCode').parent().find('.help-block').text("correct");
					$('#checkInSeg_btCode').parent().find('.help-block').css("color","green");
				}
			}		
	);
	/*
	 * 与后台交互数据
	 */
	$('#submit').click(function(){
		//action="business/addSowRecordInfo.do" type="post"
		var checkInSeg_btCode=$('#checkInSeg_btCode').val();
		var pickSeg_btCode=$('#pickSeg_btCode').val();
		var checkInTime=$('#checkInTime').val();
		var StockLocation=$('#StockLocation').val();
		var Checker=$('#Checker').val();
		var Comment= $('#Comment').summernote('code');
		
		if(checkInSeg_btCode==""||pickSeg_btCode==""||checkInTime==""||StockLocation==""||Checker==""||Comment=="")
		{
			alert("表单数据不完整");
		}
		else
		{
			if($('#pickSeg_btCode').parent().find('.help-block').text()!="allow"||
					$('#checkInSeg_btCode').parent().find('.help-block').text()!="correct")
			{
				alert("无权提交")
				return;
			}
			$.ajax({
				type: "post",
				url: "business/addCheckInRecordInfo.do",
				data:{
					"checkinsegBtcode":checkInSeg_btCode,
					"picksegBtcode":pickSeg_btCode,
					"checkintime":checkInTime,
					"stocklocation":StockLocation,
					"checker":Checker,
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