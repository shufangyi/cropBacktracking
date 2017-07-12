package com.cbt.business.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cbt.business.mapper.PickRecordInfoMapper;
import com.cbt.business.po.PickRecordInfo;
import com.cbt.business.service.PickRecordInfoService;
@Service

public class PickRecordInfoServiceImpl implements PickRecordInfoService {

	@Resource(name="pickRecordInfoMapper")
	private PickRecordInfoMapper pickRecordInfoMapper;
	@Override
	public PickRecordInfo getPickRecordInfo(PickRecordInfo info) {
		// TODO Auto-generated method stub
		return pickRecordInfoMapper.getPickRecordInfo(info);
	}

	@Override
	public List<PickRecordInfo> getAllPickRecordInfo() {
		// TODO Auto-generated method stub
		return pickRecordInfoMapper.getAllPickRecordInfo();
	}

	@Override
	public int addPickRecordInfo(PickRecordInfo info) {
		// TODO Auto-generated method stub
		return pickRecordInfoMapper.addPickRecordInfo(info);
	}

	@Override
	public int delPickRecordInfo(PickRecordInfo info) {
		// TODO Auto-generated method stub
		return pickRecordInfoMapper.delPickRecordInfo(info);
	}

}
