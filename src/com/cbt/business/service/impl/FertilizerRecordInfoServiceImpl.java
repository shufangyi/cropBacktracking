package com.cbt.business.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cbt.business.mapper.FertilizerRecordInfoMapper;
import com.cbt.business.po.FertilizerRecordInfo;
import com.cbt.business.service.FertilizerRecordInfoService;
@Service
public class FertilizerRecordInfoServiceImpl implements FertilizerRecordInfoService {
	
	@Resource(name="fertilizerRecordInfoMapper")
	private FertilizerRecordInfoMapper fertilizeRecordInfoMapper;

	@Override
	public FertilizerRecordInfo getFertilizerRecordInfo(FertilizerRecordInfo info) {
		// TODO Auto-generated method stub
		return fertilizeRecordInfoMapper.getFertilizerRecordInfo(info);
	}

	@Override
	public List<FertilizerRecordInfo> getAllFertilizerRecordInfo() {
		// TODO Auto-generated method stub
		return fertilizeRecordInfoMapper.getAllFertilizerRecordInfo();
	}

	@Override
	public int addFertilizeRecordInfo(FertilizerRecordInfo info) {
		// TODO Auto-generated method stub
		return  fertilizeRecordInfoMapper.addFertilizerRecordInfo(info);
	}

	@Override
	public int delFertilizeRecordInfo(FertilizerRecordInfo info) {
		// TODO Auto-generated method stub
		return fertilizeRecordInfoMapper.delFertilizerRecordInfo(info);
	}

	//溯源信息查询之,施肥记录
	@Override
	public List<FertilizerRecordInfo> queryFertilizerByBtCodeService(String sowSeg_btCode) throws Exception {
		return fertilizeRecordInfoMapper.queryFertilizerByBtCode(sowSeg_btCode);
	}

}
