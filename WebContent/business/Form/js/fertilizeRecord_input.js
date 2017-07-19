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
	var sowsegBtcode=$('#sowSeg_btCode').text;
	var fertilizername=$('#fertilizerName').text;
	var fertilizetime=$('#FertilizeTime').text;
	var fertilizernum=$('#FertilizerNum').text;
	var fertilizerfrequency=$('#FertilizerFrequency').text;
	var grower=$('#grower').text;
	var comment=$('#Comment').val;

	$('#submit').click(function(){
		//action="business/addSowRecordInfo.do" type="post"
		alert("表单");
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