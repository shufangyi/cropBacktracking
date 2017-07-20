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
import com.cbt.business.po.FertilizerRecordInfo;
import com.cbt.business.po.PestRecordInfo;
import com.cbt.business.po.SowRecordInfo;
import com.cbt.business.po.WorkerInfo;
import com.cbt.business.service.BusinessCropProjectInfoService;
import com.cbt.business.service.CheckInRecordInfoService;
import com.cbt.business.service.ConfirmRecipientRecordInfoService;
import com.cbt.business.service.CopackRecordInfoService;
import com.cbt.business.service.DeliverRecordInfoService;
import com.cbt.business.service.FertilizerRecordInfoService;
import com.cbt.business.service.PestRecordInfoService;
import com.cbt.business.service.PickRecordInfoService;
import com.cbt.business.service.SowRecordInfoService;
import com.cbt.visitor.service.ProductStatusInfoService;

@Controller
@RequestMapping("/business/")
public class PestRecordInfoController {
	
	@Resource(name="sowRecordInfoServiceImpl")
	private SowRecordInfoService sowRecordInfoService;
	@Resource(name="fertilizerRecordInfoServiceImpl")
	private FertilizerRecordInfoService fertilizerRecordInfoService;
	@Resource(name="pestRecordInfoServiceImpl")
	private PestRecordInfoService pestRecordInfoService;
	@Resource(name="pickRecordInfoServiceImpl")
	private PickRecordInfoService pickRecordInfoService;
	@Resource(name="checkInRecordInfoServiceImpl")
	private CheckInRecordInfoService checkInRecordInfoService;
	@Resource(name="copackRecordInfoServiceImpl")
	private CopackRecordInfoService copackRecordInfoService;
	@Resource(name="deliverRecordInfoServiceImpl")
	private DeliverRecordInfoService deliverRecordInfoService;
	@Resource(name="confirmRecipientRecordInfoServiceImpl")
	private ConfirmRecipientRecordInfoService confirmRecipientRecordInfoService;
	@Resource(name="productStatusInfoServiceImpl")
	private ProductStatusInfoService productStatusInfoService;
	@Resource(name="businessCropProjectInfoServiceImpl")
	private BusinessCropProjectInfoService businessCropProjectInfoService;
	
	//分页查询
	@RequestMapping("getPestRecords.do")
	@ResponseBody
	public ModelMap getPestRecords(HttpServletRequest req,HttpSession session)throws Exception
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
		List<PestRecordInfo> lists = new ArrayList<PestRecordInfo>();
		for(int i=0;i<businessCropProjectInfolist.size();i++)
		{
			List<PestRecordInfo> list = new ArrayList<PestRecordInfo>();
			String project_btCode=businessCropProjectInfolist.get(i).getProject_btCode();
			//得到参与的溯源码，模糊查询
			System.out.println("=======7-17========"+project_btCode+nowpage+rows);
			list = pestRecordInfoService.getPestRecordsService(project_btCode, nowpage, rows,searchKey);
			total = total+pestRecordInfoService.getCountService(project_btCode, nowpage, rows,searchKey);	
			for(int j=0;j<list.size();j++)
			{
					//new SimpleDateFormat("yyyy-mm-dd").format(list.get(j).getSowtime())
					System.out.println("time:"+list.get(j).getSprayTime());
					//list.get(i).setSowtime(new SimpleDateFormat("yyyy-mm-dd").format(list.get(j).getSowtime()));				
					lists.add(list.get(j));
			}
		}
		model.put("rows", lists);		
		model.put("total", total);	
		return model;
	}
	 
	@RequestMapping(value="delPestRecordInfo.do")
	@ResponseBody
	public String delPestRecordInfo(String data)throws Exception{
		ObjectMapper mapper=new ObjectMapper();
		JavaType javatype=mapper.getTypeFactory().constructParametricType(ArrayList.class,PestRecordInfo.class);	
	    List<PestRecordInfo> list=mapper.readValue(data, javatype);
	    //循环删除list数据
		System.out.println(list.get(0).getSprayTime());
		return pestRecordInfoService.delPestRecordInfoService(list);
		
	}
	
	@RequestMapping(value="updatePestRecordInfo.do")
	@ResponseBody
	public String updatePestRecordInfo(PestRecordInfo pestRecordInfo)throws Exception{
		String mark="true";
		if(pestRecordInfoService.updatePestRecordInfoService(pestRecordInfo)>0){
			mark="false";
		}
		return mark;
	}
	
	@RequestMapping(value="addPestRecordInfo.do")
	@ResponseBody
	public String addPestRecordInfo(PestRecordInfo pestRecordInfo)throws Exception{
		String mark="ture";
		if(pestRecordInfoService.addPestRecordInfo(pestRecordInfo)<=0){
			mark="false";
		}
		return mark;
		
	}
	
	@RequestMapping("getMPestRecords.do")
	@ResponseBody
	public ModelMap getMPestRecords(HttpServletRequest req,HttpSession session)throws Exception
	{
		int nowpage = Integer.parseInt(req.getParameter("pageNumber"));
		int rows = Integer.parseInt(req.getParameter("pageSize"));	
		String businessId =req.getParameter("businessId");
		String searchKey=req.getParameter("searchKey");
		ModelMap model=new ModelMap();
		List<PestRecordInfo> lists=new ArrayList<PestRecordInfo>();
		lists=pestRecordInfoService.getMPestRecordsService(businessId, nowpage, rows, searchKey);
		int total=pestRecordInfoService.getMCountService(businessId, searchKey);
		model.put("rows", lists);
		model.put("total",total);
		return model;
	}
	
}
