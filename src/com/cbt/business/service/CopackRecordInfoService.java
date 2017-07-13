package com.cbt.business.service;

import java.util.List;

import com.cbt.business.mapper.CopackRecordInfoMapper;
import com.cbt.business.po.CopackRecordInfo;

public interface CopackRecordInfoService {
	public CopackRecordInfo getCopackRecordInfo(CopackRecordInfo info);
	
	public List<CopackRecordInfo> getAllCopackRecordInfo();
	
	public int addCopackRecordInfo(CopackRecordInfo info);
	
	public int delCopackRecordInfo(CopackRecordInfo info);
	//溯源信息查询之，包装信息记录
	public CopackRecordInfo queryCopackByBtCodeService(String product_btCode)throws Exception;
}
