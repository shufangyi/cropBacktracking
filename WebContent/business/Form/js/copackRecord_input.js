$(document).ready(function(){	
	//projectBtcode需要到后台进行验证
	$('#checkInSeg_btCode').blur(function(){
		var checkInSeg_btCode = $(this).val();
		var workerId = $(window.parent.parent.frames["topFrame"].document).find('#workerId').text();
		/*先验证是不是9位数字*/
		//code
		$.ajax({
			type: "post",
			url: "business/checkCheckInSegBtCode.do",
			data: {"checkinsegBtcode":checkInSeg_btCode,"workerId":workerId},
			success:function(data,status)
			{
				if(data=="true")
				{
					$('#checkInSeg_btCode').parent().find('.help-block').text("correct");
				}
				else
				{
					$('#checkInSeg_btCode').parent().find('.help-block').text("无权限");
				}
			},
			error:function(data,status)
			{
				alert("server error!")
			}
		});
	});
	$('#copackTime').change(function()
			{
				var time = $(this).val();
				var code = time[5]+time[6]+time[8]+time[9];
				$('#product_btCode').val($('#checkInSeg_btCode').val()+code);
			}		
	);
	/*
	 * 与后台交互数据
	 */
	
	$('#submit').click(function(){
		//action="business/addSowRecordInfo.do" type="post"
		var checkInSeg_btCode=$('#checkInSeg_btCode').val();
		var copackTime=$('#copackTime').val();
		var OrderNum=$('#OrderNum').val();
		var copackLocation=$('#copackLocation').val();
		var product_btCode=$('#product_btCode').val();
		var copacker=$('#copacker').val();
		var produceDate=$('#produceDate').val();
		var ProduceLocation=$('#ProduceLocation').val();
		var Specifications=$('#Specifications').val();
		var NetContent=$('#NetContent').val();
		var StorageCondition=$('#StorageCondition').val();
		var comment= $('#Comment').summernote('code');
		
		
		if(checkInSeg_btCode==""||copackTime==""||OrderNum==""||copackLocation==""||product_btCode==""
	||copacker==""||produceDate==""||ProduceLocation==""||Specifications==""||NetContent==""||
	StorageCondition==""||comment=="")
		{
			alert("表单信息不完整");
		}
		else
		{
			$.ajax({
				type: "post",
				url: "business/addCopackRecordInfo.do",
				data:{
					"checkinsegBtcode":checkInSeg_btCode,
					"copacktime":copackTime,
					"ordernum":OrderNum,
					"copacklocation":copackLocation,
					"productBtcode":product_btCode,
					"copacker":copacker,
					"producedate":produceDate,
					"producelocation":ProduceLocation,
					"specifications":Specifications,
					"netcontent":NetContent,
					"storagecondition":StorageCondition,
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
		
	
	});
	
	
	
});