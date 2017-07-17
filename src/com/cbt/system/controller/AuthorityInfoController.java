package com.cbt.system.controller;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cbt.system.po.AuthorityInfo;
import com.cbt.system.service.AuthorityInfoService;

@Controller
@RequestMapping("/system/")
public class AuthorityInfoController {

	@Resource(name="authorityInfoServiceImpl")
	private AuthorityInfoService authorityInfoService;
	
	/*
	 * 功能：获取权限列表
	 * 方法名称： getAllAuthority()
	 * 参数：五
	 * 返回：model
	 */
	@RequestMapping("getAllAuthority.do")
	public @ResponseBody ModelMap getAllAuthority()
	{
		List<AuthorityInfo> list = authorityInfoService.getAllAuthority();
		ModelMap model = new ModelMap();
		model.addAttribute("list", list);
		return model;
	}
	
	
	
}
