package com.cbt.business.mapper;

import java.util.List;
import java.util.Map;

import com.cbt.business.po.PickRecordInfo;

public interface PickRecordInfoMapper {
	/*查询一条数据*/
	public PickRecordInfo getPickRecordInfo(PickRecordInfo info);
	/*查询所有数据*/
	public List<PickRecordInfo> getAllPickRecordInfo();
	/*增加一条数据*/
	public int addPickRecordInfo(PickRecordInfo info);
	/*删除一条数据*/
	public int delPickRecordInfo(PickRecordInfo info);
	//溯源信息查询之，采摘记录 
	public PickRecordInfo queryPickByBtCode(String pickSeg_btCode)throws Exception;
	//更新采摘信息
	public int updatePickRecord(PickRecordInfo pickRecordInfo)throws Exception;
	//分页查询
	public List<PickRecordInfo> queryPickRecords(Map<String, Object> map)throws Exception;
	//
	public int getPickRecordCount(Map<String, Object> map)throws Exception;
}
