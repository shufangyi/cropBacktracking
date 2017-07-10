package com.cbt.business.service;

import java.util.List;

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
}
