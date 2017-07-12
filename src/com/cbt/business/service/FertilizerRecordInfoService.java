package com.cbt.business.service;

import java.util.List;

import com.cbt.business.po.FertilizerRecordInfo;

public interface FertilizerRecordInfoService {
	
	public FertilizerRecordInfo getFertilizerRecordInfo(FertilizerRecordInfo info);
	
	
	public List<FertilizerRecordInfo> getAllFertilizerRecordInfo();
	
	public int addFertilizeRecordInfo(FertilizerRecordInfo info);
	
	public int delFertilizeRecordInfo(FertilizerRecordInfo info);
}
