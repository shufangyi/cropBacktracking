package com.cbt.system.service.impl;

import java.util.HashMap;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cbt.system.mapper.CropcodeInfoMapper;
import com.cbt.system.po.CropcodeInfo;
import com.cbt.system.service.CropcodeInfoService;
@Service
public class CropcodeInfoServiceImpl implements CropcodeInfoService{
	@Resource(name="cropcodeInfoMapper")
	private CropcodeInfoMapper cropcodeInfoMapper;
	
	@Override
	public List<CropcodeInfo> getPageCropcodeInfo(int nowpage, int rows) {
		// TODO Auto-generated method stub
		int startrow=(nowpage-1)*rows;
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("startrow",startrow);
		map.put("rows", rows);   
		return cropcodeInfoMapper.getPageCropcodeInfo(map);
	}
	
	@Override
	public int getRecordsCount() {
		// TODO Auto-generated method stub
		return cropcodeInfoMapper.getCropcodeInfoCount();
	}

}
