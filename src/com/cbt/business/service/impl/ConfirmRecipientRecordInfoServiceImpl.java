package com.cbt.business.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cbt.business.mapper.ConfirmRecipientRecordInfoMapper;
import com.cbt.business.po.ConfirmRecipientRecordInfo;
import com.cbt.business.service.ConfirmRecipientRecordInfoService;
@Service
public class ConfirmRecipientRecordInfoServiceImpl implements ConfirmRecipientRecordInfoService {
	
	@Resource(name="confirmRecipientRecordInfoMapper")
	private ConfirmRecipientRecordInfoMapper confirmRecipientRecordInfoMapper;
	
	@Override
	public ConfirmRecipientRecordInfo getConfirmRecipientRecordInfo(ConfirmRecipientRecordInfo info) {
		// TODO Auto-generated method stub
		return confirmRecipientRecordInfoMapper.getConfirmRecipientRecordInfo(info);
	}

	@Override
	public List<ConfirmRecipientRecordInfo> getAllConfirmRecipientRecordInfo() {
		// TODO Auto-generated method stub
		return confirmRecipientRecordInfoMapper.getAllConfirmRecipientRecordInfo();
	}

	@Override
	public int addConfirmRecipientRecordInfo(ConfirmRecipientRecordInfo info) {
		// TODO Auto-generated method stub
		return confirmRecipientRecordInfoMapper.addConfirmRecipientRecordInfo(info);
	}

	@Override
	public int delConfirmRecipientRecordInfo(ConfirmRecipientRecordInfo info) {
		// TODO Auto-generated method stub
		return confirmRecipientRecordInfoMapper.delConfirmRecipientRecordInfo(info);
	}

}
