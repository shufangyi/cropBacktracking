 $(document).ready(function() {
    	 //---先销毁表格 ---
        $('table').bootstrapTable('destroy');  
        //---初始化表格,动态从服务器加载数据--- 
       // alert("hello");
		 $('table').bootstrapTable
		 ({
			//发送数据请求
	    	url: 'business/getSowRecords.do',
			method: 'post',
			contentType: "application/x-www-form-urlencoded",
			toolbar:'#toolbar',//
			cache: false,
			height: 400,
			striped: true,
			search: true,
			showColumns: true,
			showRefresh: true,
			showExport: true,
			exportTypes: ['csv','txt','xml'],
			search: true,
			clickToSelect: true,
			//【查询设置】
			/* queryParamsType的默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
                             设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber */
           queryParamsType:'', 
           queryParams: function queryParams(params) {
             var param = {  
                 pageNumber: params.pageNumber,    
                 pageSize: params.pageSize
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
           //【样式设置】
         
           //按需求设置不同的样式：5个取值代表5中颜色['active', 'success', 'info', 'warning', 'danger'];
           /*
			rowStyle: function (row, index) {
			    var style = "";
			    if (row.name=="小红") {style='success';}
			    	return { classes: style }
			},
			*/
           //【设置列属性】
			columns: [
			 {field: 'id',title: 'id'}, 
			 {field: 'comment',title: '备注'},
			 {field: 'projectname',title: '项目溯源码'},
			 {field: 'seedsource',title: '地点', align: 'center',
				formatter:function(value,row,index){
				    var element = 
				    "<a class='edit' data-id='"+row.id +"'>编辑</a> "+ 
				    "<a class='delet' data-id='"+row.id +"'>删除</a> ";
				    return element;  
				} 
			  }
			]
       });
  	});