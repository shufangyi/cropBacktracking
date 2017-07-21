$(document).ready(function(){	
	//projectBtcode需要到后台进行验证
	$('#sowSeg_btCode').blur(function(){
		var sowSeg_btCode = $(this).val();
		/*先验证是不是9位数字*/
		//code
		$.ajax({
			type: "post",
			url: "business/checkSowSegBtCode.do",
			data: {"sowsegBtcode":sowSeg_btCode},
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
	
	/*
	 * 与后台交互数据
	 */
	var sowsegBtcode=$('#sowSeg_btCode').text();
	var picktime=$('#PickTime').text();
	var picktype=$('#PickType').text();
	var picknum=$('#PickNum').text();
	var grower=$('#grower').text();
	var pickSeg_btCode=$('#pickSeg_btCode').text();
	var comment= $('#Comment').summernote('code');
	

	$('#submit').click(function(){
		//action="business/addSowRecordInfo.do" type="post"
		alert("表单");
		$.ajax({
			type: "post",
			url: "business/addPickRecordInfo.do",
			data:{
				"sowsegBtcode":sowsegBtbode,
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