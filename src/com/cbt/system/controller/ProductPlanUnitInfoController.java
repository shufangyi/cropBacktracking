package com.cbt.system.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cbt.system.po.ProductPlanUnitInfo;
import com.cbt.system.po.AdminInfo;
import com.cbt.system.service.ProductPlanUnitInfoService;

@Controller
@RequestMapping("/system/ppuinfo/")
public class ProductPlanUnitInfoController
{
	@Resource(name="productPlanUnitInfoServiceImpl")
	private ProductPlanUnitInfoService productPlanUnitInfoService;
	
	
	@RequestMapping("getPpuInfo.do")
	public @ResponseBody ModelMap getPpuInfo(HttpServletRequest req)
	{
		String name = req.getParameter("name");
		String value = req.getParameter("value");
		System.out.println(name);
		System.out.println(value);
		List<ProductPlanUnitInfo> ppuList = productPlanUnitInfoService.getAllPpuInfo(null);
		System.out.println("hello");
		for(int i=0;i<ppuList.size();i++)
		{
			System.out.println("hello");
			System.out.println("hello");
			System.out.println("hello");
			System.out.println("hello");
			System.out.println("hello");
			System.out.println(ppuList.get(i));
		}
		ModelMap model=new ModelMap();
		model.addAttribute("list", ppuList);
		model.addAttribute("tag", "hello");
		return model;
	}
}
