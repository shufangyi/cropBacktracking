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
	var sowSeg_btCode=$('#sowSeg_btCode').text;
	var PestsType=$('#PestsType').text;
	var SprayTime=$('#SprayTime').text;
	var MedicationName=$('#MedicationName').text;
	var MedicationRatio=$('#MedicationRatio').text;
	var MedicationDosage=$('#MedicationDosage').text;
	var result=$('#result').text;
	var grower=$('#grower').text;
	var comment=$('#Comment').val;

	$('#submit').click(function(){
		//action="business/addSowRecordInfo.do" type="post"
		alert("表单");
		$.ajax({
			type: "post",
			url: "business/addPestRecordInfo.do",
			data:{
				"sowsegBtcode":sowSeg_btCode,
				"peststype":PestsType,
				"spraytime":SprayTime,
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
				alert("server error!")
			}
		});
		
	});
	
	
	
});