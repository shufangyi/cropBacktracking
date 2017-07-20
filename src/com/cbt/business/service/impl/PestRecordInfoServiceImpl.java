package com.cbt.business.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	//分页查询
	@Override
	public List<PestRecordInfo> getPestRecordsService(String projectBtcode, int nowpage, int rows,String searchKey) throws Exception {
		int startpage=(nowpage-1)*rows;
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("startpage", startpage);
		map.put("rows", rows);
		map.put("projectBtcode", projectBtcode);
		map.put("searchKey", searchKey);
		return pestRecordInfoMapper.getPestRecords(map);
	}

	//循环删除
	@Override
	public String delPestRecordInfoService(List<PestRecordInfo> list) throws Exception {
		String mark="true";
		for(int i=0;i<list.size();i++){
			if(pestRecordInfoMapper.delPestRecordInfo(list.get(i))<=0){
				mark="false";
				return mark;
			}
		}
		return mark;
	}
	//update a record
	@Override
	public int updatePestRecordInfoService(PestRecordInfo pestRecordInfo) throws Exception {
		return pestRecordInfoMapper.updatePestRecordInfo(pestRecordInfo);
	}
	//get total count
	@Override
	public int getCountService(String projectBtcode, int nowpage, int rows,String searchKey) throws Exception {
		int startpage=(nowpage-1)*rows;
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("startpage", startpage);
		map.put("rows", rows);
		map.put("projectBtcode", projectBtcode);
		map.put("searchKey", searchKey);
		return pestRecordInfoMapper.getCount(map);
	}

}
