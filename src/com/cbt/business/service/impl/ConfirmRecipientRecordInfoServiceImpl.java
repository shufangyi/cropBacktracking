package com.cbt.business.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cbt.business.mapper.ConfirmRecipientRecordInfoMapper;
import com.cbt.business.mapper.CopackRecordInfoMapper;
import com.cbt.business.po.ConfirmRecipientRecordInfo;
import com.cbt.business.service.ConfirmRecipientRecordInfoService;
@Service
public class ConfirmRecipientRecordInfoServiceImpl implements ConfirmRecipientRecordInfoService {
	
	@Resource(name="confirmRecipientRecordInfoMapper")
	private ConfirmRecipientRecordInfoMapper confirmRecipientRecordInfoMapper;
	
	@Resource(name="copackRecordInfoMapper")
	private CopackRecordInfoMapper copackRecordInfoMapper;
	
	@Override
	public ConfirmRecipientRecordInfo getConfirmRecipientRecordInfo(ConfirmRecipientRecordInfo info) {
		// TODO Auto-generated method stub
		return confirmRecipientRecordInfoMapper.getConfirmRecipientRecordInfo(info);
	}

	@Override
	public List<ConfirmRecipientRecordInfo> getAllConfirmRecipientRecordInfo() {
		// TODO Auto-generated method stub
		return confirmRecipientRecordInfoMapper.getAllConfirmRecipientRecordInfo();
	}

	@Override
	public int addConfirmRecipientRecordInfo(ConfirmRecipientRecordInfo info) {
		// TODO Auto-generated method stub
		return confirmRecipientRecordInfoMapper.addConfirmRecipientRecordInfo(info);
	}

	@Override
	public int delConfirmRecipientRecordInfo(ConfirmRecipientRecordInfo info) {
		// TODO Auto-generated method stub
		return confirmRecipientRecordInfoMapper.delConfirmRecipientRecordInfo(info);
	}
	//溯源信息查询之，确认收货信息
	@Override
	public ConfirmRecipientRecordInfo queryConfirmByOrderNumService(String product_btCode) throws Exception {
		return confirmRecipientRecordInfoMapper.queryConfirmByOrderNum(copackRecordInfoMapper.queryOrderNumByBtCode(product_btCode));
	}
	//分页查询
	@Override
	public List<ConfirmRecipientRecordInfo> getConfirmRecipientRecordsService(Map<String, Object> map)
			throws Exception {
		return confirmRecipientRecordInfoMapper.getConfirmRecipientRecords(map);
	}
	//分页查询的条数
	@Override
	public int getConfirmRecipientRecordsCountService(Map<String, Object> map) throws Exception {
		return confirmRecipientRecordInfoMapper.getConfirmRecipientRecordsCount(map);
	}
	//更新数据
	@Override
	public int updateConfirmRecipientRecordService(ConfirmRecipientRecordInfo confirmRecipientRecordInfo)
			throws Exception {
		return confirmRecipientRecordInfoMapper.updateConfirmRecipientRecord(confirmRecipientRecordInfo);
	}
	//通过distributoe查找
	@Override
	public List<ConfirmRecipientRecordInfo> queryByDistributorService(String distributor) throws Exception {
		return confirmRecipientRecordInfoMapper.queryByDistributor(distributor);
	}
	//循环删除
	@Override
	public String deleteConfirmRecipientRecords(List<ConfirmRecipientRecordInfo> list) throws Exception {
		String mark="true";
		for(int i=0;i<list.size();i++){
			if(confirmRecipientRecordInfoMapper.delConfirmRecipientRecordInfo(list.get(i))<=0){
				mark="false";
				return mark;
			}
			
		}
		return mark;
	}

}
