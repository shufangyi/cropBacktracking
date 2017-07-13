package com.cbt.business.mapper;

import java.util.List;

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
	
}
