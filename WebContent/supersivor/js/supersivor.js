$(document).ready(function () {
	$.ajax({
		type:"post",
		url:'supersivor/getAllBusiness.do',
		dataType:"json",
		success:function(data)
		{
			fillContainer(data);
		},
		failure:function(data)
		{
			alert("error");
		}
	});
	//填充企业表格
	function fillContainer(data)
	{
		/*
		 * 后台读取数据。动态渲染网页
		 */
		
		var qiyeNum = data.list.length;
		//var user="tom";
		var qiyeId=new Array(1,2,3,4);
		var url="http://localhost:8081/CropBacktracking/supersivor/productlist.html?businessId=";
		//填充用户名
		//$('#user').text(user);
		
		//渲染企业列表
		var container=$('#container');
		var output="";
		for(var i=0;i<qiyeNum;i++)
		{
			var logo = data.list[i].businessLogo;
			var name = data.list[i].businessName;
			var note = data.list[i].businessDesc;
			var businessId = data.list[i].businessId;
			if((i+1)%3==1)
			{
				output+="<div class='row'>";
				//<div class='col-md-4 box'><div class='box-content'><div class='box-wrapper'>";
			}
			output+="<div class='col-md-4 box'>"+
					"<div class='box-content'>"+
					"<div class='box-wrapper'><span class='name'>"+name+"</span>"+
					"<div class='row'>"+note+"</div>"+
					"</div>"+
					"</div>"+
					"<div class='box-overlay magictime' data-hover='puffOut' data-return='puffIn'>"+
					"<img src='"+logo+"' alt=''/>"+
					"</div>"+
					"<a id='link' class='link' onclick='myclick(\""+businessId+"\")'></a>"+
					"</div>";
			if((i+1)%3==0)
				output+="</div>";
		}
		container.append(output);
		//图片悬停动画js段
		$('.box').hover(
				function () {
					var overlay = $(this).find('.box-overlay');
					overlay.removeClass(overlay.data('return')).addClass(overlay.data('hover'));
				},
				function () {
					var overlay = $(this).find('.box-overlay');		
					overlay.removeClass(overlay.data('hover')).addClass(overlay.data('return'));
				}
			);
	}
});