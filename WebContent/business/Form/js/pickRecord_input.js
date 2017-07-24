$(document).ready(function()
{	
	//projectBtcode需要到后台进行验证
	$('#sowSeg_btCode').blur(function(){
		var sowSeg_btCode = $(this).val();
		var workerId = $(window.parent.parent.frames["topFrame"].document).find('#workerId').text();
		/*先验证是不是9位数字*/
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
	
	$('#PickTime').focus(function()
			{
				if($('#sowSeg_btCode').parent().find('.help-block').text()!="allow")
				{
					$('#PickTime').parent().find('.help-block').text("请确定溯源码输入正确");
					$('#PickTime').parent().find('.help-block').css("color","red");
				}
				else
				{
					$('#PickTime').parent().find('.help-block').text("输入日期格式如2017-08-09");
					$('#PickTime').parent().find('.help-block').css("color","green");
				}
			});
	
	$('#PickTime').change(function()
			{
				var time = $(this).val();
				var code = time[5]+time[6]+time[8]+time[9];
				var pickSeg_btCode = $('#sowSeg_btCode').val()+code
				$('#pickSeg_btCode').val($('#sowSeg_btCode').val()+code);
				
				if(pickSeg_btCode.length!=17)
				{
					$('#pickSeg_btCode').parent().find('.help-block').text("先正确输入溯源码，再选择时间");
					$('#pickSeg_btCode').parent().find('.help-block').css("color","red");
				}
				else
				{
					$('#pickSeg_btCode').parent().find('.help-block').text("correct");
					$('#pickSeg_btCode').parent().find('.help-block').css("color","green");
				}
			}		
	);
	/*
	 * 与后台交互数据
	 */
	

	$('#submit').click(function(){
		//action="business/addSowRecordInfo.do" type="post"
		var sowsegBtcode=$('#sowSeg_btCode').val();
		var picktime=$('#PickTime').val();
		var picktype=$('#PickType').val();
		var picknum=$('#PickNum').val();
		var grower=$('#grower').val();
		var pickSeg_btCode=$('#pickSeg_btCode').val();
		var comment= $('#comment').summernote('code');
		
		if(sowsegBtcode==""||picktime==""||picktype==""||picknum==""||grower==""||pickSeg_btCode==""||comment==""){
			
		}
		else
		{
			if($('#sowSeg_btCode').parent().find('.help-block').text()!="allow"||
					$('#pickSeg_btCode').parent().find('.help-block').text()!="correct")
			{
				alert("无权提交");
				return;
			}
			$.ajax({
				type: "post",
				url: "business/addPickRecordInfo.do",
				data:{
					"sowsegBtcode":sowsegBtcode,
					"picktime":picktime,
					"picktype":picktype,
					"picknum":picknum,
					"grower":grower,
					"picksegBtcode":pickSeg_btCode,
					"comment":comment
					
				},
				success:function(data,status)
				{
					alert("可能成功");
				},
				error:function(data,status)
				{
					alert("server error!");
				}
			});
		}
		
		
	});
	
	
	
});