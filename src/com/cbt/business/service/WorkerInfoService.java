package com.cbt.business.service;

import java.util.List;

import com.cbt.business.po.WorkerInfo;

public interface WorkerInfoService
{
	/*查询一条数据*/
	public WorkerInfo getWorkerInfo(WorkerInfo info);
	/*查询所有数据*/
	public List<WorkerInfo> getAllWorkerInfo();
	/*增加一条数据*/
	public Boolean addWorkerInfo(WorkerInfo info);
	/*删除一条数据*/
	public Boolean delWorkerInfo(List<WorkerInfo> list);
	
	/*bisinessId查询*/
	public List<WorkerInfo> getWorkers(Integer businessId);
	
	public List<WorkerInfo> getPageWorkers(int nowpage, int rows,int businessId);
	
	public int getWorkersCount(int businessId);
	
	//query by workerId
	public WorkerInfo queryByWorkerIdService(WorkerInfo workerInfo)throws Exception;
	
	public List<WorkerInfo> queryByBusinessIdService(WorkerInfo workerInfo)throws Exception;
	
	public Boolean updateWorkerPwd(WorkerInfo info);
}
