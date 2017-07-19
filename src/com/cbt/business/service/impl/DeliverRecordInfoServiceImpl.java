package com.cbt.business.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cbt.business.mapper.CopackRecordInfoMapper;
import com.cbt.business.mapper.DeliverRecordInfoMapper;
import com.cbt.business.po.DeliverRecordInfo;
import com.cbt.business.service.DeliverRecordInfoService;
@Service
public class DeliverRecordInfoServiceImpl implements DeliverRecordInfoService {
	
	@Resource(name="deliverRecordInfoMapper")
	private DeliverRecordInfoMapper deliverRecordInfoMapper;
	@Resource(name="copackRecordInfoMapper")
	private CopackRecordInfoMapper copackRecordInfoMapper;

	@Override
	public DeliverRecordInfo getDeliverRecordInfo(DeliverRecordInfo info) {
		// TODO Auto-generated method stub
		return deliverRecordInfoMapper.getDeliverRecordInfo(info);
	}

	@Override
	public List<DeliverRecordInfo> getAllDeliverRecordInfo() {
		// TODO Auto-generated method stub
		return deliverRecordInfoMapper.getAllDeliverRecordInfo();
	}

	@Override
	public int addDeliverRecordInfo(DeliverRecordInfo info) {
		// TODO Auto-generated method stub
		return  deliverRecordInfoMapper.addDeliverRecordInfo(info);
	}

	@Override
	public int delDeliverRecordInfo(DeliverRecordInfo info) {
		// TODO Auto-generated method stub
		return deliverRecordInfoMapper.delDeliverRecordInfo(info);
	}
	//溯源信息查询之，物流信息记录
	@Override
	public DeliverRecordInfo queryDeliverByBtCodeService(String product_btCode) throws Exception {	
		return deliverRecordInfoMapper.queryDeliverByOrderNum(copackRecordInfoMapper.queryOrderNumByBtCode(product_btCode));
	
	}
	//分页查询
	@Override
	public List<DeliverRecordInfo> getDeliverRecordsService(Map<String, Object> map) throws Exception {
		return deliverRecordInfoMapper.getDeliverRecords(map);
	}
	//分页查询数据count
	@Override
	public int getDeliverRecordsCountService(Map<String, Object> map) throws Exception {
		return deliverRecordInfoMapper.getDeliverRecordsCount(map);
	}
	//更新数据
	@Override
	public int updateDeliverRecordService(DeliverRecordInfo deliverRecordInfo) throws Exception {
		return deliverRecordInfoMapper.updateDeliverRecord(deliverRecordInfo);
	}
	//循环删除
	@Override
	public String deleteDeliverRecords(List<DeliverRecordInfo> list) throws Exception {
		String mark="true";
		for(int i=0;i<list.size();i++){
			if(deliverRecordInfoMapper.delDeliverRecordInfo(list.get(i))<=0){
				mark="false";
				return mark;
				
			}
			
		}
		return mark;
	}
	//通过负责人账号查找
	@Override
	public List<DeliverRecordInfo> queryByLogisticsService(String logistics) throws Exception {
		return deliverRecordInfoMapper.queryByLogistics(logistics);
	}

}
