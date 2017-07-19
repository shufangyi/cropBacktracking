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
	public Boolean delSowRecordInfo(List<SowRecordInfo> list) {
		// TODO Auto-generated method stub
		Boolean mark = true;
		for(int i=0;i<list.size();i++)
		{
			int k = sowRecordInfoMapper.delSowRecordInfo(list.get(i));
			if(k<=0){
				return false;
			}
		}
		return true;
	}

	@Override
	public SowRecordInfo getSowRecordInfoBySowSeg_btCode(String sowSeg_btCode) {
		// TODO Auto-generated method stub
		return sowRecordInfoMapper.getSowRecordInfoBySowSeg_btCode(sowSeg_btCode);
	}

	/* 查询 分页*/
	@Override
	public List<SowRecordInfo> getPageSowRecords(int nowpage, int rows,String project_btCode) {
		// TODO Auto-generated method stub
		int startrow=(nowpage-1)*rows;
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("startrow",startrow);
		map.put("rows", rows);   
		map.put("project_btCode", project_btCode);
		return sowRecordInfoMapper.getPageSowRecords(map);
	}
	
	
	/*查询记录总数*/
	@Override
	public int getRecordsCount(int nowpage,int rows,String project_btCode) {
		int startrow=(nowpage-1)*rows;
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("startrow",startrow);
		map.put("rows", rows);   
		map.put("project_btCode", project_btCode);
		return sowRecordInfoMapper.getRecordsCount(map);
	}

	
	//修改数据
	@Override
	public Boolean updateSowRecord(SowRecordInfo info) {
		// TODO Auto-generated method stub
		try {
			int i = sowRecordInfoMapper.updateSowRecord(info);
			if(i>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	//通过项目码查询
	@Override
	public SowRecordInfo queryByProjectBtCodeService(String projectBtcode) throws Exception {
		return sowRecordInfoMapper.queryByProjectBtCode(projectBtcode);
	}

	
}
