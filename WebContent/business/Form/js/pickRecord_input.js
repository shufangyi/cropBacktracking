$(document).ready(function(){	
	//projectBtcode需要到后台进行验证
	$('#sowSeg_btCode').blur(function(){
		var sowSeg_btCode = $(this).val();
		var workerId = $(window.parent.parent.frames["topFrame"].document).find('#workerId').text();
		/*先验证是不是9位数字*/
		//code
		$.ajax({
			type: "post",
			url: "business/checkSowSegBtCode.do",
			data: {"sowsegBtcode":sowSeg_btCode,"workerId":workerId},
			success:function(data,status)
			{
				if(data=="true")
				{
					$('#sowSeg_btCode').parent().find('.help-block').text("correct");
				}
				else
				{
					$('#sowSeg_btCode').parent().find('.help-block').text("无权限");
				}
			},
			error:function(data,status)
			{
				alert("server error!")
			}
		});
	});
	$('#PickTime').change(function()
			{
				var time = $(this).val();
				var code = time[5]+time[6]+time[8]+time[9];
				$('#pickSeg_btCode').val($('#sowSeg_btCode').val()+code);
			}		
	);
	/*
	 * 与后台交互数据
	 */
	

	$('#submit').click(function(){
		//action="business/addSowRecordInfo.do" type="post"
		alert("表单");
		var sowsegBtcode=$('#sowSeg_btCode').val();
		var picktime=$('#PickTime').val();
		var picktype=$('#PickType').val();
		var picknum=$('#PickNum').val();
		var grower=$('#grower').val();
		var pickSeg_btCode=$('#pickSeg_btCode').val();
		var comment= $('#comment').summernote('code');
		
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
				alert("server error!")
			}
		});
		
	});
	
	
	
});