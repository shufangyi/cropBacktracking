package com.cbt.system.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cbt.system.po.ProductPlanInfo;
import com.cbt.system.service.ProductPlanInfoService;


@Controller
@RequestMapping("/system/")
public class ProductPlanInfoController {
	
	@Resource(name="productPlanInfoServiceImpl")
	private ProductPlanInfoService  productPlanInfoService;
	
	//分页查询生产计划
	@RequestMapping("getPageProductPlanInfo.do")
	@ResponseBody
	public ModelMap getPageProductPlanInfo(HttpServletRequest req,HttpSession session) throws Exception 
	{	
		int nowpage = Integer.parseInt(req.getParameter("pageNumber"));
		int rows = Integer.parseInt(req.getParameter("pageSize"));	
		String searchKey=req.getParameter("searchKey");
		ModelMap model = new ModelMap();
		List<ProductPlanInfo> lists = new ArrayList<ProductPlanInfo>();
		lists = productPlanInfoService.getPageProductPlan(nowpage,rows,searchKey);//ok
		System.out.println(lists);
		model.put("rows", lists);	
		int total =  productPlanInfoService.getProductPlanInfoCount(nowpage,rows,searchKey);
		model.put("total", total);	
		return model;
	}
	
	
	//删除多个生产计划
	@RequestMapping("delProductPlan.do")
	public @ResponseBody String delProductPlan(String data) throws Exception
	{
		/*接受json数据*/
		ObjectMapper mapper=new ObjectMapper();
		JavaType javatype=mapper.getTypeFactory().constructParametricType(ArrayList.class,ProductPlanInfo.class);	
	    List<ProductPlanInfo> list=mapper.readValue(data, javatype);
	    //循环删除list数据
		System.out.println("删除的第一个元素"+list.get(0).getPlanName());
		return 	productPlanInfoService.delProductPlan(list).toString();
	}
	
	//更新生产计划
	@RequestMapping("updateProductPlan.do")
	public @ResponseBody String updateProductPlan(ProductPlanInfo info) throws Exception
	{
		return productPlanInfoService.updateProductPlan(info).toString();
	}
	
	//添加一条数据
	@RequestMapping("addProductPlanInfo.do")
	public @ResponseBody String  addProductPlanInfo(ProductPlanInfo info) throws Exception
	{
		Boolean flag = true;
		if(productPlanInfoService.insertNewProductPlanService(info)<0){
			flag = false;
		}
		return  flag.toString();
		
	}
	
	@RequestMapping("getProductPlans.do")
	@ResponseBody
	public ModelMap getProductPlans()
	{
		ModelMap model = new ModelMap();
		List<ProductPlanInfo> list = productPlanInfoService.getProductPlans();
		model.addAttribute("list", list);
		
		return model;
		
	}
	
	

}
