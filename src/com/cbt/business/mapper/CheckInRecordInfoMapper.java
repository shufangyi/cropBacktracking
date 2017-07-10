package com.cbt.business.mapper;

import java.util.List;

import com.cbt.business.po.CheckInRecordInfo;

public interface CheckInRecordInfoMapper
{
	//条件查询，返回一条记录
	public CheckInRecordInfo getWorkerInfo(CheckInRecordInfo info);
	
	//返回所有记录
	public List<CheckInRecordInfo> getAllWorkerInfo();
	
	
	public int addCheckInRecordInfo(CheckInRecordInfo info);
	
	public int delCheckInRecordInfo(CheckInRecordInfo info);
}
