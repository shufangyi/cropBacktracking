package com.cbt.business.service;

import java.util.List;

import com.cbt.business.po.DeliverRecordInfo;

public interface DeliverRecordInfoService {
	
	public DeliverRecordInfo getDeliverRecordInfo(DeliverRecordInfo info);
	
	
	public List<DeliverRecordInfo> getAllDeliverRecordInfo();
	
	
	public int addDeliverRecordInfo(DeliverRecordInfo info);
	
	public int delDeliverRecordInfo(DeliverRecordInfo info);
}
