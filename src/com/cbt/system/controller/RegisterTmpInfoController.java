package com.cbt.system.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

import com.cbt.business.service.ManagerInfoService;
import com.cbt.system.po.ManagerInfo;
import com.cbt.system.po.RegisterTmpInfo;
import com.cbt.system.service.RegisterTmpInfoService;

@Controller
@RequestMapping("/system/")
public class RegisterTmpInfoController 
{
	
	@Resource(name="registerTmpInfoServiceImpl")
	private RegisterTmpInfoService registerTmpInfoService;
	
	@Resource(name="managerInfoServiceImpl")
	private ManagerInfoService managerInfoService;
	
	
	
	

	@RequestMapping("deleteRegisterTmpInfo.do")
	@ResponseBody 
	public String deleteRegisterTmpInfo(String data)throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper mapper=new ObjectMapper();
		JavaType javatype=mapper.getTypeFactory().constructParametricType(ArrayList.class,RegisterTmpInfo.class);	
	    List<RegisterTmpInfo> list=mapper.readValue(data, javatype);
	    //循环删除list数据

		return registerTmpInfoService.deleteRegisterTmpInfo(list).toString();
		
	}
	
	
	@RequestMapping("getPageRegisters.do")
	@ResponseBody 
	public ModelMap getPageRegisters(HttpServletRequest req,HttpSession session)
	{
		int nowpage = Integer.parseInt(req.getParameter("pageNumber"));
		int rows = Integer.parseInt(req.getParameter("pageSize"));
		String status=req.getParameter("status");
		ModelMap model = new ModelMap();
		List<RegisterTmpInfo> lists = new ArrayList<RegisterTmpInfo>();
		lists = registerTmpInfoService.getPageRegisters(nowpage, rows, status);
		model.put("rows", lists);	
		int total = registerTmpInfoService.getPageRegisterCount(status);	
		model.put("total", total);	
		return model;
	}
	
	

	@RequestMapping("rejectRegister.do")
	@ResponseBody 
	public String rejectRegister(String data) throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper mapper=new ObjectMapper();
		JavaType javatype=mapper.getTypeFactory().constructParametricType(ArrayList.class,RegisterTmpInfo.class);	
	    List<RegisterTmpInfo> list=mapper.readValue(data, javatype);
		return registerTmpInfoService.rejectRegister(list).toString();
	}
	
	
	@RequestMapping("allowRegister.do")
	@ResponseBody 
	public String allowRegister(String data)throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper mapper=new ObjectMapper();
		JavaType javatype=mapper.getTypeFactory().constructParametricType(ArrayList.class,RegisterTmpInfo.class);	
	    List<RegisterTmpInfo> list=mapper.readValue(data, javatype);
		return registerTmpInfoService.allowRegister(list).toString();

	}
	
	
	@RequestMapping("addRegisterTmpInfo.do")
	@ResponseBody 
	public String addRegisterTmpInfo(RegisterTmpInfo info)
	{
		Boolean mark = false;
		String managerNum = info.getManagerNum();
		//确保manager唯一
		ManagerInfo minfo = new ManagerInfo();
		minfo.setManagerNum(managerNum);
		if(managerInfoService.checkManagerNum(minfo)!=null)
			return "exist";
		//获取前端注册信息
		System.out.println(info.getBusinessName());
		System.out.println(info.getManagerEmail());
		if(info!=null)
		{
			//将前端注册信息存入数据库
			mark = registerTmpInfoService.addRegisterTmpInfo(info);
			return mark.toString();
		}
		return mark.toString();
		
	}
}
