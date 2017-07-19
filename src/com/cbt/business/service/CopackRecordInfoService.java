package com.cbt.business.service;

import java.util.List;
import java.util.Map;

import com.cbt.business.mapper.CopackRecordInfoMapper;
import com.cbt.business.po.CopackRecordInfo;

public interface CopackRecordInfoService {
	public CopackRecordInfo getCopackRecordInfo(CopackRecordInfo info);
	
	public List<CopackRecordInfo> getAllCopackRecordInfo();
	
	public int addCopackRecordInfo(CopackRecordInfo info);
	
	public int delCopackRecordInfo(CopackRecordInfo info);
	//溯源信息查询之，包装信息记录
	public CopackRecordInfo queryCopackByBtCodeService(String product_btCode)throws Exception;
	//分页查询
	public List<CopackRecordInfo> getCopackRecordsService(Map<String, Object> map)throws Exception;
	//get pagination count
	public int getCopackRecordsCountService(Map<String, Object> map)throws Exception;
	//更新数据
	public int updateCopackRecordService(CopackRecordInfo copackRecordInfo)throws Exception;
	//循环删除数据
	public String delCopackRecordsService(List<CopackRecordInfo> list)throws Exception;
}
