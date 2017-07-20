package com.cbt.business.service;

import java.util.List;

import com.cbt.business.po.PestRecordInfo;

public interface PestRecordInfoService {
	public PestRecordInfo getPestRecordinfo(PestRecordInfo info);
	
	public List<PestRecordInfo> getAllPestRecordinfo();

	public int addPestRecordInfo(PestRecordInfo info);
	
	public int delPestRecordInfo(PestRecordInfo info);
	
	//溯源信息查询之，病虫害记录
	public List<PestRecordInfo> queryPestByBtCodeService(String sowSeg_btCode)throws Exception;
	//分页查询
	public List<PestRecordInfo> getPestRecordsService(String projectBtcode,int nowpage,int rows,String searchKey)throws Exception;
	//循环删除
	public String delPestRecordInfoService(List<PestRecordInfo> list)throws Exception;
	//update a record
	public int updatePestRecordInfoService(PestRecordInfo pestRecordInfo)throws Exception;
	//get total count
	public int getCountService(String projectBtcode,int nowpage,int rows,String searchKey)throws Exception;

}
