package com.cbt.business.mapper;

import java.util.List;

import com.cbt.business.po.SowRecordInfo;

public interface SowRecordInfoMapper
{
	public SowRecordInfo getSowRecordInfo(SowRecordInfo info);
	
	public List<SowRecordInfo> getAllSowRecordInfo();
	
	public int addSowRecordInfo(SowRecordInfo info);
	
	public int delSowRecordInfo(SowRecordInfo info);
	
}
