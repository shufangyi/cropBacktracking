package com.cbt.business.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cbt.business.po.BusinessProjectPlanInfo;
import com.cbt.business.service.BusinessProjectPlanInfoService;
import com.cbt.system.po.ManagerInfo;

@Controller

@RequestMapping("/business/")
public class BusinessProjectPlanInfoController
{
	@Resource(name="businessProjectPlanInfoServiceImpl")
	private BusinessProjectPlanInfoService businessProjectPlanInfoService;
	

	//分页获取计划信息
	@RequestMapping("getPageBusinessProjectPlan.do")
	@ResponseBody
	public ModelMap getPageBusinessProjectPlan(HttpServletRequest req,HttpSession session)
	{	
		int nowpage = Integer.parseInt(req.getParameter("pageNumber"));
		int rows = Integer.parseInt(req.getParameter("pageSize"));	
		String business = req.getParameter("business");	
		System.out.println("business:	"+business);
		ModelMap model = new ModelMap();
		List<BusinessProjectPlanInfo> lists = new ArrayList<BusinessProjectPlanInfo>();
		if(business!=null)
		{
			int businessId = Integer.parseInt(business);
			lists = businessProjectPlanInfoService.getPageBusinessProjectPlans(nowpage, rows, businessId);
			model.put("rows", lists);	
			int total = businessProjectPlanInfoService.getBusinessProjectPlansCount(businessId);
			model.put("total", total);	
		}
		
		return model;
	}
	
	
	//2017-07-18
	@RequestMapping("addBusinessProjectPlan.do")
	public @ResponseBody String addBusinessProjectPlan(BusinessProjectPlanInfo info,String business,HttpSession session)
	{
		Boolean mark = true;
		String cropCode = info.getCropCode();
		int year = info.getYear();
		System.out.println("business:"+business);
		int businessId = Integer.parseInt(business);
		info.setBusinessId(businessId);
		info.setProject_btCode(businessId+""+year+""+cropCode);
		mark = businessProjectPlanInfoService.addBusinessProjectPlan(info);
		return mark.toString();
	}
	
	

	//修改一条数据参数roleinfo info
	@RequestMapping("updateBusinessProjectPlan.do")
	public @ResponseBody String updateBusinessProjectPlan(BusinessProjectPlanInfo info)
	{
	    Boolean mark = true; 
	    //调用service更新数据库
	    mark = businessProjectPlanInfoService.updateBusinessProjectPlan(info);
	    return mark.toString();
	}

	//删除数据
	@RequestMapping("delBusinessProjectPlan.do")
	public @ResponseBody String delRole(String data) throws JsonParseException, JsonMappingException, IOException
		{
			ObjectMapper mapper=new ObjectMapper();
			JavaType javatype=mapper.getTypeFactory().constructParametricType(ArrayList.class,BusinessProjectPlanInfo.class);	
		    List<BusinessProjectPlanInfo> list=mapper.readValue(data, javatype);
		    //循环删除list数据
		    System.out.println("shanchu");
			System.out.println(list.get(0).getProductName());
			return businessProjectPlanInfoService.delBusinessProjectPlan(list).toString();
		}
}
