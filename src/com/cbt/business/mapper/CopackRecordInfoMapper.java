package com.cbt.business.mapper;

import java.util.List;
import java.util.Map;

import com.cbt.business.po.CopackRecordInfo;

public interface CopackRecordInfoMapper {
	/*查询一条数据*/
	public CopackRecordInfo getCopackRecordInfo(CopackRecordInfo info);
	/*查询所有数据*/
	public List<CopackRecordInfo> getAllCopackRecordInfo();
	/*增加一条数据*/
	public int addCopackRecordInfo(CopackRecordInfo info);
	/*删除一条数据*/
	public int delCopackRecordInfo(CopackRecordInfo info);
	//溯源信息查询之，包装信息记录
	public CopackRecordInfo queryCopackByBtCode(String product_btCode)throws Exception;
	//查询出订单号orderNum
	public String queryOrderNumByBtCode(String product_btCode)throws Exception;
	//分页查询
	public List<CopackRecordInfo> getCopackRecords(Map<String ,Object> map)throws Exception;
	//get  pagination count
	public int getCopackRecordsCount(Map<String, Object> map)throws Exception;
	//更新数据
	public int updateCopackRecord(CopackRecordInfo copackRecordInfo)throws Exception;
	//超级用户分页查询
	public List<CopackRecordInfo> getMCopackRecords(Map<String, Object> map)throws Exception;
	//get  pagination count
	public int getMCopackRecordsCount(Map<String, Object> map)throws Exception;
}
