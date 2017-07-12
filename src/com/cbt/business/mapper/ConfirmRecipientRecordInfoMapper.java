package com.cbt.business.mapper;

import java.util.List;

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
}
