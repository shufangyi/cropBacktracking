package com.cbt.business.mapper;

import java.util.List;
import java.util.Map;

import com.cbt.business.po.SowRecordInfo;

public interface SowRecordInfoMapper
{
	/*查询一条数据*/
	public SowRecordInfo getSowRecordInfo(SowRecordInfo info);
	/*查询所有数据*/
	public List<SowRecordInfo> getAllSowRecordInfo();
	/*增加一条数据*/
	public int addSowRecordInfo(SowRecordInfo info);
	/*删除一条数据 */
	public int delSowRecordInfo(SowRecordInfo info);
	
	
	//2017 - 7 -15 
	/*分页查询*/
	public List<SowRecordInfo> getPageSowRecords(Map<String,Object> map);
	/*分页记录*/
	public int getRecordsCount(Map<String,Object> map);	
	// 根据Product_btCode查询一条数据
	public SowRecordInfo getSowRecordInfoBySowSeg_btCode(String sowSeg_btCode);
	//修改数据
	public int updateSowRecord(SowRecordInfo info);
	
	public SowRecordInfo queryByProjectBtCode(String projectBtcode)throws Exception;
	
	/*超级用户分页查询*/
	public List<SowRecordInfo> getMPageSowRecords(Map<String,Object> map);
	/*超级用户分页记录*/
	public int getMRecordsCount(Map<String,Object> map);	
	
}
