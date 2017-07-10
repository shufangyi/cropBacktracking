package com.cbt.business.service.impl;

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
}
