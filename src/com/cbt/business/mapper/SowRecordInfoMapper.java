package com.cbt.business.mapper;

import java.util.List;

import com.cbt.business.po.SowRecordInfo;

public interface SowRecordInfoMapper
{
	/*查询一条数据*/
	public SowRecordInfo getSowRecordInfo(SowRecordInfo info);
	/*查询所有数据*/
	public List<SowRecordInfo> getAllSowRecordInfo();
	/*增加一条数据*/
	public int addSowRecordInfo(SowRecordInfo info);
	/*删除一条数据 */
	public int delSowRecordInfo(SowRecordInfo info);
	
	/*
	 * 根据Product_btCode查询一条数据
	 */
	public SowRecordInfo getSowRecordInfoBySowSeg_btCode(String sowSeg_btCode);
	
}
