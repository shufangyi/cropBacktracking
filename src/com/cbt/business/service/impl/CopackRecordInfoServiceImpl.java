package com.cbt.business.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cbt.business.mapper.CopackRecordInfoMapper;
import com.cbt.business.po.CopackRecordInfo;
import com.cbt.business.service.CopackRecordInfoService;

@Service	
public class CopackRecordInfoServiceImpl implements CopackRecordInfoService {
	
	@Resource(name="copackRecordInfoMapper")
	private CopackRecordInfoMapper copackRecordInfoMapper;
	

	@Override
	public CopackRecordInfo getCopackRecordInfo(CopackRecordInfo info) {
		// TODO Auto-generated method stub
		return  copackRecordInfoMapper.getCopackRecordInfo(info);
	}

	@Override
	public List<CopackRecordInfo> getAllCopackRecordInfo() {
		// TODO Auto-generated method stub
		return copackRecordInfoMapper.getAllCopackRecordInfo();
	}

	@Override
	public int addCopackRecordInfo(CopackRecordInfo info) {
		// TODO Auto-generated method stub
		return copackRecordInfoMapper.addCopackRecordInfo(info);
	}

	@Override
	public int delCopackRecordInfo(CopackRecordInfo info) {
		// TODO Auto-generated method stub
		return copackRecordInfoMapper.delCopackRecordInfo(info);
	}
	//queryCopackByBtCode
	@Override
	public CopackRecordInfo queryCopackByBtCodeService(String product_btCode) throws Exception {
		return copackRecordInfoMapper.queryCopackByBtCode(product_btCode);
	}

}
