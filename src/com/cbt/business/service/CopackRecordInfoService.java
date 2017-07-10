package com.cbt.business.service;

import java.util.List;

import com.cbt.business.mapper.CopackRecordInfoMapper;
import com.cbt.business.po.CopackRecordInfo;

public interface CopackRecordInfoService {
	public CopackRecordInfo getCopackRecordInfo(CopackRecordInfo info);
	
	public List<CopackRecordInfoMapper> getAllCopackRecordInfo();
	
	public int addCopackRecordInfo(CopackRecordInfo info);
	
	public int delCopackRecordInfo(CopackRecordInfo info);
}
