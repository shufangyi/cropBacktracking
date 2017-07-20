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
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cbt.business.po.BusinessCropProjectInfo;
import com.cbt.business.po.CheckInRecordInfo;
import com.cbt.business.po.SowRecordInfo;
import com.cbt.business.po.WorkerInfo;
import com.cbt.business.service.BusinessCropProjectInfoService;
import com.cbt.business.service.CheckInRecordInfoService;
import com.cbt.business.service.PickRecordInfoService;
import com.cbt.business.service.SowRecordInfoService;
import com.cbt.business.service.WorkerInfoService;

@Controller
@RequestMapping("/business/")
public class CheckInRecordInfoController {
	@Resource(name="businessCropProjectInfoServiceImpl")
	private BusinessCropProjectInfoService businessCropProjectInfoService;
	@Resource(name="pickRecordInfoServiceImpl")
	private PickRecordInfoService pickRecordInfoService;
	@Resource(name="sowRecordInfoServiceImpl")
	private SowRecordInfoService sowRecordInfoService;
	@Resource(name="workerInfoServiceImpl")
	private WorkerInfoService workerInfoservice;
	@Resource(name="checkInRecordInfoServiceImpl")
	private CheckInRecordInfoService checkInRecordInfoService;
	
	@RequestMapping("getCheckInRecords.do")
	@ResponseBody
	public ModelMap getSowRecords(HttpServletRequest req,HttpSession session)throws Exception
	{	
		int nowpage = Integer.parseInt(req.getParameter("pageNumber"));
		int rows = Integer.parseInt(req.getParameter("pageSize"));	
		int workerId = Integer.parseInt(req.getParameter("workerId"));
		String searchKey =req.getParameter("searchKey");
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
		List<CheckInRecordInfo> lists = new ArrayList<CheckInRecordInfo>();
		Map<String, Object> map=new HashMap<String, Object>();
		int total=0;
		for(int i=0;i<businessCropProjectInfolist.size();i++)
		{
			List<CheckInRecordInfo> list = new ArrayList<CheckInRecordInfo>();
			System.out.println("项目编码"+businessCropProjectInfolist.get(i).getProject_btCode());
			String project_btCode=businessCropProjectInfolist.get(i).getProject_btCode();
			map.put("startpage", (nowpage-1)*rows);
			map.put("rows", rows);
			map.put("projectBtcode",project_btCode);
			map.put("searchKey", searchKey);
			//得到参与的项目溯源码，模糊查询
			list = checkInRecordInfoService.getCheckInRecordByPaginationService(map);
			total = total+checkInRecordInfoService.getPaginationCountService(map);
			System.out.println("project_btCode"+project_btCode+"list.size"+list.size());
			for(int j=0;j<list.size();j++)
			{
					//new SimpleDateFormat("yyyy-mm-dd").format(list.get(j).getSowtime())
					System.out.println("time:"+list.get(j).getCheckintime());
					//list.get(i).setSowtime(new SimpleDateFormat("yyyy-mm-dd").format(list.get(j).getSowtime()));				
					lists.add(list.get(j));
			}
		}
		model.put("rows", lists);		
		model.put("total", total);	
		return model;
	}
	
	@RequestMapping("checkPickSegBtCode.do")
	@ResponseBody
	public String checkPickSegBtCode(String picksegBtcode,HttpSession session,HttpServletRequest req)throws Exception{
		String mark="false";
		if(picksegBtcode.length()!=17){
			return mark;
		}
		System.out.println(picksegBtcode.substring(0, 9));
		//WorkerInfo worker = (WorkerInfo) session.getAttribute("workerInfo");
		//int workerId = worker.getWorkerId();
		int workerId = Integer.parseInt(req.getParameter("workerId"));
		//根据workerId到项目员工表里查看此员工参与了哪些项目
		BusinessCropProjectInfo businessCropProjectInfo = new BusinessCropProjectInfo();
		businessCropProjectInfo.setWorkerId(workerId);
		List<BusinessCropProjectInfo> businessCropProjectInfolist=businessCropProjectInfoService.getBusinessCropProjectInfo(businessCropProjectInfo);
		for(int i=0;i<businessCropProjectInfolist.size();i++){
			if(businessCropProjectInfolist.get(i).getProject_btCode().equals(picksegBtcode.substring(0,9))){
				System.out.println("size: "+businessCropProjectInfolist.size()+"   "+businessCropProjectInfolist.get(i).getProject_btCode());
				mark="true";
				return mark;
			}
			
		}
		return mark;
	}
	
	@RequestMapping("addCheckInRecordInfo.do")
	@ResponseBody
	public String addCheckInRecordInfo(CheckInRecordInfo checkInRecordInfo)throws Exception{
		String mark="false";
		//采摘溯源码+质检时间，组成质检溯源码
		if(checkInRecordInfoService.addCheckInRecordInfo(checkInRecordInfo)>0){
			mark="true";
			return mark;
		}
		return mark;
	}
	
	
	@RequestMapping("updateCheckInRecordInfo.do")
	@ResponseBody
	public String updateCheckInRecordInfo(CheckInRecordInfo checkInRecordInfo)throws Exception{
		String mark="false";
		if(checkInRecordInfoService.updateCheckInRecordService(checkInRecordInfo)>0){
			mark="true";
			return mark;
		}
		return mark;
	}

	
	@RequestMapping("delCheckInRecordInfo.do")
	@ResponseBody
	public String delCheckInRecordInfo(String data) throws Exception{
		ObjectMapper mapper=new ObjectMapper();
		JavaType javatype=mapper.getTypeFactory().constructParametricType(ArrayList.class,CheckInRecordInfo.class);	
	    List<CheckInRecordInfo> list=mapper.readValue(data, javatype);
	    //循环删除list数据
		System.out.println(list.get(0).getCheckintime());
		return checkInRecordInfoService.delCheckInRecords(list);
		
		
	}
}
