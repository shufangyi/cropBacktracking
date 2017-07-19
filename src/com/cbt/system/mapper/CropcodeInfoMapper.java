package com.cbt.system.mapper;

import java.util.List;
import java.util.Map;

import com.cbt.system.po.CropcodeInfo;

public interface CropcodeInfoMapper {

	/*分页查询*/
	public List<CropcodeInfo> getPageCropcodeInfo(Map<String,Object> map);
	/*分页记录*/
	public int getCropcodeInfoCount();
	
}