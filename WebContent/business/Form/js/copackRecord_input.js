$(document).ready(function(){	
	//projectBtcode需要到后台进行验证
	$('#checkInSeg_btCode').blur(function(){
		var checkInSeg_btCode = $(this).val();
		/*先验证是不是9位数字*/
		//code
		$.ajax({
			type: "post",
			url: "business/checkCheckInSegBtCode.do",
			data: {"checkinsegBtcode":checkInSeg_btCode},
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
	
	/*
	 * 与后台交互数据
	 */
	var checkInSeg_btCode=$('#checkInSeg_btCode').text();
	var copackTime=$('#copackTime').text();
	var OrderNum=$('#OrderNum').text();
	var copackLocation=$('#copackLocation').text();
	var product_btCode=$('#product_btCode').text();
	var copacker=$('#copacker').text();
	var produceDate=$('#produceDate').text();
	var ProduceLocation=$('#ProduceLocation').test();
	var Specifications=$('#Specifications').test();
	var NetContent=$('#NetContent').test();
	var StorageCondition=$('#StorageCondition').test();
	var comment= $('#Comment').summernote('code');
	$('#submit').click(function(){
		//action="business/addSowRecordInfo.do" type="post"
		alert("表单");
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
				alert("server error!")
			}
		});
		
	});
	
	
	
});