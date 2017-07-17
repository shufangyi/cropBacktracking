package com.cbt.system.controller;

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

import com.cbt.business.po.SowRecordInfo;
import com.cbt.system.po.RoleInfo;
import com.cbt.system.service.RoleInfoService;

@Controller
@RequestMapping("/system/")
public class RoleInfoController
{
	@Resource(name="roleInfoServiceImpl")
	private RoleInfoService roleInfoService;

	@RequestMapping("addRole.do")
	public @ResponseBody String addRole(RoleInfo roleinfo)
	{
		Boolean mark = true;
		mark = roleInfoService.addRole(roleinfo);
		return mark.toString();
	}
	
	
	
	
	//修改一条数据参数roleinfo info
	@RequestMapping("updateRole.do")
	public @ResponseBody String updateRole(RoleInfo info)
	{
	    Boolean mark = true; 
	    //调用service更新数据库
	    System.out.println(info.getRoleDesc());
	    mark = roleInfoService.updateRole(info);
	    
	    return mark.toString();
	}
	
	
	

	
	
	
	
	
	
	
	//分页获取种植员自己的种植纪录
	@RequestMapping("getPageRoles.do")
	@ResponseBody
	public ModelMap getRoless(HttpServletRequest req,HttpSession session)
	{	
		int nowpage = Integer.parseInt(req.getParameter("pageNumber"));
		int rows = Integer.parseInt(req.getParameter("pageSize"));	
		ModelMap model = new ModelMap();
		List<RoleInfo> lists = new ArrayList<RoleInfo>();
		lists = roleInfoService.getPageRoles(nowpage, rows);
		model.put("rows", lists);	
		int total = roleInfoService.getRecordsCount();	
		model.put("total", total);	
		return model;
	}
	
	
	
	//删除数据
	@RequestMapping("delRole.do")
	public @ResponseBody String delRole(String data) throws JsonParseException, JsonMappingException, IOException
		{
			ObjectMapper mapper=new ObjectMapper();
			JavaType javatype=mapper.getTypeFactory().constructParametricType(ArrayList.class,RoleInfo.class);	
		    List<RoleInfo> list=mapper.readValue(data, javatype);
		    //循环删除list数据
		    System.out.println("shanchu");
			System.out.println(list.get(0).getRoleName());
			return roleInfoService.delRoleInfo(list).toString();
		}
}
