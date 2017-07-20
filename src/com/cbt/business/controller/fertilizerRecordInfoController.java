package com.cbt.business.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.cbt.business.po.PickRecordInfo;
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
public class fertilizerRecordInfoController {
	

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
	
	@RequestMapping(value="getFertilizerRecords.do")
	@ResponseBody
	public ModelMap getFertilizerRecords(HttpServletRequest req,HttpSession session)throws Exception
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
		List<FertilizerRecordInfo> lists = new ArrayList<FertilizerRecordInfo>();
		for(int i=0;i<businessCropProjectInfolist.size();i++)
		{
			List<FertilizerRecordInfo> list = new ArrayList<FertilizerRecordInfo>();
			String project_btCode=businessCropProjectInfolist.get(i).getProject_btCode();
			//得到参与的溯源码，模糊查询
			System.out.println("==fertilizerRecord:="+project_btCode+nowpage+rows);
			list = fertilizerRecordInfoService.getFertilizerRecordService(project_btCode, nowpage, rows,searchKey);
			total = total+fertilizerRecordInfoService.getFertilizerRecordCountService(project_btCode, nowpage, rows,searchKey);
			for(int j=0;j<list.size();j++)
			{
					//new SimpleDateFormat("yyyy-mm-dd").format(list.get(j).getSowtime())
					System.out.println("time:"+list.get(j).getFertilizertime()+"fertilizerName:"+list.get(j).getFertilizername());
					//list.get(i).setSowtime(new SimpleDateFormat("yyyy-mm-dd").format(list.get(j).getSowtime()));				
					lists.add(list.get(j));
			}
		}
		model.put("rows", lists);	
		model.put("total", total);	
		return model;
	}
	
	@RequestMapping("addFertilizerRecordInfo.do")
	@ResponseBody
	public String addFertilizerRecord(FertilizerRecordInfo fertilizerRecordInfo)throws Exception{
		String mark="false";
		if(fertilizerRecordInfoService.addFertilizeRecordInfo(fertilizerRecordInfo)>0){
			mark="true";
		}
		return mark;
	}
	
	@RequestMapping("delFertilizerrecordInfo.do")
	@ResponseBody
	public String delFertilizerRecordInfo(String data)throws Exception{
		ObjectMapper mapper=new ObjectMapper();
		JavaType javatype=mapper.getTypeFactory().constructParametricType(ArrayList.class,FertilizerRecordInfo.class);	
	    List<FertilizerRecordInfo> list=mapper.readValue(data, javatype);
	    //循环删除list数据
		System.out.println(list.get(0).getFertilizertime());
		return fertilizerRecordInfoService.delFertilizerRecordService(list);
	}
	
	@RequestMapping("updateFertilizerRecordInfo.do")
	@ResponseBody
	public String updateFertilizerRecordInfo(FertilizerRecordInfo fertilizerRecordInfo)throws Exception{
		String mark="true";
		if(fertilizerRecordInfoService.updateFertilizerBySowBtCodeService(fertilizerRecordInfo)<0){
			mark="false";
		}
		return mark;
		
	}
	

	
	@RequestMapping("getMFertilizerRecords.do ")
	@ResponseBody
	public ModelMap getMFertilizerRecords(HttpServletRequest req,HttpSession session)throws Exception
	{
		int nowpage = Integer.parseInt(req.getParameter("pageNumber"));
		int rows = Integer.parseInt(req.getParameter("pageSize"));	
		String businessId =req.getParameter("businessId");
		String searchKey=req.getParameter("searchKey");
		ModelMap model=new ModelMap();
		List<FertilizerRecordInfo> lists=new ArrayList<FertilizerRecordInfo>();
		lists=fertilizerRecordInfoService.getMFertilizerRecordService(businessId, nowpage, rows, searchKey);
		int total=fertilizerRecordInfoService.getMFertilizerRecordCountService(businessId, searchKey);
		model.put("rows", lists);
		model.put("total",total);
		return model;
	}

}
