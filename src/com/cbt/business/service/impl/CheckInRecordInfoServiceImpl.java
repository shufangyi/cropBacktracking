package com.cbt.business.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cbt.business.mapper.CheckInRecordInfoMapper;
import com.cbt.business.po.CheckInRecordInfo;
import com.cbt.business.service.CheckInRecordInfoService;

@Service
public class CheckInRecordInfoServiceImpl implements  CheckInRecordInfoService{
	
	@Resource(name="checkInRecordInfoMapper")
	private CheckInRecordInfoMapper checkInRecordInfoMapper;

	@Override
	public CheckInRecordInfo getCheckInRecordInfo(CheckInRecordInfo info) {
		// TODO Auto-generated method stub
		return checkInRecordInfoMapper.getCheckInRecordInfo(info);
	}

	@Override
	public List<CheckInRecordInfo> getAllCheckInRecordInfo() {
		// TODO Auto-generated method stub
		return checkInRecordInfoMapper.getAllCheckInRecordInfo();
	}

	@Override
	public int addCheckInRecordInfo(CheckInRecordInfo info) {
		// TODO Auto-generated method stub
		return checkInRecordInfoMapper.addCheckInRecordInfo(info);
	}

	@Override
	public int delCheckInRecordInfo(CheckInRecordInfo info) {
		// TODO Auto-generated method stub
		return  checkInRecordInfoMapper.delCheckInRecordInfo(info);
	}
	//溯源信息查询之，质检入库记录
	@Override
	public CheckInRecordInfo queryCheckInByBtCodeService(String checkInSeg_btCode) throws Exception {
		return checkInRecordInfoMapper.queryCheckInByBtCode(checkInSeg_btCode);
	}

}
