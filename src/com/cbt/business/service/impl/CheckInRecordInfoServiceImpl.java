package com.cbt.business.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cbt.business.mapper.CheckInRecordInfoMapper;
import com.cbt.business.po.CheckInRecordInfo;
import com.cbt.business.service.CheckInRecordInfoService;

@Service
public class CheckInRecordInfoServiceImpl implements  CheckInRecordInfoService{
	
	@Resource(name="checkInRecordInfoMapper")
	private CheckInRecordInfoMapper checkInRecordInfoMapper;

	@Override
	public CheckInRecordInfo getCheckInRecordInfo(CheckInRecordInfo info) {
		// TODO Auto-generated method stub
		return checkInRecordInfoMapper.getCheckInRecordInfo(info);
	}

	@Override
	public List<CheckInRecordInfo> getAllCheckInRecordInfo() {
		// TODO Auto-generated method stub
		return checkInRecordInfoMapper.getAllCheckInRecordInfo();
	}

	@Override
	public int addCheckInRecordInfo(CheckInRecordInfo info) {
		// TODO Auto-generated method stub
		return checkInRecordInfoMapper.addCheckInRecordInfo(info);
	}

	@Override
	public int delCheckInRecordInfo(CheckInRecordInfo info) {
		// TODO Auto-generated method stub
		return  checkInRecordInfoMapper.delCheckInRecordInfo(info);
	}
	//溯源信息查询之，质检入库记录
	@Override
	public CheckInRecordInfo queryCheckInByBtCodeService(String checkInSeg_btCode) throws Exception {
		return checkInRecordInfoMapper.queryCheckInByBtCode(checkInSeg_btCode);
	}
	//分页查询
	@Override
	public List<CheckInRecordInfo> getCheckInRecordByPaginationService(Map<String, Object> map) throws Exception {
		return checkInRecordInfoMapper.getCheckInRecordByPagination(map);
	}
	//更新数据
	@Override
	public int updateCheckInRecordService(CheckInRecordInfo checkInRecordInfo) throws Exception {
		return checkInRecordInfoMapper.updateCheckInRecord(checkInRecordInfo);
	}
	//获取分页数据总数
	@Override
	public int getPaginationCountService(Map<String, Object> map) throws Exception {
		return checkInRecordInfoMapper.getPaginationCount(map);
	}
	//
	public String delCheckInRecords(List<CheckInRecordInfo> list)throws Exception{
		String mark="true";
		for(int i=0;i<list.size();i++){
			if(checkInRecordInfoMapper.delCheckInRecordInfo(list.get(i))<=0){
				mark="false";
				return mark;
			}
			
		}
		return mark;
	}

	@Override
	public List<CheckInRecordInfo> getMCheckInRecordByPaginationService(String businessId, int startpage, int rows,
			String searchKey) throws Exception {
		// TODO Auto-generated method stub
		int startrow=(startpage-1)*rows;
		HashMap<String,Object> map=new HashMap<String,Object>();  
		map.put("startrow",startrow);
		map.put("rows", rows);
		map.put("businessId", businessId);
		map.put("searchKey", searchKey);
		System.out.println("map:"+businessId);
		return checkInRecordInfoMapper.getMCheckInRecordByPagination(map);
	}

	@Override
	public int getMPaginationCountService(String businessId, String searchKey) throws Exception {
		// TODO Auto-generated method stub
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("businessId", businessId);
		map.put("searchKey", searchKey);
		return checkInRecordInfoMapper.getMPaginationCount(map);
	}

}
