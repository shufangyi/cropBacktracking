package com.cbt.business.service;

import java.util.List;

import com.cbt.business.po.FertilizerRecordInfo;

public interface FertilizerRecordInfoService {
	
	public FertilizerRecordInfo getFertilizerRecordInfo(FertilizerRecordInfo info);
	
	
	public List<FertilizerRecordInfo> getAllFertilizerRecordInfo();
	
	public int addFertilizeRecordInfo(FertilizerRecordInfo info);
	
	public int delFertilizeRecordInfo(FertilizerRecordInfo info);
	
	//溯源信息查询，施肥记录
	public List<FertilizerRecordInfo> queryFertilizerByBtCodeService(String sowSeg_btCode)throws Exception;
	
}
