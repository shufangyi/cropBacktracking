package com.cbt.business.service;

import java.util.List;
import java.util.Map;

import com.cbt.business.po.ConfirmRecipientRecordInfo;

public interface ConfirmRecipientRecordInfoService {
	/*
	 * 获取一条记录
	 */
	public ConfirmRecipientRecordInfo getConfirmRecipientRecordInfo(ConfirmRecipientRecordInfo info);
	
	/*
	 * 获取所有记录
	 */
	public List<ConfirmRecipientRecordInfo> getAllConfirmRecipientRecordInfo();
	
	public int addConfirmRecipientRecordInfo(ConfirmRecipientRecordInfo info);
	
	public int delConfirmRecipientRecordInfo(ConfirmRecipientRecordInfo info);
	//查询溯源信息之，确认收货信息
	public ConfirmRecipientRecordInfo queryConfirmByOrderNumService(String product_btCode)throws Exception;
	//分页查询
	public List<ConfirmRecipientRecordInfo> getConfirmRecipientRecordsService(Map<String, Object> map)throws Exception;
	//分页查询条数
	public int getConfirmRecipientRecordsCountService(Map<String, Object> map)throws Exception;
	//更新数据
	public int updateConfirmRecipientRecordService(ConfirmRecipientRecordInfo confirmRecipientRecordInfo)throws Exception;
	//通过distributor查找
	public List<ConfirmRecipientRecordInfo> queryByDistributorService(String distributor)throws Exception;
	//循环删除
	public String deleteConfirmRecipientRecords(List<ConfirmRecipientRecordInfo> list)throws Exception;
}
