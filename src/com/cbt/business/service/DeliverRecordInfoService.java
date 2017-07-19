package com.cbt.business.service;

import java.util.List;
import java.util.Map;

import com.cbt.business.po.DeliverRecordInfo;

public interface DeliverRecordInfoService {
	
	public DeliverRecordInfo getDeliverRecordInfo(DeliverRecordInfo info);
	
	
	public List<DeliverRecordInfo> getAllDeliverRecordInfo();
	
	
	public int addDeliverRecordInfo(DeliverRecordInfo info);
	
	public int delDeliverRecordInfo(DeliverRecordInfo info);
	
	//溯源信息查询之，物流信息
	public DeliverRecordInfo queryDeliverByBtCodeService(String product_btCode)throws Exception;
	
	//分页查询
	public List<DeliverRecordInfo> getDeliverRecordsService(Map<String, Object> map)throws Exception;
	//get pagination count
	public int getDeliverRecordsCountService(Map<String, Object> map)throws Exception;
	//更新
	public int updateDeliverRecordService(DeliverRecordInfo deliverRecordInfo)throws Exception;
	//循环删除
	public String deleteDeliverRecords(List<DeliverRecordInfo> list)throws Exception;
	//通过负责人账号查找
	public List<DeliverRecordInfo> queryByLogisticsService(String logistics)throws Exception;
}
