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
	
	/*
	 * 与后台交互数据
	 */

	$('#submit').click(function(){
		//action="business/addSowRecordInfo.do" type="post"
		alert("表单");
		var sowsegBtcode=$('#sowSeg_btCode').val();
		var fertilizername=$('#fertilizerName').val();
		var fertilizetime=$('#FertilizeTime').val();
		var fertilizernum=$('#FertilizerNum').val();
		var fertilizerfrequency=$('#FertilizerFrequency').val();
		var grower=$('#grower').text();
		var comment= $('#Comment').summernote('code');
		$.ajax({
			type: "post",
			url: "business/addFertilizerRecordInfo.do",
			data:{
				"sowsegBtcode":sowsegBtcode,
				"fertilizername":fertilizername,
				"fertilizetime":fertilizetime,
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
				alert("server error!")
			}
		});
		
	});
	
	
	
});