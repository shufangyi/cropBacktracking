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
import com.cbt.business.po.CopackRecordInfo;
import com.cbt.business.po.WorkerInfo;
import com.cbt.business.service.BusinessCropProjectInfoService;
import com.cbt.business.service.CheckInRecordInfoService;
import com.cbt.business.service.CopackRecordInfoService;
import com.cbt.business.service.PickRecordInfoService;
import com.cbt.business.service.SowRecordInfoService;
import com.cbt.business.service.WorkerInfoService;
import com.cbt.visitor.po.ProductStatusInfo;
import com.cbt.visitor.service.ProductStatusInfoService;

@Controller
@RequestMapping("/business/")
public class CopackRecordInfoController {
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
	
	
	@Resource(name="productStatusInfoServiceImpl")
	private ProductStatusInfoService productStatusInfoService;
	
	@RequestMapping("getCopackRecords.do")
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
		//String workerNum = worker.getWorkerNum();
		//int workerId = worker.getWorkerId();
		//根据workerId到项目员工表里查看此员工参与了哪些项目
		BusinessCropProjectInfo businessCropProjectInfo = new BusinessCropProjectInfo();
		businessCropProjectInfo.setWorkerId(workerId);
		//System.out.println("workerId"+workerId);
		//可能一个员工id对应多个项目
		List<BusinessCropProjectInfo> businessCropProjectInfolist=businessCropProjectInfoService.getBusinessCropProjectInfo(businessCropProjectInfo);
		ModelMap model = new ModelMap();
		List<CopackRecordInfo> lists = new ArrayList<CopackRecordInfo>();
		Map<String, Object> map=new HashMap<String, Object>();
		int total=0;
		for(int i=0;i<businessCropProjectInfolist.size();i++)
		{
			List<CopackRecordInfo> list = new ArrayList<CopackRecordInfo>();
			System.out.println("项目编码"+businessCropProjectInfolist.get(i).getProject_btCode());
			String project_btCode=businessCropProjectInfolist.get(i).getProject_btCode();
			map.put("startpage", (nowpage-1)*rows);
			map.put("rows", rows);
			map.put("projectBtcode",project_btCode);
			map.put("searchKey", searchKey);
			//得到参与的项目溯源码，模糊查询
			list =copackRecordInfoService.getCopackRecordsService(map);
			total = total+copackRecordInfoService.getCopackRecordsCountService(map);	
			System.out.println("project_btCode"+project_btCode+"list.size"+list.size());
			for(int j=0;j<list.size();j++)
			{
					//new SimpleDateFormat("yyyy-mm-dd").format(list.get(j).getSowtime())
					System.out.println("time:"+list.get(j).getCopacktime());
					//list.get(i).setSowtime(new SimpleDateFormat("yyyy-mm-dd").format(list.get(j).getSowtime()));				
					lists.add(list.get(j));
			}
		}
		model.put("rows", lists);	
		model.put("total", total);	
		return model;
	}
	
	@RequestMapping("updateCopackRecordInfo.do")
	@ResponseBody
	public String updateCopackRecordInfo(CopackRecordInfo copackRecordInfo)throws Exception{
		String mark="true";
		if(copackRecordInfoService.updateCopackRecordService(copackRecordInfo)<=0){
			mark="false";
			return mark;
		}
		return mark;
	}
	
	@RequestMapping("addCopackRecordInfo.do")
	@ResponseBody
	public String addCopackRecordInfo(CopackRecordInfo copackRecordInfo)throws Exception{
		String markString="true";
		String product_btCode = copackRecordInfo.getProductBtcode();
		ProductStatusInfo pinfo = new ProductStatusInfo();
		pinfo.setProduct_btCode(product_btCode);
		pinfo.setPublicStatus(1);
		pinfo.setQueryTimes(0);
		productStatusInfoService.insertNewProductService(pinfo);
		
		if(copackRecordInfoService.addCopackRecordInfo(copackRecordInfo)<=0){
			markString="false";
			return markString;
		}
		return markString;
		
	}
	
	@RequestMapping("delCopackRecordInfo.do")
	@ResponseBody
	public String delCopackRecordinfo(String data)throws Exception{
		ObjectMapper mapper=new ObjectMapper();
		JavaType javatype=mapper.getTypeFactory().constructParametricType(ArrayList.class,CopackRecordInfo.class);	
	    List<CopackRecordInfo> list=mapper.readValue(data, javatype);
	    //循环删除list数据
		//System.out.println(list.get(0).getCopacktime());
		for(int i=0;i<list.size();i++)
		{
			String product_btcode = list.get(i).getProductBtcode();
			productStatusInfoService.deleteProductStatusInfoService(product_btcode);
		}
		
		return copackRecordInfoService.delCopackRecordsService(list);
	}
	
	
	@RequestMapping("checkCheckInSegBtCode.do")
	@ResponseBody
	public String checkCheckInSegBtCode(String checkinsegBtcode,HttpSession session,HttpServletRequest req)throws Exception{
		String mark="false";
		if(checkinsegBtcode.length()!=21) {
			return mark;
		}
		//WorkerInfo worker = (WorkerInfo) session.getAttribute("workerInfo");
		int workerId = Integer.parseInt(req.getParameter("workerId"));
		//根据workerId到项目员工表里查看此员工参与了哪些项目
		BusinessCropProjectInfo businessCropProjectInfo = new BusinessCropProjectInfo();
		businessCropProjectInfo.setWorkerId(workerId);
		List<BusinessCropProjectInfo> businessCropProjectInfolist=businessCropProjectInfoService.getBusinessCropProjectInfo(businessCropProjectInfo);
		for(int i=0;i<businessCropProjectInfolist.size();i++){
			if(businessCropProjectInfolist.get(i).getProject_btCode().equals(checkinsegBtcode.substring(0,9))){
				mark="true";
				return mark;
			}
		}
		return mark;
	}
	
	@RequestMapping("getMCopackRecords.do")
	@ResponseBody
	public ModelMap getMCopackRecords(HttpServletRequest req,HttpSession session)throws Exception
	{
		int nowpage = Integer.parseInt(req.getParameter("pageNumber"));
		int rows = Integer.parseInt(req.getParameter("pageSize"));	
		String businessId =req.getParameter("business");
		String searchKey=req.getParameter("searchKey");
		ModelMap model=new ModelMap();
		List<CopackRecordInfo> lists=new ArrayList<CopackRecordInfo>();
		lists=copackRecordInfoService.getMCopackRecordsService(businessId, nowpage, rows, searchKey);
		int total=copackRecordInfoService.getMCopackRecordsCountService(businessId, searchKey);
		model.put("rows", lists);
		model.put("total",total);
		return model;
	}
	
	
	@RequestMapping("getPageCopackInfo.do")
	@ResponseBody
	public ModelMap getPageCopackInfo(HttpServletRequest req,HttpSession session)throws Exception
	{
		int nowpage = Integer.parseInt(req.getParameter("pageNumber"));
		int rows = Integer.parseInt(req.getParameter("pageSize"));	
		String projectCode =req.getParameter("projectCode");
		String searchKey=req.getParameter("searchKey");
		System.out.println(searchKey);
		ModelMap model=new ModelMap();
		List<CopackRecordInfo> lists=new ArrayList<CopackRecordInfo>();
		lists=copackRecordInfoService.getPageCopackInfo(projectCode, nowpage, rows, searchKey);
		int total=copackRecordInfoService.getCopackInfoCount(projectCode, searchKey);
		model.put("rows", lists);
		model.put("total",total);
		return model;
	}

}
