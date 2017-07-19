package com.cbt.business.mapper;

import java.util.List;
import java.util.Map;

import com.cbt.business.po.ConfirmRecipientRecordInfo;

public interface ConfirmRecipientRecordInfoMapper {
	
	/* 获取一条记录*/
	public ConfirmRecipientRecordInfo getConfirmRecipientRecordInfo(ConfirmRecipientRecordInfo info);
	/*获取所有记录*/
	public List<ConfirmRecipientRecordInfo> getAllConfirmRecipientRecordInfo();
	/*增加一条数据*/
	public int addConfirmRecipientRecordInfo(ConfirmRecipientRecordInfo info);
	/*删除一条数据*/
	public int delConfirmRecipientRecordInfo(ConfirmRecipientRecordInfo info);
	//溯源信息查询之，确认收货信息
	public ConfirmRecipientRecordInfo queryConfirmByOrderNum(String orderNum)throws Exception;
	//分页查询
	public List<ConfirmRecipientRecordInfo> getConfirmRecipientRecords(Map<String, Object> map)throws Exception;
	//分页查询条数
	public int getConfirmRecipientRecordsCount(Map<String, Object> map)throws Exception;
	//更新数据
	public int updateConfirmRecipientRecord(ConfirmRecipientRecordInfo confirmRecipientRecordInfo)throws Exception;
	//通过distributor查找
	public List<ConfirmRecipientRecordInfo> queryByDistributor(String distributor)throws Exception;
	
	
}
