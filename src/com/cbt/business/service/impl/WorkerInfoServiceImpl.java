package com.cbt.business.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cbt.business.mapper.WorkerInfoMapper;
import com.cbt.business.po.WorkerInfo;
import com.cbt.business.service.WorkerInfoService;

@Service
public class WorkerInfoServiceImpl implements WorkerInfoService{
	@Resource(name="workerInfoMapper")
	private WorkerInfoMapper workerInfoMapper;
	
	@Override
	public WorkerInfo getWorkerInfo(WorkerInfo info) {
		// TODO Auto-generated method stub
		
		return workerInfoMapper.getWorkerInfo(info);
	}

	@Override
	public List<WorkerInfo> getAllWorkerInfo() {
		// TODO Auto-generated method stub
		return workerInfoMapper.getAllWorkerInfo();
	}

	@Override
	public Boolean addWorkerInfo(WorkerInfo info) {
		// TODO Auto-generated method stub
		int i = workerInfoMapper.addWorkerInfo(info);
		if(i > 0 )
			return true;
		return false;
	}

	@Override
	public Boolean delWorkerInfo(List<WorkerInfo> list) {
		// TODO Auto-generated method stub
		Boolean mark = true;
		for(int i=0;i<list.size();i++)
		{
			int k = workerInfoMapper.delWorkerInfo(list.get(i));
			if(i<=0){
				return false;
			}
		}
		return true;
	}

	@Override
	public List<WorkerInfo> getWorkers(Integer businessId) {
		// TODO Auto-generated method stub
		return workerInfoMapper.getWorkers(businessId);
	}

	@Override
	public List<WorkerInfo> getPageWorkers(int nowpage, int rows, int businessId) {
		// TODO Auto-generated method stub
		int startrow=(nowpage-1)*rows;
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("startrow",startrow);
		map.put("rows", rows);   
		map.put("businessId", businessId);
		return workerInfoMapper.getPageWorkers(map);
	}

	@Override
	public int getWorkersCount(int businessId) {
		// TODO Auto-generated method stub
		return workerInfoMapper.getWorkersCount(businessId);
	}
	
	//query by workerId
	@Override
	public WorkerInfo queryByWorkerIdService(WorkerInfo workerInfo) throws Exception {
		return workerInfoMapper.queryByWorkerId(workerInfo);
	}
	//通过businessId查询
	@Override
	public List<WorkerInfo> queryByBusinessIdService(WorkerInfo workerInfo) throws Exception {
		return workerInfoMapper.queryByBusinessId(workerInfo);
	}
}
