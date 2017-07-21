$(document).ready(function(){	
	//projectBtcode需要到后台进行验证
	$('#pickSeg_btCode').blur(function(){
		var pickSeg_btCode = $(this).val();
		/*先验证是不是9位数字*/
		//code
		$.ajax({
			type: "post",
			url: "business/checkPickSegBtCode.do",
			data: {"picksegBtcode":pickSeg_btCode},
			success:function(data,status)
			{
				if(data=="true")
				{
					$('#pickSeg_btCode').parent().find('.help-block').text("correct");
				}
				else
				{
					$('#pickSeg_btCode').parent().find('.help-block').text("无权限");
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
	var pickSeg_btCode=$('#pickSeg_btCode').text();
	var checkInTime=$('#checkInTime').text();
	var StockLocation=$('#StockLocation').text();
	var Checker=$('#Checker').text();
	var Comment= $('#Comment').summernote('code');

	$('#submit').click(function(){
		//action="business/addSowRecordInfo.do" type="post"
		alert("表单");
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
				alert("server error!")
			}
		});
		
	});
	
	
	
});