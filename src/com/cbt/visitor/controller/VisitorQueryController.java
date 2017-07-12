package com.cbt.visitor.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cbt.business.po.CopackRecordInfo;
import com.cbt.business.po.SowRecordInfo;
import com.cbt.business.service.SowRecordInfoService;

@Controller
@RequestMapping("/visitor/")
public class VisitorQueryController 
{
	
	@Resource(name="sowRecordInfoServiceImpl")
	private SowRecordInfoService sowRecordInfoService;
	
	@RequestMapping("getWholeInfo.do")
	public @ResponseBody ModelMap getWholeInfo(String queryId)
	{
		if(queryId.length()!=25)
			return null;
		ModelMap model = new ModelMap();
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		
		//根据queryId的钱13位可以获取sowrecord包装记录
		SowRecordInfo sowRecordInfo = sowRecordInfoService.getSowRecordInfoBySowSeg_btCode(queryId.substring(0, 13));
		if(sowRecordInfo!=null)
		{
			Map<String,Object> map = new HashMap<String,Object>();
			System.out.println(sowRecordInfo.toString());
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
		}
		//根据queryId的钱13位可以获取fertilizerrecord包装记录
		
		
		//根据queryId的前13位获取pestRecord病虫害记录
		
		
		
		//根据queryId的前17位获取采摘记录
		
		
		//根据queryId的前21位获取检验入库信息
		
		
		//根据queryId25位数据获取包装信息
		
		
		//根据包装信息里得到的物流单信息查询deliverRecord得到物流记录
		
		
		//根据包装信息里得到的物流单信息查询confirmrecipientRecord得到物流记录
		
		
		
		
		
		
		model.addAttribute("Info", list);
		return model;
	}
	
	
}
