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
import com.cbt.business.po.CopackRecordInfo;
import com.cbt.business.po.DeliverRecordInfo;
import com.cbt.business.po.WorkerInfo;
import com.cbt.business.service.BusinessCropProjectInfoService;
import com.cbt.business.service.CheckInRecordInfoService;
import com.cbt.business.service.CopackRecordInfoService;
import com.cbt.business.service.DeliverRecordInfoService;
import com.cbt.business.service.PickRecordInfoService;
import com.cbt.business.service.SowRecordInfoService;
import com.cbt.business.service.WorkerInfoService;

@Controller
@RequestMapping("/business/")
public class DeliverRecordInfoController {
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
	
	@RequestMapping("getDeliverRecords.do")
	@ResponseBody
	public ModelMap getSowRecords(HttpServletRequest req,HttpSession session)throws Exception
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
	    System.out.println("+++++++++++++++++workerId:"+workerId);
		//根据workerNum查找deliverRecord中记录
	    WorkerInfo workerInfo=new WorkerInfo();
	    workerInfo.setWorkerId(workerId);
		String workerNum=workerInfoservice.queryByWorkerIdService(workerInfo).getWorkerNum();
		Map<String, Object> deliverMap=new HashMap<>();
		deliverMap.put("startpage", (nowpage-1)*rows);
		deliverMap.put("rows", rows);
		deliverMap.put("logistics", workerNum);
		deliverMap.put("searchKey", searchKey);
		//分别查询出数据，以及数据的数量
		List<DeliverRecordInfo> list=deliverRecordInfoService.getDeliverRecordsService(deliverMap);
		int total=deliverRecordInfoService.getDeliverRecordsCountService(deliverMap);
		//System.out.println("DeliverRecord"+list.get(0).getDelivertime());
		
		ModelMap model = new ModelMap();
		model.put("rows", list);
		model.put("total", total);
		return model;

	}
	
	@RequestMapping("addDeliverRecordInfo.do")
	@ResponseBody
	public String addDeliverRecordInfo(DeliverRecordInfo deliverRecordInfo)throws Exception{
		String mark="true";
		System.out.println(" add deliver time:"+deliverRecordInfo.getDelivertime());
		if(deliverRecordInfoService.addDeliverRecordInfo(deliverRecordInfo)<=0){
			mark="false";
			return mark;
		}
		System.out.println("addDeliverRecord successly");
		return mark;
	}
	
	@RequestMapping("delDeliverRecordInfo.do")
	@ResponseBody
	public String delDeliverRecordInfo(String data)throws Exception{
		ObjectMapper mapper=new ObjectMapper();
		JavaType javatype=mapper.getTypeFactory().constructParametricType(ArrayList.class,DeliverRecordInfo.class);	
	    List<DeliverRecordInfo> list=mapper.readValue(data, javatype);
	    //循环删除list数据
		System.out.println(list.get(0).getDelivertime());
		return deliverRecordInfoService.deleteDeliverRecords(list);
		
	}
	
	@RequestMapping("updateDeliverRecordInfo.do")
	@ResponseBody
	public String updateDeliverRecordInfo(DeliverRecordInfo deliverRecordInfo)throws Exception{
		String mark="true";
		if(deliverRecordInfoService.updateDeliverRecordService(deliverRecordInfo)<=0){
			mark="false";
			return mark;
		}
		return mark;
	}
	
	@RequestMapping("checkOrderNum.do")
	@ResponseBody
	public String checkOrderNum(String ordernum,HttpSession session,HttpServletRequest req)throws Exception{
		String mark="false";
		//WorkerInfo worker = (WorkerInfo) session.getAttribute("workerInfo");
		//根据workerNum查找deliverRecord中记录
		String workerNum=req.getParameter("workerNum");
		List<DeliverRecordInfo> list=deliverRecordInfoService.queryByLogisticsService(workerNum);
		for(int i=0;i<list.size();i++){
			if(ordernum.equals(list.get(i).getOrdernum())){
				mark="true";
				return mark;
			}		
		}
		return mark;
		
	}

}
