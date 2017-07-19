package com.cbt.system.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cbt.system.po.ProductPlanUnitInfo;
import com.cbt.system.service.ProductPlanUnitInfoService;

@Controller
@RequestMapping("/system/")
public class ProductPlanUnitInfoController
{
	@Resource(name="productPlanUnitInfoServiceImpl")
	private ProductPlanUnitInfoService productPlanUnitInfoService;
	
	//获取所有的生产计划权限
	@RequestMapping(value="/getAllProductUnitInfo.do")
	@ResponseBody
	public ModelMap getAllProductUnitInfo() throws Exception
	{
		List<ProductPlanUnitInfo> list = productPlanUnitInfoService.queryAllUnitService();
		ModelMap model = new ModelMap();
		model.addAttribute("list", list);
		System.out.println(list);
		return model;
	}	
}
