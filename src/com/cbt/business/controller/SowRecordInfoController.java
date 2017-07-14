package com.cbt.business.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cbt.business.po.SowRecordInfo;
import com.cbt.business.service.SowRecordInfoService;


/*
 * 
 * 
 * 种植纪录
 */
@Controller
@RequestMapping("/business/")
public class SowRecordInfoController
{
	@Resource(name="sowRecordInfoServiceImpl")
	private SowRecordInfoService sowRecordInfoService;
	
	//一条记录,查询
	@RequestMapping("getSowRecordInfo.do")
	public @ResponseBody ModelMap getSowRecordInfo()
	{	
		return null;
	}
	
	//所有
	@RequestMapping("getAllSowRecordInfo.do")
	public @ResponseBody ModelMap getAllSowRecordInfo()
	{
		
		System.out.println(sowRecordInfoService.getAllSowRecordInfo().get(0).getProductname());
		return null;
	}
	
	//添加
	@RequestMapping("addSowRecordInfo.do")
	public ModelAndView addSowRecordInfo(SowRecordInfo info,HttpServletRequest req)
	{
		return null;
	}
	
	//删除
	@RequestMapping("delSowRecordInfo.do")
	public ModelAndView delSowRecordInfo(SowRecordInfo info,HttpServletRequest req)
	{
		return null;
	}
	@RequestMapping("getSowRecords.do")
	@ResponseBody
	public ModelMap getList(HttpServletRequest req)
	{	
		int nowpage = Integer.parseInt(req.getParameter("pageNumber"));
		int rows = Integer.parseInt(req.getParameter("pageSize"));
		Map<String,Object> map = new HashMap<String,Object>();
		//SowRecordInfo test = new SowRecordInfo();
		
		List<SowRecordInfo> list = new ArrayList<SowRecordInfo>();
		list = sowRecordInfoService.getPageSowRecords(nowpage, rows);	
		int total = sowRecordInfoService.getRecordsCount(null);	
		ModelMap model = new ModelMap();
		model.put("rows", list);
		model.put("total", total);	
		return model;
	}
	
}
