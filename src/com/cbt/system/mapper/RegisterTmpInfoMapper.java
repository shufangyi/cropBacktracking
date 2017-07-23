package com.cbt.system.mapper;

import java.util.List;
import java.util.Map;

import com.cbt.system.po.RegisterTmpInfo;

public interface RegisterTmpInfoMapper {
	
	public int deleteRegisterTmpInfo(RegisterTmpInfo info);
		
	public List<RegisterTmpInfo> getPageRegisters(Map<String,Object> map);
	
	public int getPageRegisterCount(Map<String,Object> map);
	
	public int rejectRegister(RegisterTmpInfo info);
	
	public int allowRegister(RegisterTmpInfo info);
	
	public int addRegisterTmpInfo(RegisterTmpInfo info);
	
}
