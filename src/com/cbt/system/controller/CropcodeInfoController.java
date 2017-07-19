package com.cbt.system.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cbt.system.po.CropcodeInfo;
import com.cbt.system.service.CropcodeInfoService;

@Controller
@RequestMapping("/system/")
public class CropcodeInfoController {
	
	@Resource(name="cropcodeInfoServiceImpl")
	private CropcodeInfoService cropcodeInfoService;
	
//	分页获取作物编码
	@RequestMapping("getPageCropcodeInfo.do")
	@ResponseBody
	public ModelMap getCropcodeInfo(HttpServletRequest req,HttpSession session){
		int nowpage = Integer.parseInt(req.getParameter("pageNumber"));
		int rows = Integer.parseInt(req.getParameter("pageSize"));	
		ModelMap model = new ModelMap();
		List<CropcodeInfo> lists = new ArrayList<CropcodeInfo>();
		lists = cropcodeInfoService.getPageCropcodeInfo(nowpage, rows);
		model.put("rows", lists);	
		int total = cropcodeInfoService.getRecordsCount();	
		model.put("total", total);	
		return model;
	}
}
