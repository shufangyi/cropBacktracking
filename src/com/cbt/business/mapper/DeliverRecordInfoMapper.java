package com.cbt.business.mapper;

import java.util.List;

import com.cbt.business.po.DeliverRecordInfo;

public interface DeliverRecordInfoMapper {
	/*查询一条数据*/
	public DeliverRecordInfo getDeliverRecordInfo(DeliverRecordInfo info);
	/*查询所有数据*/
	public List<DeliverRecordInfo> getAllDeliverRecordInfo();
	/*增加一条数据*/
	public int addDeliverRecordInfo(DeliverRecordInfo info);
	/*删除一条数据*/
	public int delDeliverRecordInfo(DeliverRecordInfo info);
	//溯源信息之，查询出物流记录
	public DeliverRecordInfo queryDeliverByOrderNum(String orderNum)throws Exception;
}
