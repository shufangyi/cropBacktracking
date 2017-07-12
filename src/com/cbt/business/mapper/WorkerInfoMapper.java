package com.cbt.business.mapper;

import java.util.List;

import com.cbt.business.po.WorkerInfo;

public interface WorkerInfoMapper 
{
	/*查询一条数据*/
	public WorkerInfo getWorkerInfo(WorkerInfo info);
	/*查询所有数据*/
	public List<WorkerInfo> getAllWorkerInfo();
	/*增加一条数据*/
	public int addWorkerInfo(WorkerInfo info);
	/*删除一条数据*/
	public int delWorkerInfo(WorkerInfo info);
}
