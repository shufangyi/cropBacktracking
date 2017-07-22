$(document).ready(function () {
	var Request = new Object();
	Request = GetRequest(); 
	var businessId = Request['businessId'];
	//将businessId传回后台，获取该公司对应的所有溯源商品
	var businessName = getUrlParam("businessName");
	var businessDesc = getUrlParam("businessDesc");
	var user = getUrlParam("user");
	$('#user').text(user);
    $("#com-name").append(businessName);
    $("#com-con").append(businessDesc);
	$.ajax({
		type:"post",
		url:'./getAllProcucts.do',
		dataType:"json",
		data:{businessId:businessId},
		success:function(data)
		{
			//alert(data);
			fillPro(data);
		},
		failure:function(data)
		{
			alert("error");
		}
	});
	//产品列表
	function fillPro(data)
	{
		 
		var len = data.pros.length;
		if(len==0)
		{
			$("#com-con").append(businessDesc+"<br>"+"此公司暂无商品");
			return null;
		}
		var output = "";
        for (var i = 0; i < len; i++)
        {
        	var obj = data.pros[i];
        	var project_btCode = obj.project_btCode;
        	var productName = obj.productName;
        	var url="product.html?projectCode="+project_btCode+"&productName="+productName+"&projectDesc="+obj.projectDesc+"&user="+user;
        	
        	if (i % 3 === 0) {
                output += "<div class='row'><div class='col-md-4 left animated fadeInLeft'>";
            } else {
                output += "<div class='col-md-4 right animated fadeInRight'>";
            }

            output+="<a href='"+url+"'>"+
                    "<div class='product-card'>"+
                   // "<img src='"+"../"+obj.productPicture+"' alt='#'>"+
                   // "<img src='img/1.png' alt='#'>"+
                    "<div class='product-info'>"+
                    "<h2 class='productname'>"+obj.productName+"</h2>"+
                  //  "<p>"+obj.projectDesc+"</p>"+
                    "<p>hhhhhhhhhhhhhhhhhhhhhhhhhhhh</p>"+
                    "<span class='p-hot'>&nbsp;<span class='glyphicon glyphicon-eye-open'></span>&nbsp;222&nbsp;</span>&nbsp;"+
                    "<span class='p-time'>&nbsp;<span class='glyphicon glyphicon glyphicon-time'></span>&nbsp;2017-07-12&nbsp;</span>"+
                    "</div></div></a></div>";

            if (i % 3 === 2) {
                output += "</div>";
            }
        }
	    $('.pl-list').append(output);
	}
	//获取url参数
	
	function getUrlParam(key){
	    // 获取参数
	    var url = window.location.search;
	    // 正则筛选地址栏
	    var reg = new RegExp("(^|&)"+ key +"=([^&]*)(&|$)");
	    // 匹配目标参数
	    var result = url.substr(1).match(reg);
	    //返回参数值
	    return result ? decodeURIComponent(result[2]) : null;
	}
	
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
		//return theRequest ? decodeURIComponent(theRequest[2]) : null;
		return theRequest; 
	}
}
);