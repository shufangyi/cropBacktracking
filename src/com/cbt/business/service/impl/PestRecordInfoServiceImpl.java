package com.cbt.business.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cbt.business.mapper.PestRecordInfoMapper;
import com.cbt.business.po.PestRecordInfo;
import com.cbt.business.service.PestRecordInfoService;

@Service
public class PestRecordInfoServiceImpl implements PestRecordInfoService {
	
	@Resource(name="pestRecordInfoMapper")
	private PestRecordInfoMapper pestRecordInfoMapper;

	@Override
	public PestRecordInfo getPestRecordinfo(PestRecordInfo info) {
		// TODO Auto-generated method stub
		return pestRecordInfoMapper.getPestRecordinfo(info);
	}

	@Override
	public List<PestRecordInfo> getAllPestRecordinfo() {
		// TODO Auto-generated method stub
		return pestRecordInfoMapper.getAllPestRecordinfo();
	}

	@Override
	public int addPestRecordInfo(PestRecordInfo info) {
		// TODO Auto-generated method stub
		return pestRecordInfoMapper.addPestRecordInfo(info);
	}

	@Override
	public int delPestRecordInfo(PestRecordInfo info) {
		// TODO Auto-generated method stub
		return pestRecordInfoMapper.delPestRecordInfo(info);
	}
	//溯源信息查询之，病虫害记录
	@Override
	public List<PestRecordInfo> queryPestByBtCodeService(String sowSeg_btCode) throws Exception {
		return pestRecordInfoMapper.queryPestByBtCode(sowSeg_btCode);
	}

}
