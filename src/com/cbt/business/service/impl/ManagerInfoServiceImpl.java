package com.cbt.business.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cbt.business.mapper.ManagerInfoMapper;
import com.cbt.business.service.ManagerInfoService;
import com.cbt.system.po.ManagerInfo;

@Service
public class ManagerInfoServiceImpl implements ManagerInfoService{

	@Resource(name="managerInfoMapper")
	private ManagerInfoMapper managerInfoMapper;
	@Override
	public ManagerInfo getManagerInfo(ManagerInfo info) {
		// TODO Auto-generated method stub
		return managerInfoMapper.getManagerInfo(info);
	}

	@Override
	public List<ManagerInfo> getAllManagerInfo() {
		// TODO Auto-generated method stub
		return managerInfoMapper.getAllManagerInfo();
	}

	@Override
	public int addManagerInfo(ManagerInfo info) {
		// TODO Auto-generated method stub
		return managerInfoMapper.addManagerInfo(info);
	}

	@Override
	public int delManagerInfo(ManagerInfo info) {
		// TODO Auto-generated method stub
		return managerInfoMapper.delManagerInfo(info);
	}

}
