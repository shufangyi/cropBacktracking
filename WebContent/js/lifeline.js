$(function () 
{
	//第一步，调用js获取id参数值
    var Request = new Object();
	Request = GetRequest(); 
	var id = Request['id'];
	//alert(id);
	
	//第二步 将第一步获取的id值，通过ajax传回后台，获取溯源数据；
	//contoller在supersivor目录
	var id={queryId:id};
	$.ajax({
		type:"post",
		url:'visitor/getWholeInfo.do',
		dataType:"json",
		data:id,
		success:function(data)
		{
			insertData(data);
		},
		failure:function(data)
		{
			alert("fail");
		}
	});
	//获取图片
	
	$.ajax({
		type: 'post',
		url: 'business/getImgs.do',
		data:id,
		success:function(data)
		{
			fillImgs(data);
		},
		error:function(status)
		{
			
		}	
	});
	
	
    
	//展示详情信息面板
    $(document).on('click','.content', function () {
        if ($(this).children('.detail').css('display') == 'none') {
            $(this).children('div.detail').fadeIn();
            // $(this).children('div.detail').slideDown(600);
            $('.txt>i').attr('class', 'fa fa-chevron-circle-up');
        } else if ($(this).children('.detail').css('display') == 'block') {
            // $(this).children('div.item-show').fadeOut();
            $(this).children('div.detail').slideUp(600);
            $('.txt>i').attr('class', 'fa fa-chevron-circle-down');
        }
    });
    
    
    function fillImgs(data)
    {
    	
    	//alert(data.imglist.length);
    	for(var i=0;i<data.imglist.length;i++)
    	{
    		switch (data.imglist[i].loc)
    		{
    			case "1":
    				$('#img1').attr("src",data.imglist[i].picUrl);
    				break;
    			case "2":
    				$('#img2').attr("src",data.imglist[i].picUrl);
    				break;
    			case "3":
    				$('#img3').attr("src",data.imglist[i].picUrl);
    				break;
    			case "4":
    				$('#img4').attr("src",data.imglist[i].picUrl);
    				break
    			case "5":
    				$('#img5').attr("src",data.imglist[i].picUrl);
    				break;;
    		}
    	}
    	
    };
    
    
    
    
	//动态添加页面元素与数据
    function insertData(data)
    {
    	var output = "";
    	//alert(data.Info.length);
    	var len = data.Info.length;
    	for(var i=0;i<len;i++)
    	{
    		var j=i+1;
    		output+="<div class=\"item\">"+
    					"<div class=\"line\">"+
    					"</div>"+
    					"<div class=\"circle\">"+
    		 				j+
    		 			"</div>"+
    		 			"<div class='content'>"+
    		 				"<div class=\"date\">"+
    		 					data.Info[i]["时间"]+
    		 				"</div>"+
    		 				"<div class=\"txt\">"+
    		 					data.Info[i]["环节"]+
    		 					"<i class=\"fa fa-chevron-circle-down\"></i>"+
    		 				"</div>"+
    		 				"<div class=\"hr\"></div>"+
    		 				"<div class=\"detail\">"+
    		 					"<ul>";
    										
    		for(var key in data.Info[i])
    		{
    			//<li class="detail-item"><span class="detail-time">2014.2.5</span>
    			output+="<li class=\"detail-item\"><span class=\"detail-time\">"+key+"</span>"+
    				"<span class=\"detail-text\">"+data.Info[i][key]+"</span></li>";    				
    		}
    		output+="</ul></div></div></div>";
    		//alert(output);
    	}
    	//alert(output);
    	$('#box').append(output);
    }
    //js正则解析获取url参数
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
    
    
});