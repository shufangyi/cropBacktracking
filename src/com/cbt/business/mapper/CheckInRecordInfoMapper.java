package com.cbt.business.mapper;

import java.util.List;
import java.util.Map;

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
	//溯源信息查询之，质检入库记录
	public CheckInRecordInfo queryCheckInByBtCode(String checkInSeg_btCode)throws Exception;
	//分页查询
	public List<CheckInRecordInfo> getCheckInRecordByPagination(Map<String, Object> map)throws Exception;
	//更新数据
	public int updateCheckInRecord(CheckInRecordInfo checkInRecordInfo)throws Exception;
	//获取分页数据总数
	public int getPaginationCount(Map<String, Object> map)throws Exception;
	
	//分页查询
	public List<CheckInRecordInfo> getMCheckInRecordByPagination(Map<String, Object> map)throws Exception;
	//获取分页数据总数
	public int getMPaginationCount(Map<String, Object> map)throws Exception;
}
