package com.cbt.business.service;

import java.util.List;
import java.util.Map;

import com.cbt.business.po.CheckInRecordInfo;

public interface CheckInRecordInfoService {
	//条件查询，返回一条记录
		public CheckInRecordInfo getCheckInRecordInfo(CheckInRecordInfo info);
		//返回所有记录
		public List<CheckInRecordInfo> getAllCheckInRecordInfo();
		/*增加一条数据*/
		public int addCheckInRecordInfo(CheckInRecordInfo info);
		/*删除一条数据*/
		public int delCheckInRecordInfo(CheckInRecordInfo info);	
		//溯源信息查询之，质检入库记录
		public CheckInRecordInfo queryCheckInByBtCodeService(String checkInSeg_btCode)throws Exception;
		//分页查询
		public List<CheckInRecordInfo> getCheckInRecordByPaginationService(Map<String, Object> map)throws Exception;
		//更新数据
		public int updateCheckInRecordService(CheckInRecordInfo checkInRecordInfo)throws Exception;
		//获取分页数据总数
		public int getPaginationCountService(Map<String, Object> map)throws Exception;
		//循环删除
		public String delCheckInRecords(List<CheckInRecordInfo> list)throws Exception;
}
