package com.cbt.business.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cbt.business.mapper.CopackRecordInfoMapper;
import com.cbt.business.mapper.DeliverRecordInfoMapper;
import com.cbt.business.po.DeliverRecordInfo;
import com.cbt.business.service.DeliverRecordInfoService;
@Service
public class DeliverRecordInfoServiceImpl implements DeliverRecordInfoService {
	
	@Resource(name="deliverRecordInfoMapper")
	private DeliverRecordInfoMapper deliverRecordInfoMapper;
	@Resource(name="copackRecordInfoMapper")
	private CopackRecordInfoMapper copackRecordInfoMapper;

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
	//溯源信息查询之，物流信息记录
	@Override
	public DeliverRecordInfo queryDeliverByBtCodeService(String product_btCode) throws Exception {	
		return deliverRecordInfoMapper.queryDeliverByOrderNum(copackRecordInfoMapper.queryOrderNumByBtCode(product_btCode));
	
	}

}
