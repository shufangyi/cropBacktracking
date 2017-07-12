package com.cbt.business.mapper;

import java.util.List;

import com.cbt.business.po.CheckInRecordInfo;

public interface CheckInRecordInfoMapper
{
	//条件查询，返回一条记录
	public CheckInRecordInfo getCheckInRecordInfo(CheckInRecordInfo info);
	//返回所有记录
	public List<CheckInRecordInfo> getAllCheckInRecordInfo();
	/*增加一条数据*/
	public int addCheckInRecordInfo(CheckInRecordInfo info);
	/*删除一条数据*/
	public int delCheckInRecordInfo(CheckInRecordInfo info);
}
