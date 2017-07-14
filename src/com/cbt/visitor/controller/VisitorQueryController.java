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
			map.put("Time", sowTime);
			map.put("Name", sowName);
			map.put("SeedSource", sowRecordInfo.getSeedsource());
			map.put("SowLocation", sowRecordInfo.getSowlocation());
			map.put("Grower", sowRecordInfo.getGrower());			
			list.add(map);
			//map.clear();
		}
		//根据queryId的前13位可以获取fertilizerRecord包装记录
		List<FertilizerRecordInfo> fertilizerRecordInfos=fertilizerRecordInfoService.queryFertilizerByBtCodeService(queryId.substring(0, 13));
		if(fertilizerRecordInfos!=null){
			Map<String, Object> fertilizerMap=new HashMap<String, Object>();
			for(int i=0;i<fertilizerRecordInfos.size();i++){
				fertilizerMap.put("Time",new SimpleDateFormat("yyyy-mm-dd").format(fertilizerRecordInfos.get(i).getFertilizertime()));
				fertilizerMap.put("Name", "施肥");
				fertilizerMap.put("FertilizerName", fertilizerRecordInfos.get(i).getFertilizername());
				fertilizerMap.put("FertilizerNum", fertilizerRecordInfos.get(i).getFertilizernum());
				fertilizerMap.put("FertilizerFrequency", fertilizerRecordInfos.get(i).getFertilizerfrequency());
				fertilizerMap.put("grower", fertilizerRecordInfos.get(i).getGrower());
				list.add(fertilizerMap);
				System.out.println("=========>施肥Controller:"+fertilizerRecordInfos.get(i).getFertilizertime());
			}
		}
		//根据queryId的前13位获取pestRecord病虫害记录
		List<PestRecordInfo> pestRecordInfos=pestRecordInfoService.queryPestByBtCodeService(queryId.substring(0,13));
		if(pestRecordInfos!=null){
			Map<String, Object> pestMap=new HashMap<String, Object>();
			for(int i=0;i<pestRecordInfos.size();i++){
				pestMap.put("Time",new SimpleDateFormat("yyyy-mm-dd").format(pestRecordInfos.get(i).getSprayTime()));
				pestMap.put("Name", "除虫");
				pestMap.put("MedicationName", pestRecordInfos.get(i).getMedicationname());
				pestMap.put("MedicationRatio", pestRecordInfos.get(i).getMedicationratio());
				pestMap.put("MedicationDosage", pestRecordInfos.get(i).getMedicationdosage());
				pestMap.put("result", pestRecordInfos.get(i).getResult());
				pestMap.put("grower", pestRecordInfos.get(i).getGrower());
				list.add(pestMap);
				System.out.println("==========>病虫害Controller"+pestRecordInfos.get(i).getSprayTime());
			}
		}
		//根据queryId的前17位获取采摘记录
		PickRecordInfo pickRecordInfos=pickRecordInfoService.queryPickByBtCode(queryId.substring(0,17));
		if(pickRecordInfos!=null){
			Map<String, Object> pickMap=new HashMap<String, Object>();
			pickMap.put("Time", new SimpleDateFormat("yyyy-mm-dd").format(pickRecordInfos.getPicktime()));
			pickMap.put("Name", "采摘");
			pickMap.put("PickType", pickRecordInfos.getPicktype());
			pickMap.put("PickNum", pickRecordInfos.getPicknum());
			pickMap.put("grower", pickRecordInfos.getGrower());
			System.out.println("=========>采摘controller:"+pickRecordInfos.getPicktime());
			list.add(pickMap);
		}
		//根据queryId的前21位获取检验入库信息
		CheckInRecordInfo checkInRecordInfo=checkInRecordInfoService.queryCheckInByBtCodeService(queryId.substring(0,21));
		if(checkInRecordInfo!=null){
			Map<String, Object> checkInMap=new HashMap<String, Object>();
			checkInMap.put("Time", new SimpleDateFormat("yyyy-mm-dd").format(checkInRecordInfo.getCheckintime()));
			checkInMap.put("Name", "质量检查");
			checkInMap.put("StockLocation", checkInRecordInfo.getStocklocation());
			checkInMap.put("Checker", checkInRecordInfo.getChecker());
			System.out.println("========>检验ontroller:"+checkInRecordInfo.getCheckintime());
			list.add(checkInMap);
		}
		//根据queryId25位数据获取包装信息
		CopackRecordInfo copackRecordInfo=copackRecordInfoService.queryCopackByBtCodeService(queryId);
		if(copackRecordInfo!=null){
			Map<String, Object> copackMap=new HashMap<String, Object>();
			copackMap.put("Time", new SimpleDateFormat("yyyy-mm-dd").format(copackRecordInfo.getCopacktime()));
			copackMap.put("Name", "包装");
			copackMap.put("copackLocation", copackRecordInfo.getProducelocation());
			copackMap.put("copacker", copackRecordInfo.getCopacker());
			copackMap.put("product_btCode", copackRecordInfo.getProductBtcode());
			System.out.println("=========>包装Controller:"+copackRecordInfo.getCopacktime());
			list.add(copackMap);
		}
		//根据包装信息里得到的物流单信息查询deliverRecord得到物流记录
		DeliverRecordInfo deliverRecordInfo=deliverRecordInfoService.queryDeliverByBtCodeService(queryId);
		if(deliverRecordInfo!=null){
			Map<String, Object> deliverMap=new HashMap<String,Object>();
			deliverMap.put("Time", new SimpleDateFormat("yyyy-mm-dd").format(deliverRecordInfo.getDelivertime()));
			deliverMap.put("Name", "物流");
			deliverMap.put("deliverAddress", deliverRecordInfo.getDeliveraddress());
			deliverMap.put("LogisticsCompany", deliverRecordInfo.getLogisticscompany());
			deliverMap.put("Distributor", deliverRecordInfo.getDistributor());
			deliverMap.put("Logistics", deliverRecordInfo.getLogistics());
			System.out.println("===========>物流controller:"+deliverRecordInfo.getDelivertime());
			list.add(deliverMap);
		}
		//根据包装信息里得到的物流单信息查询confirmrecipientRecord得到确认收货记录
		ConfirmRecipientRecordInfo confirmRecipientRecordInfo=confirmRecipientRecordInfoService.queryConfirmByOrderNumService(queryId);
		if(confirmRecipientRecordInfo!=null){
			Map<String, Object> confirmMap=new HashMap<String,Object>();
			
			confirmMap.put("Time", new SimpleDateFormat("yyyy-mm-dd").format(confirmRecipientRecordInfo.getRecipienttime()));
			confirmMap.put("Name", "分销");
			confirmMap.put("LogisticsNum", confirmRecipientRecordInfo.getLogisticsnum());
			confirmMap.put("distributor", confirmRecipientRecordInfo.getDistributor());
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
	
	
}
