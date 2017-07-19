package com.cbt.business.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

import com.cbt.business.po.WorkerInfo;
import com.cbt.business.service.WorkerInfoService;
import com.cbt.system.po.ManagerInfo;

@Controller
@RequestMapping("/business/")
public class WorkerInfoController 
{
	@Resource(name="workerInfoServiceImpl")
	private WorkerInfoService workerInfoService;
	@RequestMapping("getWorkers.do")
	public @ResponseBody ModelMap getWorkers(HttpSession session,String businessId)
	{
		ModelMap model = new ModelMap();
		//ManagerInfo manager = (ManagerInfo) session.getAttribute("managerInfo");
		if(businessId!=null)
		{
			List<WorkerInfo> list = workerInfoService.getWorkers(Integer.parseInt(businessId)); 
			model.addAttribute("list", list);
			return model;
		}
		System.out.println("ddddddddddd");
		return model;
	}
	
	
	
	@RequestMapping("getPageWorkers.do")
	@ResponseBody
	public ModelMap getPageWorkers(HttpServletRequest req,HttpSession session)
	{	
		int nowpage = Integer.parseInt(req.getParameter("pageNumber"));
		int rows = Integer.parseInt(req.getParameter("pageSize"));
		String business =  req.getParameter("businessId");
		ModelMap model = new ModelMap();
		int businessId = Integer.parseInt(business);
		List<WorkerInfo> lists = new ArrayList<WorkerInfo>();
		lists = workerInfoService.getPageWorkers(nowpage,rows,businessId);
		model.put("rows", lists);	
		int total = workerInfoService.getWorkersCount(businessId);	
		model.put("total", total);	
		return model;
	}
	
	
	@RequestMapping("delWorker.do")
	public @ResponseBody String delWorker(String data) throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper mapper=new ObjectMapper();
		JavaType javatype=mapper.getTypeFactory().constructParametricType(ArrayList.class,WorkerInfo.class);	
	    List<WorkerInfo> list=mapper.readValue(data, javatype);
	    //循环删除list数据
	    System.out.println("shanchu");
		//System.out.println(list.get(0).getRoleName());
		return workerInfoService.delWorkerInfo(list).toString();
	}
	
	
	@RequestMapping("addWorker.do")
	public @ResponseBody String addWorker(HttpSession session,WorkerInfo info)
	{	
		Boolean mark = false;
		mark = workerInfoService.addWorkerInfo(info);	
		return mark.toString();
	}
	

	
	
}
