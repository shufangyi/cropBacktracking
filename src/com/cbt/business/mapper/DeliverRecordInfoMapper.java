package com.cbt.business.mapper;

import java.util.List;

import com.cbt.business.po.DeliverRecordInfo;

public interface DeliverRecordInfoMapper {
	public DeliverRecordInfo getDeliverRecordInfo(DeliverRecordInfo info);
	
	
	public List<DeliverRecordInfo> getAllDeliverRecordInfo();
	
	
	public int addDeliverRecordInfo(DeliverRecordInfo info);
	
	public int delDeliverRecordInfo(DeliverRecordInfo info);
}
