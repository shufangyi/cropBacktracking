package com.cbt.business.mapper;

import java.util.List;

import com.cbt.business.po.FertilizeRecordInfo;

public interface FertilizeRecordInfoMapper {
	public FertilizeRecordInfo getFertilizerRecordInfo(FertilizeRecordInfo info);
	
	
	public List<FertilizeRecordInfo> getAllFertilizerRecordInfo();
	
	public int addFertilizeRecordInfo(FertilizeRecordInfo info);
	
	public int delFertilizeRecordInfo(FertilizeRecordInfo info);
}
