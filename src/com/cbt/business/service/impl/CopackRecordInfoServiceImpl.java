package com.cbt.business.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	//分页查询数据
	@Override
	public List<CopackRecordInfo> getCopackRecordsService(Map<String, Object> map) throws Exception {
		return copackRecordInfoMapper.getCopackRecords(map);
	}
	//get pagination count
	public int getCopackRecordsCountService(Map<String, Object> map)throws Exception{
		return copackRecordInfoMapper.getCopackRecordsCount(map);
		
	}
	//更新包装数据
	@Override
	public int updateCopackRecordService(CopackRecordInfo copackRecordInfo) throws Exception {
		return copackRecordInfoMapper.updateCopackRecord(copackRecordInfo);
	}
	//循环删除数据
	@Override
	public String delCopackRecordsService(List<CopackRecordInfo> list) throws Exception {
		String mark="true";
		for(int i=0;i<list.size();i++){
			if(copackRecordInfoMapper.delCopackRecordInfo(list.get(i))<=0){
				mark="false";
				return mark;
			}
		}
		return mark;
	}
//超级用户查询
	@Override
	public List<CopackRecordInfo> getMCopackRecordsService(String businessId, int nowrow, int rows, String searchKey)
			throws Exception {
		// TODO Auto-generated method stub
		int startrow=(nowrow-1)*rows;
		System.out.println(startrow);
		HashMap<String,Object> map=new HashMap<String,Object>();  
		map.put("startrow",startrow);
		map.put("rows", rows);
		map.put("businessId", businessId);
		map.put("searchKey", searchKey);
		return copackRecordInfoMapper.getMCopackRecords(map);
	}


	@Override
	public int getMCopackRecordsCountService(String businessId, String searchKey) throws Exception {
		// TODO Auto-generated method stub
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("businessId", businessId);
		map.put("searchKey", searchKey);
		return  copackRecordInfoMapper.getMCopackRecordsCount(map);
	}

	@Override
	public int getCopackInfoCount(String projectCode, String searchKey) throws Exception {
		// TODO Auto-generated method stub
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("projectCode", projectCode);
		map.put("searchKey", searchKey);
		return  copackRecordInfoMapper.getCopackInfoCount(map);
	}

	@Override
	public List<CopackRecordInfo> getPageCopackInfo(String projectCode, int nowrow, int rows, String searchKey)
			throws Exception {
		int startrow=(nowrow-1)*rows;
		System.out.println(startrow);
		HashMap<String,Object> map=new HashMap<String,Object>();  
		map.put("startrow",startrow);
		map.put("rows", rows);
		map.put("projectCode", projectCode);
		map.put("searchKey", searchKey);
		return copackRecordInfoMapper.getPageCopackInfo(map);
	}

	
	@Override
	public CopackRecordInfo queryByOrderNumService(CopackRecordInfo copackRecordInfo) throws Exception {
		return copackRecordInfoMapper.queryByOrderNum(copackRecordInfo);
	}

	

}
