package com.cbt.system.service;

import java.util.List;
import java.util.Map;

import com.cbt.system.po.RegisterTmpInfo;

public interface RegisterTmpInfoService {

	
	public Boolean deleteRegisterTmpInfo(List<RegisterTmpInfo> list);
		
	public List<RegisterTmpInfo> getPageRegisters(int startpage,int rows,String status);
	
	public int getPageRegisterCount(String status);
	
	public Boolean rejectRegister(List<RegisterTmpInfo> list);
	
	public Boolean allowRegister(List<RegisterTmpInfo> list);
	
	public Boolean addRegisterTmpInfo(RegisterTmpInfo info);
}
