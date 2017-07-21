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
import com.cbt.business.service.ManagerInfoService;
import com.cbt.system.po.ManagerInfo;

@Controller
@RequestMapping("/business/")
public class ManagerInfoController {
	
	@Resource(name="managerInfoServiceImpl")
	private ManagerInfoService managerInfoService;

	@RequestMapping("addManager.do")
	public @ResponseBody String addmanager(ManagerInfo info)
	{
		Boolean mark = true;
		mark = managerInfoService.addManager(info);
		return mark.toString();
	}

	
	//修改一条数据参数roleinfo info
	@RequestMapping("updateManager.do")
	public @ResponseBody String updateManager(ManagerInfo info)
	{
	    Boolean mark = true; 
	    //调用service更新数据库
	    mark = managerInfoService.updateManager(info); 
	    return mark.toString();
	}
	//分页获取种植员自己的种植纪录
	@RequestMapping("getPageManagers.do")
	@ResponseBody
	public ModelMap getPageManagers(HttpServletRequest req,HttpSession session)
	{	
		int nowpage = Integer.parseInt(req.getParameter("pageNumber"));
		int rows = Integer.parseInt(req.getParameter("pageSize"));	
		ModelMap model = new ModelMap();
		List<ManagerInfo> lists = new ArrayList<ManagerInfo>();
		lists = managerInfoService.getPageManagers(nowpage, rows);
		model.put("rows", lists);	
		int total = managerInfoService.getManagersCount();	
		model.put("total", total);	
		return model;
	}
	
	
	
	//删除数据
	@RequestMapping("delManager.do")
	public @ResponseBody String delManager(String data) throws JsonParseException, JsonMappingException, IOException
		{
			ObjectMapper mapper=new ObjectMapper();
			JavaType javatype=mapper.getTypeFactory().constructParametricType(ArrayList.class,ManagerInfo.class);	
		    List<ManagerInfo> list=mapper.readValue(data, javatype);
		    //循环删除list数据
		    System.out.println("shanchu");
		    
			return managerInfoService.delManager(list).toString();
		}
	
	
	//管理员个人信息修改
	@RequestMapping("updateManagerPwd.do")
	public @ResponseBody String updateManagerPwd(String managerNum,String managerOldPwd,String managerNewPwd)
	{
		Boolean mark = false;
		ManagerInfo info = new ManagerInfo();
		info.setManagerNum(managerNum);
		info.setManagerPwd(managerOldPwd);	
		info = managerInfoService.getManagerInfo(info);
		if(info!=null)
		{
			info.setManagerPwd(managerNewPwd);
			mark = managerInfoService.updateManager(info);
			if(mark == true)
				return "2";
			else
				return "1";
		}
		return "0";
	}
}
