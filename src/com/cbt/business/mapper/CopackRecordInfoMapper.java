package com.cbt.business.mapper;

import java.util.List;

import com.cbt.business.po.CopackRecordInfo;

public interface CopackRecordInfoMapper {
	public CopackRecordInfo getCopackRecordInfo(CopackRecordInfo info);
	
	public List<CopackRecordInfoMapper> getAllCopackRecordInfo();
	
	public int addCopackRecordInfo(CopackRecordInfo info);
	
	public int delCopackRecordInfo(CopackRecordInfo info);
}
