package com.cbt.business.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cbt.business.mapper.SowRecordInfoMapper;
import com.cbt.business.po.SowRecordInfo;
import com.cbt.business.service.SowRecordInfoService;

@Service
public class SowRecordInfoServiceImpl implements SowRecordInfoService
{
	@Resource(name="sowRecordInfoMapper")
	private SowRecordInfoMapper sowRecordInfoMapper;

	@Override
	public SowRecordInfo getSowRecordInfo(SowRecordInfo info) {
		// TODO Auto-generated method stub
		return sowRecordInfoMapper.getSowRecordInfo(info);
	}

	@Override
	public List<SowRecordInfo> getAllSowRecordInfo() {
		// TODO Auto-generated method stub
		return sowRecordInfoMapper.getAllSowRecordInfo();
	}

	@Override
	public int addSowRecordInfo(SowRecordInfo info) {
		// TODO Auto-generated method stub
		try{
			int res = sowRecordInfoMapper.addSowRecordInfo(info);
			return res;
		}
		catch(Exception e)
		{
			return 0;
		}
	}

	@Override
	public int delSowRecordInfo(SowRecordInfo info) {
		// TODO Auto-generated method stub
		return sowRecordInfoMapper.delSowRecordInfo(info);
	}

	@Override
	public SowRecordInfo getSowRecordInfoBySowSeg_btCode(String sowSeg_btCode) {
		// TODO Auto-generated method stub
		return sowRecordInfoMapper.getSowRecordInfoBySowSeg_btCode(sowSeg_btCode);
	}
	
	
	
	
	
	

}
