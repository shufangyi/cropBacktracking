package com.cbt.business.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cbt.business.mapper.PickRecordInfoMapper;
import com.cbt.business.po.PickRecordInfo;
import com.cbt.business.service.PickRecordInfoService;
@Service

public class PickRecordInfoServiceImpl implements PickRecordInfoService {

	@Resource(name="pickRecordInfoMapper")
	private PickRecordInfoMapper pickRecordInfoMapper;
	@Override
	public PickRecordInfo getPickRecordInfo(PickRecordInfo info) {
		// TODO Auto-generated method stub
		return pickRecordInfoMapper.getPickRecordInfo(info);
	}

	@Override
	public List<PickRecordInfo> getAllPickRecordInfo() {
		// TODO Auto-generated method stub
		return pickRecordInfoMapper.getAllPickRecordInfo();
	}

	@Override
	public int addPickRecordInfo(PickRecordInfo info) {
		// TODO Auto-generated method stub
		return pickRecordInfoMapper.addPickRecordInfo(info);
	}

	@Override
	public int delPickRecordInfo(PickRecordInfo info) {
		// TODO Auto-generated method stub
		return pickRecordInfoMapper.delPickRecordInfo(info);
	}

	//溯源信息查询之，采摘记录 
	@Override
	public PickRecordInfo queryPickByBtCode(String pickSeg_btCode) throws Exception {
		return pickRecordInfoMapper.queryPickByBtCode(pickSeg_btCode);
	}

	//更新采摘信息
	@Override
	public int updatePickRecordService(PickRecordInfo pickRecordInfo) throws Exception {
		return pickRecordInfoMapper.updatePickRecord(pickRecordInfo);
	}

	//分页查询
	@Override
	public List<PickRecordInfo> queryPickRecordsService(String projectBtcode,int nowpage,int rows,String searchKey) throws Exception {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("startpage", (nowpage-1)*rows);
		map.put("projectBtcode", projectBtcode);
		map.put("rows", rows);
		map.put("searchKey", searchKey);
		return pickRecordInfoMapper.queryPickRecords(map);
	}

	//循环删除
	@Override
	public boolean delPickRecordByListService(List<PickRecordInfo> list) throws Exception {
		for(int i=0;i<list.size();i++){
			if(pickRecordInfoMapper.delPickRecordInfo(list.get(i))<=0){
				return false;
			}
		}
		return true;
	}
	//get total count
	@Override
	public int getPickRecordCountService(String projectBtcode,int nowpage,int rows,String searchKey) throws Exception {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("startpage", (nowpage-1)*rows);
		map.put("projectBtcode", projectBtcode);
		map.put("rows", rows);
		map.put("searchKey", searchKey);
		return pickRecordInfoMapper.getPickRecordCount(map);
	}

	//超级用户分页查询
	@Override
	public List<PickRecordInfo> queryMPickRecordsService(String businessId, int nowpage, int rows, String searchKey)
			throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("startpage", (nowpage-1)*rows);
		map.put("businessId", businessId);
		map.put("rows", rows);
		map.put("searchKey", searchKey);
		return pickRecordInfoMapper.queryMPickRecords(map);
		
	}

	@Override
	public int getMPickRecordCountService(String businessId, String searchKey) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("businessId", businessId);
		map.put("searchKey", searchKey);
		return pickRecordInfoMapper.getMPickRecordCount(map);
	}

}
