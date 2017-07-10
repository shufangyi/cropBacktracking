/*
 * 注销登录
 */
function logout()
{
	alert("退出");
};

function getSearchKey()
{
	//alert("search:"+$('#search_key').val());
	var key = $('#search_key'.val());
}
/*
 * 获取搜索key
 */
function myclick(businessId)
{
	alert(businessId);
	window.location="supersivor/productlist.jsp?businessId="+businessId;	
}
