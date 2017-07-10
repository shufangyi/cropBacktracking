package com.cbt.supersivor.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cbt.business.po.BusinessInfo;
import com.cbt.business.service.BusinessInfoService;
import com.cbt.supersivor.po.SupersivorInfo;
import com.cbt.supersivor.service.SupersivorInfoService;

@Controller
@RequestMapping("/supersivor/")
public class SupersivorInfoController 
{
	
	@Resource(name="supersivorInfoServiceImpl")
	private SupersivorInfoService supersivorInfoService;
	
	@Resource(name="businessInfoServiceImpl")
	private BusinessInfoService businessInfoService;
	
	
	
	
	@RequestMapping("login.do")
	public String login(SupersivorInfo info,HttpSession session,Model model)
	{
		System.out.println(info.getSupersivorNum());
		session.setAttribute("user", info);
		info = supersivorInfoService.getSupersivorInfo(info);
		if(info==null)
		{
			return "supersivor/login.html";
		}
		//System.out.println(info.getSupersivorNum());
		//session.setAttribute("user", info);
		return "supersivor/supersivor.jsp";
	}
	
	
	//获取公司列表
	
	@RequestMapping("getAllBusiness.do")
	public @ResponseBody ModelMap getAllBusinessInfo()
	{
		List<BusinessInfo> list = new ArrayList<BusinessInfo>();
		list = businessInfoService.getAllBusinessInfo();
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).getBusinessName());
		}		
		ModelMap model = new ModelMap();
		model.addAttribute("list", list);
		return model;
	}
	
	//通过前台传回的businessId获取公司的所有溯源产品
	@RequestMapping("getAllProcucts.do")
	public @ResponseBody ModelMap getAllProcucts(String businessId)
	{
		System.out.println(businessId);
		ModelMap model = new ModelMap();
		//到哪个表下查
		
		
		
		
		
		
		
		
		return null;
	}
	
	
	
	
	
	
}
