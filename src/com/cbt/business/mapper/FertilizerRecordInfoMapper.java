package com.cbt.business.mapper;

import java.util.List;
import java.util.Map;

import com.cbt.business.po.FertilizerRecordInfo;

public interface FertilizerRecordInfoMapper {
	/*查询一条数据*/
	public FertilizerRecordInfo getFertilizerRecordInfo(FertilizerRecordInfo info);
	/*查询所有数据*/
	public List<FertilizerRecordInfo> getAllFertilizerRecordInfo();
	/*增加一条数据*/
	public int addFertilizerRecordInfo(FertilizerRecordInfo info);
	/*删除一条数据*/
	public int delFertilizerRecordInfo(FertilizerRecordInfo info);
	
	//溯源信息查询，施肥记录
	public List<FertilizerRecordInfo> queryFertilizerByBtCode(String sowSeg_btCode)throws Exception;
	//分页查询
	public List<FertilizerRecordInfo> getFertilizerRecord(Map<String, Object> map)throws Exception;
	//update
	public int updateFertilizerBySowBtCode(FertilizerRecordInfo fertilizerRecordInfo)throws Exception;
	//get total count
	public int getFertilizerRecordCount(Map<String, Object> map)throws Exception;
	
	
}
