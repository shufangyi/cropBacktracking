<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>">
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="test/bootstrap/css/bootstrap/bootstrap.css" />
	<link rel="stylesheet" href="test/bootstrap-table/bootstrap-table.css" />	
	<script src="test/jquery/jquery.min.js"></script>
	<script src="test/bootstrap/js/bootstrap.js"></script>	
	<script src="test/bootstrap-table/bootstrap-table.js"></script>
	<script src="test/bootstrap/locale/bootstrap-table-zh-CN.min.js"></script>
	<script src="test/bootstrap-table/bootstrap-table-export.js"></script>
	<script src="test/extends/tableExport/jquery.base64.js"></script>
	<script src="test/extends/tableExport/tableExport.js"></script>
	
</head>

<body>
	<div id="content">
		<div id="content-body">
			<div id="reportTableDiv" class="span10">
				 <div id="toolbar">
        			<button value="新增" id="add">新增</button>
        			<button value="删除" id="del">删除</button>
        			<button value="修改" id="upd">修改</button>
				</div>
				<table id="reportTable">
				</table>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function () 
		{
			var oTable = new TableInit();
		    oTable.Init();
		});
		    
		    var TableInit = function () 
		    {
		        var oTableInit = new Object();
		        oTableInit.Init = function () 
		        {
		        	$('#reportTable').bootstrapTable({
						method: 'post',
						url: "business/getPickRecords.do",
						dataType:'json',
						contentType : "application/x-www-form-urlencoded",
						 queryParams: oTableInit.queryParams,
						//自定义toolbar工具栏
						toolbar: '#toolbar',
						cache: false,
						height: 400,
						striped: true,
						pagination: true,
						pageSize: 10,
						pageNumber:1,
						pageList: [10, 20, 50, 100, 200, 500],
						search: true,
						showColumns: true,
						showRefresh: true,
						showExport: true,
						exportTypes: ['csv','txt','xml'],
						search: true,
						clickToSelect: true,
						columns: [{field:"check",title:"check",align:"center",valign:"middle",sortable:"true",checkbox:"true"},
						{field:"user_email",title:"email",align:"center",valign:"middle",sortable:"true"},
						{field:"id",title:"id",align:"center",valign:"middle",sortable:"true"},
						{field:"user_company",title:"company",align:"center",valign:"middle",sortable:"true"},
						{field:"user_dates",title:"date",align:"center",valign:"middle",sortable:"true"}
						],
						
						data : [
						{"user_email":"20dai.rikon@gmail.com","id":"1","user_company":"","user_dates":"2014-10-13 13:35:51"},
						{"user_email":"20dai.rikon@gmail.com","id":"1","user_company":"","user_dates":"2014-10-13 13:35:51"},
						{"user_email":"20dai.rikon@gmail.com","id":"1","user_company":"","user_dates":"2014-10-13 13:35:51"},
						{"user_email":"20dai.rikon@gmail.com","id":"1","user_company":"","user_dates":"2014-10-13 13:35:51"},
						{"user_email":"20dai.rikon@gmail.com","id":"1","user_company":"","user_dates":"2014-10-13 13:35:51"},
						{"user_email":"20dai.rikon@gmail.com","id":"1","user_company":"","user_dates":"2014-10-13 13:35:51"},
						{"user_email":"20dai.rikon@gmail.com","id":"1","user_company":"","user_dates":"2014-10-13 13:35:51"},
						{"user_email":"20dai.rikon@gmail.com","id":"1","user_company":"","user_dates":"2014-10-13 13:35:51"},
						{"user_email":"20dai.rikon@gmail.com","id":"1","user_company":"","user_dates":"2014-10-13 13:35:51"},
						{"user_email":"20dai.rikon@gmail.com","id":"1","user_company":"","user_dates":"2014-10-13 13:35:51"},
						{"user_email":"20dai.rikon@gmail.com","id":"1","user_company":"","user_dates":"2014-10-13 13:35:51"},
						{"user_email":"20dai.rikon@gmail.com","id":"1","user_company":"","user_dates":"2014-10-13 13:35:51"},
						{"user_email":"20dai.rikon@gmail.com","id":"1","user_company":"","user_dates":"2014-10-13 13:35:51"}
						],
						
						
						
			
						onPageChange: function (size, number) {
							
							
							//var sle = $('#reportTable').bootstrapTable.getSelections();
							
							//alert(sle);
							
							
							//alert("pagechange"+$("#pageSizeInput").val(size));
							
							//console.log($("#pageNumberInput").val(number));
							
							//var form = $('#tableForm');
							//form.action= '${base}/showReport';
							//form.submit();
		                },
		                
						onSort: function (name, order) {
							alert("sort");
							var sle = $('#reportTable').bootstrapTable('getSelections');
							alert(sle.length+"     "+sle[0].user_email);
							
		                },
		                /*
						formatShowingRows: function (pageFrom, pageTo, totalRows) {
							alert("total"+totalRows+"pageFrom:"+pageFrom+" pageto"+pageTo);
		                },
		             
		                
						formatRecordsPerPage: function () {
							alert("formatRecordsPerPage");
		                }
		               ,
		              
		            
		                formatNoMatches: function(){
		                	alert("formatNoMatches");
		                }
		                 */
					});
		        	
		        	
		        };
    
		        oTableInit.queryParams = function (params) {
		            var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
		                limit: params.limit,   //页面大小
		                offset: params.offset,  //页码
		            };
		            return temp;
		        };
		        return oTableInit;
		    };	
			
			
			
			//删除操作
			$('#del').click(function(){
		
				var selections = $('#reportTable').bootstrapTable('getSelections');
				
				if(selections.length == 0 )
				{
					alert("还没有选中数据");
				}
				else
				{
					alert(selections[0].user_email);
					//页面删除一条数据
					$('#reportTable').bootstrapTable('remove',{field: 'id', values: selections[0].id});
						//$('#reportTable').bootstrapTable('removeAll');
					//{'user_email',selections[0].user_email}
				}
			});
			
			
			//添加操作
			$('#add').click(function()
			{
		
				alert("add");
		
			});
								
			$(window).resize(function () {
				$('#reportTable').bootstrapTable('resetView');
			});
	
		
	</script>
	

</body>

</html>