 $(document).ready(function() 
{
	 var workerId = $(window.parent.parent.frames["topFrame"].document).find('#workerId').text();
	 var workerNum = $(window.parent.parent.frames["topFrame"].document).find('#workerNum').text();
	 init();
	 function init(){
    	 //---先销毁表格 ---
        $('table').bootstrapTable('destroy');  
        //---初始化表格,动态从服务器加载数据--- 
       // alert("hello");
		 $('table').bootstrapTable
		 ({
			//发送数据请求
	    	url: 'business/getConfirmRecipientRecords.do',
			method: 'post',
			contentType: "application/x-www-form-urlencoded",
			toolbar: '#toolbar',//自定义工具栏
			cache: false,
			height: 600,
			striped: true,
			search: true,
			showExport: true,
			showColumns: true,
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
                 pageSize: params.pageSize,
                 workerId:workerId,
                 searchKey:$('#searchKey').val(),
                 workerNum:workerNum
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
			columns: [
			 {field: 'check',checkbox: true},
			 {field: 'id',title: 'id'}, 	
			 {field: 'ordernum',title: '订单号'},	 
			 {field: 'recipienttime',title: '确认收货时间'}, 
			 {field: 'logisticsnum',title: '物流单号'},
			 {field: 'distributor',title: '分销商',editable: true},
			 {field: 'comment',title: '备注',editable: true}

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
			//行内编辑保存事件
			onEditableSave: function (field, row, oldValue, $el)
			{
					update(row);
			}	
           
           
       });
	 }
	  //查询数据
	  $('#delete').click(function(){
		 var rows = $('table').bootstrapTable('getSelections');
		 var rowsNum = rows.length;
		 if(rowsNum == 0)
		 {
			 alert("未选择数据")
		 }
		 else
		 {
			 //alert(rows[0].check);
			 //删除第一个check对象，后台不需要，必须处理
			 for(var i =0 ;i< rowsNum ;i++)
				delete rows[i]['check'];
			 $.ajax({
				  type: "post",
				  url: "business/delConfirmRecipientRecordInfo.do",
				  data:{data:JSON.stringify(rows)},
				  //data:	rows,
				  success: function (data, status) {
					  if (status == "success") {
	                        alert("删除成功");
	                        //成功之后页面数据删除
	                        //$('table').bootstrapTable('remove');
	               		
	                    }
	                },
	                error: function () {
	                    alert("删除失败");
	                }
	            });
		  }
	  });
	  //search数据
	  $('#search').click(function(){
		  init();
	  });
	  //删除数据
		 
	  //修改数据  
	  function update(row)
	  {
		  //向服务器提交数据
		  $.ajax({
			  type: "post",
			  url: "business/updateConfirmRecipientRecordInfo.do",
			  //data:{data:JSON.stringify(rows)},
			  data:	row,
			  success: function (data, status) {
				  if (status == "success") {
                        alert("修改成功");
                    }
                },
                error: function () {
                    alert("修改失败");
                }
            });      
		  //end
	  }
		 
		 
  	});
 
 
 