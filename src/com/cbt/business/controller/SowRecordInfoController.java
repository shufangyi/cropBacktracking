package com.cbt.business.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import org.springframework.web.servlet.ModelAndView;

import com.cbt.business.po.BusinessCropProjectInfo;
import com.cbt.business.po.SowRecordInfo;
import com.cbt.business.po.WorkerInfo;
import com.cbt.business.service.BusinessCropProjectInfoService;
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
	
	@Resource(name="businessCropProjectInfoServiceImpl")
	private BusinessCropProjectInfoService businessCropProjectInfoService;
	
	//一条记录,查询
	@RequestMapping("getSowRecordInfo.do")
	public @ResponseBody ModelMap getSowRecordInfo()
	{	
		return null;
	}
	
	//修改一条数据参数SowRecordInfo info
	@RequestMapping("updateSowRecordInfo.do")
	public @ResponseBody String updateSowRecord(SowRecordInfo info)
	{
		System.out.println(info.getProductname());
	    Boolean mark = true; 
	    //调用service更新数据库
	    mark = sowRecordInfoService.updateSowRecord(info);
	    return mark.toString();
	}
	
	//添加
	@RequestMapping("addSowRecordInfo.do")
	public @ResponseBody String addSowRecordInfo(SowRecordInfo info,HttpServletRequest req)
	{
		Boolean mark = true;
		System.out.println(info.getProductname());
		System.out.println(info.getSowtime());
		if(sowRecordInfoService.addSowRecordInfo(info)>0){
			return mark.toString();			
		}else {
			mark=false;
			return mark.toString();
		}
	}
	
	//删除
	@RequestMapping("delSowRecordInfo.do")
	public @ResponseBody String delSowRecordInfo(String data) throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper mapper=new ObjectMapper();
		JavaType javatype=mapper.getTypeFactory().constructParametricType(ArrayList.class,SowRecordInfo.class);	
	    List<SowRecordInfo> list=mapper.readValue(data, javatype);
	    //循环删除list数据
		System.out.println(list.get(0).getProductname());
		return sowRecordInfoService.delSowRecordInfo(list).toString();
	}
	
	//分页获取种植员自己的种植纪录
	@RequestMapping("getSowRecords.do")
	@ResponseBody
	public ModelMap getSowRecords(HttpServletRequest req,HttpSession session)
	{	
		int nowpage = Integer.parseInt(req.getParameter("pageNumber"));
		int rows = Integer.parseInt(req.getParameter("pageSize"));	
		int workerId=Integer.parseInt(req.getParameter("workerId"));
		String searchKey=req.getParameter("searchKey");
		System.out.println("searchKey==============>>"+searchKey);
		/*
		 * 要获取此时登录员工账号
		 */
		//WorkerInfo worker = (WorkerInfo) session.getAttribute("workerInfo");
		//String workerNum = worker.getWorkerNum();
		//int workerId = worker.getWorkerId();
		//根据workerId到项目员工表里查看此员工参与了哪些项目
		BusinessCropProjectInfo businessCropProjectInfo = new BusinessCropProjectInfo();
		businessCropProjectInfo.setWorkerId(workerId);
		//System.out.println("workerId"+workerId);
		//可能一个员工id对应多个项目
		List<BusinessCropProjectInfo> businessCropProjectInfolist=businessCropProjectInfoService.getBusinessCropProjectInfo(businessCropProjectInfo);
		ModelMap model = new ModelMap();
		int total=0;
		List<SowRecordInfo> lists = new ArrayList<SowRecordInfo>();
		for(int i=0;i<businessCropProjectInfolist.size();i++)
		{
			List<SowRecordInfo> list = new ArrayList<SowRecordInfo>();
			System.out.println("项目编码"+businessCropProjectInfolist.get(i).getProject_btCode());
			String project_btCode=businessCropProjectInfolist.get(i).getProject_btCode();
			//得到参与的项目溯源码，模糊查询
			list = sowRecordInfoService.getPageSowRecords(nowpage, rows,project_btCode,searchKey);
			total =total+ sowRecordInfoService.getRecordsCount(nowpage, rows,project_btCode,searchKey);
			for(int j=0;j<list.size();j++)
			{
					//new SimpleDateFormat("yyyy-mm-dd").format(list.get(j).getSowtime())
					System.out.println("time:"+list.get(j).getSowtime());
					//list.get(i).setSowtime(new SimpleDateFormat("yyyy-mm-dd").format(list.get(j).getSowtime()));				
					lists.add(list.get(j));
			}
		}
		model.put("rows", lists);	
		model.put("total", total);	
		return model;
	}
	
	
	//
	@RequestMapping("checkProjectBtcode.do")
	public @ResponseBody String CheckProjectBtcode(String projectBtcode,HttpSession session,HttpServletRequest req)
	{
		Boolean mark = false;
		//WorkerInfo worker = (WorkerInfo) session.getAttribute("workerInfo");
		int workerId=Integer.parseInt(req.getParameter("workerId"));
		//根据workerId到项目员工表里查看此员工参与了哪些项目
		BusinessCropProjectInfo businessCropProjectInfo = new BusinessCropProjectInfo();
		businessCropProjectInfo.setWorkerId(workerId);
		List<BusinessCropProjectInfo> businessCropProjectInfolist=businessCropProjectInfoService.getBusinessCropProjectInfo(businessCropProjectInfo);
		for(int i=0;i<businessCropProjectInfolist.size();i++)
		{
		
			if(businessCropProjectInfolist.get(i).getProject_btCode().equals(projectBtcode))
			{
				System.out.println("p:"+projectBtcode);
				System.out.println("p:"+businessCropProjectInfolist.get(i).getProject_btCode());
				mark = true;
				return mark.toString();
			}
		}
		return mark.toString();
	}
	

	
}
