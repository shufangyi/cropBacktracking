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

import com.cbt.business.po.ConfirmRecipientRecordInfo;
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
	public ModelMap getSowRecords(HttpServletRequest req,HttpSession session)throws Exception
	{	
		int nowpage = Integer.parseInt(req.getParameter("pageNumber"));
		int rows = Integer.parseInt(req.getParameter("pageSize"));	
		/*
		 * 要获取此时登录员工账号
		 */
		WorkerInfo worker = (WorkerInfo) session.getAttribute("workerInfo");
		//根据workerNum查找deliverRecord中记录
		WorkerInfo workerInfo=new WorkerInfo();
		workerInfo.setWorkerId(worker.getWorkerId());
		String workerNum=workerInfoservice.queryByWorkerIdService(workerInfo).getWorkerNum();
		Map<String, Object> map=new HashMap<>();
		map.put("startpage", (nowpage-1)*rows);
		map.put("rows", rows);
		map.put("distributor", workerNum);
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
	public String checkOrderNum(String ordernum,HttpSession session)throws Exception{
		String mark="false";
		WorkerInfo worker = (WorkerInfo) session.getAttribute("workerInfo");
		//根据workerNum查找deliverRecord中记录
		String workerNum=worker.getWorkerNum();
		List<ConfirmRecipientRecordInfo> list=confirmRecipientRecordInfoService.queryByDistributorService(workerNum);
		for(int i=0;i<list.size();i++){
			if(ordernum.equals(list.get(i).getOrdernum())){
				mark="true";
				return mark;
			}		
		}
		return mark;
		
	}
	
}
