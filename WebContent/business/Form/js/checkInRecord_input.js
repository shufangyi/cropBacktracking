$(document).ready(function(){	
	//projectBtcode需要到后台进行验证
	$('#pickSeg_btCode').blur(function(){
		var pickSeg_btCode = $(this).val();
		var workerId = $(window.parent.parent.frames["topFrame"].document).find('#workerId').text();
		/*先验证是不是9位数字*/
		//code
		$.ajax({
			type: "post",
			url: "business/checkPickSegBtCode.do",
			data: {"picksegBtcode":pickSeg_btCode,"workerId":workerId},
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
	$('#checkInTime').change(function()
			{
				var time = $(this).val();
				var code = time[5]+time[6]+time[8]+time[9];
				$('#checkInSeg_btCode').val($('#pickSeg_btCode').val()+code);
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