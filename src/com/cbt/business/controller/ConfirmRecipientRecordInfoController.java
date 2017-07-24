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
import com.cbt.business.po.ConfirmRecipientRecordInfo;
import com.cbt.business.po.CopackRecordInfo;
import com.cbt.business.po.DeliverRecordInfo;
import com.cbt.business.po.WorkerInfo;
import com.cbt.business.service.BusinessCropProjectInfoService;
import com.cbt.business.service.CheckInRecordInfoService;
import com.cbt.business.service.ConfirmRecipientRecordInfoService;
import com.cbt.business.service.CopackRecordInfoService;
import com.cbt.business.service.DeliverRecordInfoService;
import com.cbt.business.service.PickRecordInfoService;
import com.cbt.business.service.SowRecordInfoService;
import com.cbt.business.service.WorkerInfoService;

@Controller
@RequestMapping("/business/")
public class ConfirmRecipientRecordInfoController {
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
	@Resource(name="copackRecordInfoServiceImpl")
	private CopackRecordInfoService copackRecordInfoService;
	@Resource(name="deliverRecordInfoServiceImpl")
	private DeliverRecordInfoService deliverRecordInfoService;
	@Resource(name="confirmRecipientRecordInfoServiceImpl")
	private ConfirmRecipientRecordInfoService confirmRecipientRecordInfoService;
	
	@RequestMapping("getConfirmRecipientRecords.do")
	@ResponseBody
	public ModelMap getConfirmRecipientRecords(HttpServletRequest req,HttpSession session)throws Exception
	{	
		int nowpage = Integer.parseInt(req.getParameter("pageNumber"));
		int rows = Integer.parseInt(req.getParameter("pageSize"));	
		int workerId = Integer.parseInt(req.getParameter("workerId"));
		String searchKey=req.getParameter("searchKey");
		System.out.println("searchKey==============>>"+searchKey);
		/*
		 * 要获取此时登录员工账号
		 */
		//WorkerInfo worker = (WorkerInfo) session.getAttribute("workerInfo");
		//根据workerNum查找deliverRecord中记录
		WorkerInfo workerInfo=new WorkerInfo();
		workerInfo.setWorkerId(workerId);
		String workerNum=workerInfoservice.queryByWorkerIdService(workerInfo).getWorkerNum();
		Map<String, Object> map=new HashMap<>();
		map.put("startpage", (nowpage-1)*rows);
		map.put("rows", rows);
		map.put("distributor", workerNum);
		map.put("searchKey", searchKey);
		//分别查询出数据，以及数据的数量
		List<ConfirmRecipientRecordInfo> list=confirmRecipientRecordInfoService.getConfirmRecipientRecordsService(map);
		int total=confirmRecipientRecordInfoService.getConfirmRecipientRecordsCountService(map);
		
		ModelMap model = new ModelMap();
		model.put("rows", list);
		model.put("total", total);
		return model;

	}
	
	@RequestMapping("addConfirmRecipientRecordInfo.do")
	@ResponseBody
	public String addConfirmRecipientRecordInfo(ConfirmRecipientRecordInfo confirmRecipientRecordInfo)throws Exception{
		String mark="true";
		System.out.println("confirm time:"+confirmRecipientRecordInfo.getRecipienttime());
		if(confirmRecipientRecordInfoService.addConfirmRecipientRecordInfo(confirmRecipientRecordInfo)<=0){
			System.out.println("addConfirmRecipient successly");
			mark="false";
			return mark;
		}
		return mark;
	}

	@RequestMapping("delConfirmRecipientRecordInfo.do")
	@ResponseBody
	public String  delConfirmRecipientRecordInfo(String data)throws Exception{
		ObjectMapper mapper=new ObjectMapper();
		JavaType javatype=mapper.getTypeFactory().constructParametricType(ArrayList.class,ConfirmRecipientRecordInfo.class);	
	    List<ConfirmRecipientRecordInfo> list=mapper.readValue(data, javatype);
	    //循环删除list数据
		System.out.println(list.get(0).getRecipienttime());
		return confirmRecipientRecordInfoService.deleteConfirmRecipientRecords(list);
		
	}
	
	@RequestMapping("updateConfirmRecipientInfo.do")
	@ResponseBody
	public String updateConfirmRecipientInfo(ConfirmRecipientRecordInfo confirmRecipientRecordInfo)throws Exception{
		String mark="true";
		if(confirmRecipientRecordInfoService.updateConfirmRecipientRecordService(confirmRecipientRecordInfo)<=0){
			mark="false";
			return mark;
		}
		return mark;
	}
	
	@RequestMapping("checkConfirmRecipientOrderNum.do")
	@ResponseBody
	public String checkOrderNum(String ordernum,HttpSession session,HttpServletRequest req)throws Exception{
		String mark="false";
		int workerId= Integer.parseInt(req.getParameter("workerId"));
		BusinessCropProjectInfo businessCropProjectInfo=new BusinessCropProjectInfo();
		businessCropProjectInfo.setWorkerId(workerId);
		List<BusinessCropProjectInfo> list=businessCropProjectInfoService.getBusinessCropProjectInfo(businessCropProjectInfo);
		//orderNum查询出product_btCode
		CopackRecordInfo copackRecordInfo_orderNum=new CopackRecordInfo();
		copackRecordInfo_orderNum.setOrdernum(ordernum);
		CopackRecordInfo copackRecordInfo=copackRecordInfoService.queryByOrderNumService(copackRecordInfo_orderNum);
		if(copackRecordInfo==null) return mark;
		for(int i=0;i<list.size();i++){
			if(copackRecordInfo.getProductBtcode().substring(0, 9).equals(list.get(i).getProject_btCode())){
				mark="true";
				return mark;
			}
		}
		return mark;	
	}
	
	//企业负责人查看确认收货记录
	@RequestMapping("getMConfirmRecipientRecords.do")
	@ResponseBody
	public ModelMap getMConfirmRecipientRecords(HttpServletRequest req,HttpSession session)throws Exception
	{	
		int nowpage = Integer.parseInt(req.getParameter("pageNumber"));
		int rows = Integer.parseInt(req.getParameter("pageSize"));	
		int businessId = Integer.parseInt(req.getParameter("businessId"));
		String searchKey=req.getParameter("searchKey");
		System.out.println("searchKey==============>>"+searchKey);
		
		WorkerInfo workerInfo=new WorkerInfo();
		workerInfo.setBusinessId(businessId);
		//businessId查找出所有分销商账号
	    List<WorkerInfo> workerList=workerInfoservice.queryByBusinessIdService(workerInfo);
	    Map<String, Object> map=new HashMap<>();
	    List<ConfirmRecipientRecordInfo> confirmList=new ArrayList<>();
	    int total=0;
	    //对每个分销商账号
	    for(int i=0;i<workerList.size();i++){
	    	if(workerList.get(i).getRoleId()!=5) continue;
			map.put("startpage", (nowpage-1)*rows);
			map.put("rows", rows);
			map.put("distributor", workerList.get(i).getWorkerNum());
			map.put("searchKey", searchKey);
			//分别查询出数据，以及数据的数量
			List<ConfirmRecipientRecordInfo> list=confirmRecipientRecordInfoService.getConfirmRecipientRecordsService(map);
			total=total+confirmRecipientRecordInfoService.getConfirmRecipientRecordsCountService(map);
			for(int j=0;j<list.size();j++){
				confirmList.add(list.get(j));
			}
	    }
		ModelMap model = new ModelMap();
		model.put("rows", confirmList);
		model.put("total", total);
		return model;
	}
	
}
