package com.cbt.business.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Marker;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cbt.business.po.BusinessCropProjectInfo;
import com.cbt.business.po.PickRecordInfo;
import com.cbt.business.po.SowRecordInfo;
import com.cbt.business.po.WorkerInfo;
import com.cbt.business.service.BusinessCropProjectInfoService;
import com.cbt.business.service.PickRecordInfoService;
import com.cbt.business.service.SowRecordInfoService;
import com.cbt.business.service.WorkerInfoService;
import com.cbt.business.service.impl.SowRecordInfoServiceImpl;

@Controller
@RequestMapping("/business/")
public class PickRecordInfoController {
	
	@Resource(name="businessCropProjectInfoServiceImpl")
	private BusinessCropProjectInfoService businessCropProjectInfoService;
	@Resource(name="pickRecordInfoServiceImpl")
	private PickRecordInfoService pickRecordInfoService;
	@Resource(name="sowRecordInfoServiceImpl")
	private SowRecordInfoService sowRecordInfoService;
	@Resource(name="workerInfoServiceImpl")
	private WorkerInfoService workerInfoservice;
	
	@RequestMapping("getPickRecordInfo.do")
	public String getPickRecordInfo()
	{
		return null;
	}
	/*
	 * 分页查询
	 */
	@RequestMapping("getPickRecord.do")
	@ResponseBody
	public ModelMap getPickRecords(HttpServletRequest req,HttpSession session)throws Exception
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
		List<PickRecordInfo> lists = new ArrayList<PickRecordInfo>();
		for(int i=0;i<businessCropProjectInfolist.size();i++)
		{
			List<PickRecordInfo> list = new ArrayList<PickRecordInfo>();
			String project_btCode=businessCropProjectInfolist.get(i).getProject_btCode();
			//得到参与的播种溯源码，模糊查询
			System.out.println("=======7-17========"+project_btCode+nowpage+rows);
			list = pickRecordInfoService.queryPickRecordsService(project_btCode,nowpage, rows,searchKey);
			total = total+pickRecordInfoService.getPickRecordCountService(project_btCode,nowpage, rows,searchKey);
			for(int j=0;j<list.size();j++)
			{
					//new SimpleDateFormat("yyyy-mm-dd").format(list.get(j).getSowtime())
					System.out.println("time:"+list.get(j).getPicktime());
					//list.get(i).setSowtime(new SimpleDateFormat("yyyy-mm-dd").format(list.get(j).getSowtime()));				
					lists.add(list.get(j));
			}
		}
		model.put("rows", lists);	
		model.put("total", total);	
		return model;
	}
	
	
	
	@RequestMapping(value="addPickRecordInfo.do")
	@ResponseBody
	public String addPickRecordInfo(PickRecordInfo pickRecordInfo)throws Exception{
		String mark="true";
		//将播种溯源码与采摘时间拼接，形成采摘溯源码
		if(pickRecordInfoService.addPickRecordInfo(pickRecordInfo)>0){
			return mark;
		}else {
			mark="false";
			return mark;
		}
	}
	
	@RequestMapping(value="checkSowSegBtCode.do")
	@ResponseBody
	public String checkSowSegBtCode(String sowsegBtcode,HttpSession session,HttpServletRequest req)throws Exception{
		String mark="false";
		System.out.println("==================sowSeg_btCode:"+sowsegBtcode+"length:"+sowsegBtcode.length());
		if(sowsegBtcode.length()!=13){
			return mark;
		}
		//WorkerInfo workInfo=(WorkerInfo) session.getAttribute("wordInfo");
		int workerId=Integer.parseInt(req.getParameter("workerId"));
		System.out.println("workerId:"+workerId);
		BusinessCropProjectInfo businessCropProjectInfo=new BusinessCropProjectInfo();
		businessCropProjectInfo.setWorkerId(workerId);
		List<BusinessCropProjectInfo> businessCropProjectInfoList=businessCropProjectInfoService.getBusinessCropProjectInfo(businessCropProjectInfo);
		for(int i=0;i<businessCropProjectInfoList.size();i++){
			if(businessCropProjectInfoList.get(i).getProject_btCode().equals(sowsegBtcode.substring(0,9))){
				System.out.println("++++++++++++++++++++"+businessCropProjectInfoList.get(i).getProject_btCode());
				System.out.println(sowsegBtcode.substring(0,9));
				mark="true";
				return mark;
			}
			
		}
		return mark;
	}
	
	@RequestMapping(value="updatePickRecordInfo")
	@ResponseBody
	public String updatePickRecordInfo(PickRecordInfo pickRecordInfo)throws Exception{
		String mark="false";
		if(pickRecordInfoService.updatePickRecordService(pickRecordInfo)>0){
			mark="true";
		}
		return mark;
	}
	
	@RequestMapping(value="delPickRecordInfo.do")
	@ResponseBody
	public String delPickRecordInfo(String data)throws Exception{
		String mark="true";
		ObjectMapper mapper=new ObjectMapper();
		JavaType javatype=mapper.getTypeFactory().constructParametricType(ArrayList.class,PickRecordInfo.class);	
	    List<PickRecordInfo> list=mapper.readValue(data, javatype);
	    //循环删除list数据
	    if(!pickRecordInfoService.delPickRecordByListService(list)){
	    	mark="false";
	    }
	    return mark;
	}
	
	/*
	 * 超级用户分页查询
	 */
	@RequestMapping("getMPickRecord.do")
	@ResponseBody
	public ModelMap getMPickRecords(HttpServletRequest req,HttpSession session)throws Exception
	{
		int nowpage = Integer.parseInt(req.getParameter("pageNumber"));
		int rows = Integer.parseInt(req.getParameter("pageSize"));	
		String businessId =req.getParameter("businessId");
		String searchKey=req.getParameter("searchKey");
		ModelMap model=new ModelMap();
		List<PickRecordInfo> lists=new ArrayList<PickRecordInfo>();
		lists=pickRecordInfoService.queryMPickRecordsService(businessId, nowpage, rows, searchKey);
		int total=pickRecordInfoService.getMPickRecordCountService(businessId, searchKey);
		model.put("rows", lists);
		model.put("total",total);
		return model;
	}
	
}
