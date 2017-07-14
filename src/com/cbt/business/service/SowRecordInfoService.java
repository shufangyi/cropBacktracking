package com.cbt.business.service;

import java.util.List;

import com.cbt.business.po.SowRecordInfo;

public interface SowRecordInfoService {
	
	public SowRecordInfo getSowRecordInfo(SowRecordInfo info);
	
	public List<SowRecordInfo> getAllSowRecordInfo();
	
	int addSowRecordInfo(SowRecordInfo info);
	
	int delSowRecordInfo(SowRecordInfo info);
	
	public SowRecordInfo getSowRecordInfoBySowSeg_btCode(String sowRecord_btCode);
	
	/*分页查询*/
	public List<SowRecordInfo> getPageSowRecords(int nowpage,int rows);
	
	/*查询记录总数*/
	
	public int getRecordsCount(String name);
	
	

}
