package com.cbt.business.mapper;

import java.util.List;

import com.cbt.business.po.PestRecordInfo;

public interface PestRecordInfoMapper {
	public PestRecordInfo getPestRecordinfo(PestRecordInfo info);
	
	
	public List<PestRecordInfo> getAllPestRecordinfo();
	
	
	public int addPestRecordInfo(PestRecordInfo info);
	
	public int delPestRecordInfo(PestRecordInfo info);
}
