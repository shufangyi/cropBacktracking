$(document).ready(function(){	
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
	
	/*
	 * 与后台交互数据
	 */


	$('#submit').click(function(){
		//action="business/addSowRecordInfo.do" type="post"
		var sowSeg_btCode=$('#sowSeg_btCode').val();
		var PestsType=$('#PestsType').val();
		var SprayTime=$('#SprayTime').val();
		var MedicationName=$('#MedicationName').val();
		var MedicationRatio=$('#MedicationRatio').val();
		var MedicationDosage=$('#MedicationDosage').val();
		var result=$('#result').val();
		var grower=$('#grower').val();
		var comment= $('#Comment').summernote('code');
		if(sowSeg_btCode==""||PestsType==""||SprayTime==""||MedicationName==""||MedicationRatio==""||
				MedicationDosage==""||result==""||grower==""||comment==""){
			alert("表单信息不完整");
			
			
			
		}
		else
		{
			if($('#sowSeg_btCode').parent().find('.help-block').text()!="allow")
			{
				alert("无权提交");
				return;
			}
			else
			{
				$.ajax({
					type: "post",
					url: "business/addPestRecordInfo.do",
					data:{
						"sowsegBtcode":sowSeg_btCode,
						"pesttype":PestsType,
						"sprayTime":SprayTime,
						"medicationname":MedicationName,
						"medicationratio":MedicationRatio,
						"medicationdosage":MedicationDosage,
						"result":result,
						"grower":grower,
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
			
		}
		
		
	});
	
	
	
});