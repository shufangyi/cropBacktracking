package com.cbt.visitor.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.aspectj.weaver.NewFieldTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cbt.business.po.CheckInRecordInfo;
import com.cbt.business.po.ConfirmRecipientRecordInfo;
import com.cbt.business.po.CopackRecordInfo;
import com.cbt.business.po.DeliverRecordInfo;
import com.cbt.business.po.FertilizerRecordInfo;
import com.cbt.business.po.PestRecordInfo;
import com.cbt.business.po.PickRecordInfo;
import com.cbt.business.po.SowRecordInfo;
import com.cbt.business.service.CheckInRecordInfoService;
import com.cbt.business.service.ConfirmRecipientRecordInfoService;
import com.cbt.business.service.CopackRecordInfoService;
import com.cbt.business.service.DeliverRecordInfoService;
import com.cbt.business.service.FertilizerRecordInfoService;
import com.cbt.business.service.PestRecordInfoService;
import com.cbt.business.service.PickRecordInfoService;
import com.cbt.business.service.SowRecordInfoService;
import com.cbt.business.service.impl.CheckInRecordInfoServiceImpl;
import com.cbt.business.service.impl.ConfirmRecipientRecordInfoServiceImpl;
import com.cbt.business.service.impl.CopackRecordInfoServiceImpl;
import com.cbt.business.service.impl.DeliverRecordInfoServiceImpl;
import com.cbt.business.service.impl.FertilizerRecordInfoServiceImpl;
import com.cbt.business.service.impl.PestRecordInfoServiceImpl;
import com.cbt.business.service.impl.PickRecordInfoServiceImpl;
import com.cbt.visitor.po.ProductStatusInfo;
import com.cbt.visitor.service.ProductStatusInfoService;
import com.sun.org.apache.bcel.internal.generic.NEW;

@Controller
@RequestMapping("/visitor/")
public class VisitorQueryController 
{
	
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
	
	@RequestMapping("getWholeInfo.do")
	public @ResponseBody ModelMap getWholeInfo(String queryId) throws Exception
	{
		System.out.println(queryId);
		if(queryId.length()!=25)
			return null;	
		ModelMap model = new ModelMap();
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		
		//根据queryId的前13位可以获取sowrecord包装记录
		SowRecordInfo sowRecordInfo = sowRecordInfoService.getSowRecordInfoBySowSeg_btCode(queryId.substring(0, 13));
		if(sowRecordInfo!=null)
		{
			Map<String,Object> map = new HashMap<String,Object>();
			System.out.println("sow:		"+sowRecordInfo.toString());
			model.addAttribute("sowRecord", sowRecordInfo);
			String sowTime=(new SimpleDateFormat("yyyy-MM-dd")).format(sowRecordInfo.getSowtime());
			//时间单独处理
			String sowName = "播种";
			map.put("时间", sowTime);
			map.put("环节", sowName);
			map.put("种子来源", sowRecordInfo.getSeedsource());
			map.put("种植地点", sowRecordInfo.getSowlocation());
			map.put("负责人", sowRecordInfo.getGrower());			
			list.add(map);
			//map.clear();
		}
		//根据queryId的前13位可以获取fertilizerRecord包装记录
		List<FertilizerRecordInfo> fertilizerRecordInfos=fertilizerRecordInfoService.queryFertilizerByBtCodeService(queryId.substring(0, 13));
		if(fertilizerRecordInfos!=null){
			Map<String, Object> fertilizerMap=new HashMap<String, Object>();
			for(int i=0;i<fertilizerRecordInfos.size();i++){
				fertilizerMap.put("时间",new SimpleDateFormat("yyyy-MM-dd").format(fertilizerRecordInfos.get(i).getFertilizertime()));
				fertilizerMap.put("环节", "施肥");
				fertilizerMap.put("肥料名称", fertilizerRecordInfos.get(i).getFertilizername());
				fertilizerMap.put("施肥用量", fertilizerRecordInfos.get(i).getFertilizernum());
				//fertilizerMap.put("FertilizerFrequency", fertilizerRecordInfos.get(i).getFertilizerfrequency());
				fertilizerMap.put("负责人", fertilizerRecordInfos.get(i).getGrower());
				list.add(fertilizerMap);
				System.out.println("=========>施肥Controller:"+fertilizerRecordInfos.get(i).getFertilizertime());
			}
		}
		//根据queryId的前13位获取pestRecord病虫害记录
		List<PestRecordInfo> pestRecordInfos=pestRecordInfoService.queryPestByBtCodeService(queryId.substring(0,13));
		if(pestRecordInfos!=null){
			Map<String, Object> pestMap=new HashMap<String, Object>();
			for(int i=0;i<pestRecordInfos.size();i++){
				pestMap.put("时间",new SimpleDateFormat("yyyy-MM-dd").format(pestRecordInfos.get(i).getSprayTime()));
				pestMap.put("环节", "除虫");
				pestMap.put("病害类型", pestRecordInfos.get(i).getPesttype());
				pestMap.put("农药名称", pestRecordInfos.get(i).getMedicationname());
				pestMap.put("配药比例", pestRecordInfos.get(i).getMedicationratio());
				pestMap.put("药剂量", pestRecordInfos.get(i).getMedicationdosage());
				pestMap.put("治理结果", pestRecordInfos.get(i).getResult());
				pestMap.put("负责人", pestRecordInfos.get(i).getGrower());
				list.add(pestMap);
				System.out.println("==========>病虫害Controller"+pestRecordInfos.get(i).getSprayTime());
			}
		}
		//根据queryId的前17位获取采摘记录
		PickRecordInfo pickRecordInfos=pickRecordInfoService.queryPickByBtCode(queryId.substring(0,17));
		if(pickRecordInfos!=null){
			Map<String, Object> pickMap=new HashMap<String, Object>();
			pickMap.put("时间", new SimpleDateFormat("yyyy-MM-dd").format(pickRecordInfos.getPicktime()));
			pickMap.put("环节", "采摘");
			pickMap.put("收货形式", pickRecordInfos.getPicktype());
			pickMap.put("数量", pickRecordInfos.getPicknum());
			pickMap.put("采摘者", pickRecordInfos.getGrower());
			System.out.println("=========>采摘controller:"+pickRecordInfos.getPicktime());
			list.add(pickMap);
		}
		//根据queryId的前21位获取检验入库信息
		CheckInRecordInfo checkInRecordInfo=checkInRecordInfoService.queryCheckInByBtCodeService(queryId.substring(0,21));
		if(checkInRecordInfo!=null){
			Map<String, Object> checkInMap=new HashMap<String, Object>();
			checkInMap.put("时间", new SimpleDateFormat("yyyy-MM-dd").format(checkInRecordInfo.getCheckintime()));
			checkInMap.put("环节", "检验入库");
			checkInMap.put("仓库地址", checkInRecordInfo.getStocklocation());
			checkInMap.put("负责人", checkInRecordInfo.getChecker());
			System.out.println("========>检验ontroller:"+checkInRecordInfo.getCheckintime());
			list.add(checkInMap);
		}
		//根据queryId25位数据获取包装信息
		CopackRecordInfo copackRecordInfo=copackRecordInfoService.queryCopackByBtCodeService(queryId);
		if(copackRecordInfo!=null){
			Map<String, Object> copackMap=new HashMap<String, Object>();
			copackMap.put("时间", new SimpleDateFormat("yyyy-MM-dd").format(copackRecordInfo.getCopacktime()));
			copackMap.put("环节", "包装");
			copackMap.put("加工地址", copackRecordInfo.getProducelocation());
			copackMap.put("负责人", copackRecordInfo.getCopacker());
			//copackMap.put("product_btCode", copackRecordInfo.getProductBtcode());
			System.out.println("=========>包装Controller:"+copackRecordInfo.getCopacktime());
			list.add(copackMap);
		}
		//根据包装信息里得到的物流单信息查询deliverRecord得到物流记录
		DeliverRecordInfo deliverRecordInfo=deliverRecordInfoService.queryDeliverByBtCodeService(queryId);
		if(deliverRecordInfo!=null){
			Map<String, Object> deliverMap=new HashMap<String,Object>();
			deliverMap.put("时间", new SimpleDateFormat("yyyy-MM-dd").format(deliverRecordInfo.getDelivertime()));
			deliverMap.put("环节", "物流");
			deliverMap.put("分发地点", deliverRecordInfo.getDeliveraddress());
			deliverMap.put("物流公司", deliverRecordInfo.getLogisticscompany());
			deliverMap.put("负责人", deliverRecordInfo.getDistributor());
			//deliverMap.put("Logistics", deliverRecordInfo.getLogistics());
			System.out.println("===========>物流controller:"+deliverRecordInfo.getDelivertime());
			list.add(deliverMap);
		}
		//根据包装信息里得到的物流单信息查询confirmrecipientRecord得到确认收货记录
		ConfirmRecipientRecordInfo confirmRecipientRecordInfo=confirmRecipientRecordInfoService.queryConfirmByOrderNumService(queryId);
		if(confirmRecipientRecordInfo!=null){
			Map<String, Object> confirmMap=new HashMap<String,Object>();
			
			confirmMap.put("时间", new SimpleDateFormat("yyyy-MM-dd").format(confirmRecipientRecordInfo.getRecipienttime()));
			confirmMap.put("环节", "分销");
			confirmMap.put("物流单号", confirmRecipientRecordInfo.getLogisticsnum());
			confirmMap.put("分销商", confirmRecipientRecordInfo.getDistributor());
			System.out.println("=========>确认Controller:"+confirmRecipientRecordInfo.getRecipienttime());
			list.add(confirmMap);
		}
		//更新查询次数，+1
		ProductStatusInfo productStatusInfo=new ProductStatusInfo();
		productStatusInfo.setProduct_btCode(queryId);
		productStatusInfo.setQueryTimes(productStatusInfoService.queryTimesByBtCodeService(queryId)+1);
		if(productStatusInfoService.updateQueryTimesByBtCodeService(productStatusInfo)>0){
			System.out.println("更新查询次数成功");
		}else{
			System.out.println("queryTimes Fail");
		}

		model.addAttribute("Info", list);
		return model;
	}
	
	
	/*
	 *首页搜索
	 */
	@RequestMapping("checkProductBtcode.do")
	public @ResponseBody String checkProductBtcode(String productBtcode)
	{
		ProductStatusInfo productStatusInfo=new ProductStatusInfo();		
		return productStatusInfoService.checkProductBtcode(productBtcode).toString();
	}
	
}
