package com.cbt.business.service.impl;

import java.util.HashMap;
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

	/* 查询 分页*/
	@Override
	public List<SowRecordInfo> getPageSowRecords(int nowpage, int rows) {
		// TODO Auto-generated method stub
		int startrow=(nowpage-1)*rows;
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("startrow",startrow);
		map.put("rows", rows);       		
		return sowRecordInfoMapper.getPageSowRecords(map);
	}

	@Override
	public int getRecordsCount(String name) {
		// TODO Auto-generated method stub
		HashMap<String,Object> map=new HashMap<String,Object>();
		return sowRecordInfoMapper.getRecordsCount(map);
	}
	
	/*查询记录总数*/
	
}
