$(document).ready(function () {
	
	
	var Request = new Object();
	Request = GetRequest(); 
	var businessId = Request['businessId'];
	//将businessId传回后台，获取该公司对应的所有溯源商品
	$.ajax({
		type:"post",
		url:'supersivor/getAllProcucts.do',
		dataType:"json",
		data:{businessId:businessId},
		success:function(data)
		{
			alert(data);
		},
		failure:function(data)
		{
			alert("error");
		}
	});
	
	//产品列表
	for(var i=0;i<100;i++)
	{
		var output="";
		output+="<div class=\"panel panel-default cp\">"+
				"<a href=\"#\">"+
				"<div class=\"panel-body\">"+
				"<div class=\"col-xs-3 col-sm-3 col-md-3 col-lg-2\">"+
				"<div class=\"hellospace\">"+
				"<img class=\"media-object img-rounded img-responsive\" src=\"supersivor/img/hongfeng.png\" alt=\"红枫\"/></div></div>" +
	    		"<div class=\"col-xs-9 col-sm-9 col-md-9 col-lg-10\"><h4 class=\"list-group-item-heading\">" +
	    		"<span class=\"cpnane\">红牛</span></h4>" +
	    		" <div style=\"font-size:14px; line-height:170%;color: #161616\">" +
	    		"<span class=\"color_gray_01\">产品编号：1111111111111111111111111</span><br/>" +
	    		"<span class=\"glyphicon glyphicon-star\"></span>点击量：220</div>" +
	    		"</div>" +
	    		"</div>" +
	    		"</a>" +
	    		"</div>";
	    $('#product_list').append(output);
	}
	//获取url参数
	
	function GetRequest() {
		var url = location.search; //获取url中"?"符后的字串
		var theRequest = new Object();
		if (url.indexOf("?") != -1)
		{
			var str = url.substr(1);
			strs = str.split("&");
			for(var i = 0; i < strs.length; i ++) {
				theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);
			}
		}
		return theRequest; 
	}
}
);