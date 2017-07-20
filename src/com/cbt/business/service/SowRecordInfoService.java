package com.cbt.business.service;

import java.util.List;

import com.cbt.business.po.SowRecordInfo;

public interface SowRecordInfoService {
	
	public SowRecordInfo getSowRecordInfo(SowRecordInfo info);
	
	public List<SowRecordInfo> getAllSowRecordInfo();
	
	int addSowRecordInfo(SowRecordInfo info);
	
	Boolean delSowRecordInfo(List<SowRecordInfo> list);
	
	public SowRecordInfo getSowRecordInfoBySowSeg_btCode(String sowRecord_btCode);
	
	//2017 - 7 -15
	
	/*分页查询*/
	public List<SowRecordInfo> getPageSowRecords(int nowpage,int rows,String project_btCode,String searchKey);
	
	/*查询记录总数*/
	public int getRecordsCount(int nowpage,int rows,String project_btCode,String searchKey);
	
	/*修改数据 */
	Boolean updateSowRecord(SowRecordInfo info);
	
	public SowRecordInfo queryByProjectBtCodeService(String projectBtcode)throws Exception;
	
	

}
