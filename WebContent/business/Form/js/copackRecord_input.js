$(document).ready(function(){	
	//projectBtcode需要到后台进行验证
	$('#checkInSeg_btCode').blur(function(){
		var checkInSeg_btCode = $(this).val();
		var workerId = $(window.parent.parent.frames["topFrame"].document).find('#workerId').text();
		/*先验证是不是21位数字*/
		if(checkInSeg_btCode.length!=21)
		{
			$('#checkInSeg_btCode').parent().find('.help-block').text("请输入21位溯源码");
			$('#checkInSeg_btCode').parent().find('.help-block').css("color","red");
		}
		else
		{
			//code
			$.ajax({
				type: "post",
				url: "business/checkCheckInSegBtCode.do",
				data: {"checkinsegBtcode":checkInSeg_btCode,"workerId":workerId},
				success:function(data,status)
				{
					if(data=="true")
					{
						$('#checkInSeg_btCode').parent().find('.help-block').text("allow");
						$('#checkInSeg_btCode').parent().find('.help-block').css("color","green");
					}
					else
					{
						$('#checkInSeg_btCode').parent().find('.help-block').text("forbidden");
						$('#checkInSeg_btCode').parent().find('.help-block').css("color","red");
					}
				},
				error:function(data,status)
				{
					alert("server error!")
				}
			});
		}
	});
	
	
	$('#copackTime').focus(function()
			{
				if($('#checkInSeg_btCode').parent().find('.help-block').text()!="allow")
				{
					$('#copackTime').parent().find('.help-block').text("请确定溯源码输入正确");
					$('#copackTime').parent().find('.help-block').css("color","red");
				}
				else
				{
					$('#copackTime').parent().find('.help-block').text("输入日期格式如2017-08-09");
					$('#copackTime').parent().find('.help-block').css("color","green");
				}
			});
	
	$('#copackTime').change(function()
			{
				var time = $(this).val();
				var code = time[5]+time[6]+time[8]+time[9];
				var product_btCode = $('#checkInSeg_btCode').val()+code; 
				$('#product_btCode').val($('#checkInSeg_btCode').val()+code);
				if(product_btCode.length!=25)
				{
					$('#product_btCode').parent().find('.help-block').text("先正确输入溯源码，再选择时间");
					$('#product_btCode').parent().find('.help-block').css("color","red");
				}
				else
				{
					$('#product_btCode').parent().find('.help-block').text("correct");
					$('#product_btCode').parent().find('.help-block').css("color","green");
				}
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
			if($('#checkInSeg_btCode').parent().find('.help-block').text()!="allow"||
					$('#product_btCode').parent().find('.help-block').text()!="correct")
			{
				alert("无权提交")
				return;
			}
			
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
					
					var qrcode = $('#codeShow').qrcode(product_btCode).hide();
					var canvas = qrcode.find('canvas').get(0);
					$('#codeShow-imgOne').attr('src',canvas.toDataURL('image/jpg'));
					imgsrc = canvas.toDataURL('image/jpg');
					$("#codeShow-box").css("display", "block");
					//生成结束	
				},
				error:function(data,status)
				{
					alert("server error!");
				}
			});
			
		}
		
	
	});
	
	
	
});