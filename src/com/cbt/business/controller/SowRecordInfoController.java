package com.cbt.business.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cbt.business.po.SowRecordInfo;
import com.cbt.business.service.SowRecordInfoService;

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
		info.setGrower("zhou");
		info.setProjectBtcode("111201701");
		info.setSowtime(new Date());
		info.setSowsegBtcode("1112017011101");
		info.setProductname("水稻");
		info.setSeedsource("五权");
		info.setSownum(1000);
		System.out.println("add res:	"+sowRecordInfoService.addSowRecordInfo(info));
		return null;
	}
	
	//删除
	@RequestMapping("delSowRecordInfo.do")
	public ModelAndView delSowRecordInfo(SowRecordInfo info,HttpServletRequest req)
	{
		info.setId(2);
		info.setGrower("zhou");
		info.setProjectBtcode("111201701");
		info.setSowtime(new Date());
		info.setSowsegBtcode("1112017011101");
		info.setProductname("水稻");
		info.setSeedsource("五权");
		info.setSownum(1000);
		System.out.println("add res:	"+sowRecordInfoService.delSowRecordInfo(info));
		return null;
	}
}
