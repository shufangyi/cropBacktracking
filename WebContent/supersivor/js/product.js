$(document).ready(function(){

	var projectCode = getUrlParam("projectCode");
    var productName = getUrlParam("productName");
    var projectDesc = getUrlParam("projectDesc");
    var user = getUrlParam("user");
    $(".title-name").append(productName);
    $(".title-con").append(projectDesc);
    $("#user").text(user);  
    
    init();


	$('#search').click(function()
	{
		init();
	});
	
	function init()
	{
		/*将用户信息传回后台*/
		//alert(businessId);
    	 //---先销毁表格 ---
        $('table').bootstrapTable('destroy');  
        //---初始化表格,动态从服务器加载数据--- 
       // alert("hello");
		 $('table').bootstrapTable
		 ({
			//发送数据请求
	    	url: '../business/getPageCopackInfo.do',
			method: 'post',
			//data: {"business":businessId},
			contentType: "application/x-www-form-urlencoded",
			toolbar: '#toolbar',//自定义工具栏
			cache: false,
			height: 600,
			striped: true,
			//search: true,
			//showExport: true,
			//showColumns: true,
			exportTypes: ['csv','txt','xml'],
			clickToSelect: true,
			//【查询设置】
			/* queryParamsType的默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
                             设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber */
			queryParamsType:'', 
           	queryParams: function queryParams(params) {
           	 //alert(businessId);
             var param = {  
                 pageNumber: params.pageNumber,    
                 pageSize: params.pageSize,
                 projectCode: projectCode,
                 searchKey: $('#searchKey').val()
             }; 
             /*
             for(var key in searchArgs){
           	  param[key]=searchArgs[key]
             }  
             */
             return param;                   
           }, 
			//【其它设置】
           locale:'zh-CN',//中文支持
           pagination: true,//是否开启分页（*）
           pageNumber:1,//初始化加载第一页，默认第一页
           pageSize: 10,//每页的记录行数（*）
           pageList: [10,15,20],//可供选择的每页的行数（*）
           sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
           showRefresh:true,//刷新按钮
           //【设置列属性】
			columns:
			 [
			 //{field: 'check',checkbox: true},	
			 {field: 'copacktime',title: '包装时间'}, 	
			 {field: 'productBtcode',title: '产品名称'},
			 {field: 'copacklocation',title: '包装地点'},
			 {field: 'specifications',title: '类别'},
			 {field: 'storagecondition',title: '储存环境'},
			 {field: 'producelocation',title: '生产地点'},
			 
			 {field: 'action',title: '操作',
				 formatter:function(value,row,index){
					    var element = 
					    "<a target='_blank' href='http://localhost:8081/CropBacktracking/lifeline.html?id="+row.productBtcode+"'>详情</a> ";
					    return element;  
					} 
			 }
			 
			 /* ,	 
			 {field: 'action',title: '操作',
				 formatter:function(value,row,index){
					    var element = 
					    "<a target='_blank' href='http://localhost:8081/CropBacktracking/lifeline.html' class='view' data-id='"+row.id +"'>预览</a> "+ 
					    "<a class='edit' data-id='"+row.id +"'>编辑</a> ";
					    return element;  
					} 
			 } */
			 /*
			 {field: 'seedsource',title: '地点', align: 'center',
				formatter:function(value,row,index){
				    var element = 
				    "<a class='edit' data-id='"+row.id +"'>编辑</a> "+ 
				    "<a class='delet' data-id='"+row.id +"'>删除</a> ";
				    return element;  
				} 
			  }
			  */
			],
           
       });	 

	};
	
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
	
});