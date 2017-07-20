package com.cbt.business.mapper;

import java.util.List;
import java.util.Map;

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
	
	
	//2017-07-18
	/*根据businessId查询所有的数据*/
	public List<WorkerInfo> getWorkers(Integer businessId);
	
	
	public List<WorkerInfo> getPageWorkers(Map<String,Object> map);
	
	public int getWorkersCount(Integer BusinessId);
	
	//query by workerId
	public WorkerInfo queryByWorkerId(WorkerInfo workerInfo)throws Exception;
	//query by businessId
	public List<WorkerInfo> queryByBusinessId(WorkerInfo workerInfo)throws Exception;
	
}
