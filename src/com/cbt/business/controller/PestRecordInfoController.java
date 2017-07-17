package com.cbt.business.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cbt.business.po.PestRecordInfo;

@Controller
@RequestMapping("/business/")
public class PestRecordInfoController {
	
	
	@RequestMapping("getPestRecords.do")
	@ResponseBody
	public ModelMap getPestRecords(HttpServletRequest req)
	{	
		System.out.println("pagesixze:"+req.getParameter("pageNumber"));
		System.out.println("pagesixze:"+req.getParameter("pageSize"));
		Map<String,Object> map = new HashMap<String,Object>();
		
		
		List<PestRecordInfo> list = new ArrayList<PestRecordInfo>();
		
		/*
		 * 在数据库中使用limit查询
		 */
		
		ModelMap model = new ModelMap();
		model.put("rows", list);
		//total	数据表中所有数据的数量
		model.put("total", 20);	
		return model;
	}
}
