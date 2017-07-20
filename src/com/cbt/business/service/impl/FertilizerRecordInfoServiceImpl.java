package com.cbt.business.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cbt.business.mapper.FertilizerRecordInfoMapper;
import com.cbt.business.po.FertilizerRecordInfo;
import com.cbt.business.service.FertilizerRecordInfoService;

@Service
public class FertilizerRecordInfoServiceImpl implements FertilizerRecordInfoService {
	
	@Resource(name="fertilizerRecordInfoMapper")
	private FertilizerRecordInfoMapper fertilizeRecordInfoMapper;

	@Override
	public FertilizerRecordInfo getFertilizerRecordInfo(FertilizerRecordInfo info) {
		// TODO Auto-generated method stub
		return fertilizeRecordInfoMapper.getFertilizerRecordInfo(info);
	}

	@Override
	public List<FertilizerRecordInfo> getAllFertilizerRecordInfo() {
		// TODO Auto-generated method stub
		return fertilizeRecordInfoMapper.getAllFertilizerRecordInfo();
	}

	@Override
	public int addFertilizeRecordInfo(FertilizerRecordInfo info) {
		// TODO Auto-generated method stub
		return  fertilizeRecordInfoMapper.addFertilizerRecordInfo(info);
	}

	@Override
	public int delFertilizeRecordInfo(FertilizerRecordInfo info) {
		// TODO Auto-generated method stub
		return fertilizeRecordInfoMapper.delFertilizerRecordInfo(info);
	}

	//溯源信息查询之,施肥记录
	@Override
	public List<FertilizerRecordInfo> queryFertilizerByBtCodeService(String sowSeg_btCode) throws Exception {
		return fertilizeRecordInfoMapper.queryFertilizerByBtCode(sowSeg_btCode);
	}

	//分页查询
	@Override
	public List<FertilizerRecordInfo> getFertilizerRecordService(String projectBtcode, int nowpage, int rows,String searchKey)
			throws Exception {
		int startpage=(nowpage-1)*rows;
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("startpage", startpage);
		map.put("rows", rows);
		map.put("projectBtcode", projectBtcode);
		map.put("searchKey", searchKey);
		return fertilizeRecordInfoMapper.getFertilizerRecord(map);
	}
	//更新数据
	@Override
	public int updateFertilizerBySowBtCodeService(FertilizerRecordInfo fertilizerRecordInfo) throws Exception {
		return fertilizeRecordInfoMapper.updateFertilizerBySowBtCode(fertilizerRecordInfo);
	}
	//循环删除
	public String delFertilizerRecordService(List<FertilizerRecordInfo> list)throws Exception{
		String mark="true";
		for(int i=0;i<list.size();i++){
			if(fertilizeRecordInfoMapper.delFertilizerRecordInfo(list.get(i))<=0){
				mark="false";
			}
		}
		return mark;
	}
	//get total count
	@Override
	public int getFertilizerRecordCountService(String projectBtcode, int nowpage, int rows,String searchKey) throws Exception {
		int startpage=(nowpage-1)*rows;
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("startpage", startpage);
		map.put("rows", rows);
		map.put("projectBtcode", projectBtcode);
		map.put("searchKey", searchKey);
		return fertilizeRecordInfoMapper.getFertilizerRecordCount(map);
	}
//超级用户
	@Override
	public List<FertilizerRecordInfo> getMFertilizerRecordService(String businessId, int nowrow, int rows,
			String searchKey) throws Exception {
		// TODO Auto-generated method stub
		int startpage=(nowrow-1)*rows;
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("startpage", startpage);
		map.put("rows", rows);
		map.put("businessId", businessId);
		map.put("searchKey", searchKey);
		return fertilizeRecordInfoMapper.getMFertilizerRecord(map);
	}

	@Override
	public int getMFertilizerRecordCountService(String businessId, String searchKey)
			throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("businessId",businessId);
		map.put("searchKey", searchKey);
		return fertilizeRecordInfoMapper.getMFertilizerRecordCount(map);
	}

}
