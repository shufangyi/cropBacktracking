package com.cbt.business.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cbt.business.mapper.DeliverRecordInfoMapper;
import com.cbt.business.po.DeliverRecordInfo;
import com.cbt.business.service.DeliverRecordInfoService;
@Service
public class DeliverRecordInfoServiceImpl implements DeliverRecordInfoService {
	
	@Resource(name="deliverRecordInfoMapper")
	private DeliverRecordInfoMapper deliverRecordInfoMapper;

	@Override
	public DeliverRecordInfo getDeliverRecordInfo(DeliverRecordInfo info) {
		// TODO Auto-generated method stub
		return deliverRecordInfoMapper.getDeliverRecordInfo(info);
	}

	@Override
	public List<DeliverRecordInfo> getAllDeliverRecordInfo() {
		// TODO Auto-generated method stub
		return deliverRecordInfoMapper.getAllDeliverRecordInfo();
	}

	@Override
	public int addDeliverRecordInfo(DeliverRecordInfo info) {
		// TODO Auto-generated method stub
		return  deliverRecordInfoMapper.addDeliverRecordInfo(info);
	}

	@Override
	public int delDeliverRecordInfo(DeliverRecordInfo info) {
		// TODO Auto-generated method stub
		return deliverRecordInfoMapper.delDeliverRecordInfo(info);
	}

}
