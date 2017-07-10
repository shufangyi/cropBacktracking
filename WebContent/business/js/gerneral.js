$(document).ready(function()
		{	 
			 var user = { workerNum: $('#Num').text(), workerPwd: $('#Pwd').text(),
					 roleId:parseInt($('#RoleId').text()),
					 workerId:parseInt($('#workerId').text())
			 };
			 var roleId = "hello";
		    //post方式传送的数据
			$.ajax({
				type:"post",
				url:'business/getAuthority.do',
				dataType:"json",
				data:user,
				success:function(data)
				{
					for(var i=0;i<data.role.length;i++)
					{
						$('#Res').append(data.role[i]+"<br>");
						$('#authority').append(data.role[i]+"<br>");
						
					}	
					$('#pcode').append(data.btcode+"<br>");
				},
				failure:function(data)
				{
					alert("error");
				}
			});
			
			
			
});