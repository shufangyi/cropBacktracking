package com.cbt.business.service;

import java.util.List;
import java.util.Map;

import com.cbt.business.po.PickRecordInfo;

public interface PickRecordInfoService {
	
	public PickRecordInfo getPickRecordInfo(PickRecordInfo info);

	
	public List<PickRecordInfo> getAllPickRecordInfo();
	
	public int addPickRecordInfo(PickRecordInfo info);
	
	public int delPickRecordInfo(PickRecordInfo info);
	
	//溯源信息查询之，采摘记录 
	public PickRecordInfo queryPickByBtCode(String pickSeg_btCode)throws Exception;
	//更新采摘信息
	public int updatePickRecordService(PickRecordInfo pickRecordInfo)throws Exception;
	//分页查询
	public List<PickRecordInfo> queryPickRecordsService(String sowsegBtcode,int nowpage,int rows,String searchKey)throws Exception;
	//list循环删除
	public boolean delPickRecordByListService(List<PickRecordInfo> list)throws Exception;
	//get total count
	public int getPickRecordCountService(String sowsegBtcode,int nowpage,int rows,String searchKey)throws Exception;
}
