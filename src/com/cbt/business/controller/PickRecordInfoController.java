package com.cbt.business.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cbt.business.po.PickRecordInfo;
import com.cbt.business.po.SowRecordInfo;

@Controller
@RequestMapping("/business/")
public class PickRecordInfoController {
	
	@RequestMapping("getPickRecordInfo.do")
	public String getPickRecordInfo()
	{
		return null;
	}
	
	
	
	/*
	 * 
	 */
	@RequestMapping("getPickRecords.do")
	@ResponseBody
	public ModelMap getPickRecords(HttpServletRequest req)
	{	
		System.out.println("pagesixze:"+req.getParameter("pageNumber"));
		System.out.println("pagesixze:"+req.getParameter("pageSize"));
		Map<String,Object> map = new HashMap<String,Object>();
		
		
		List<PickRecordInfo> list = new ArrayList<PickRecordInfo>();
		
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
