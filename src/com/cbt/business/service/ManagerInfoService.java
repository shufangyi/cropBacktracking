package com.cbt.business.service;

import java.util.List;

import com.cbt.system.po.ManagerInfo;

public interface ManagerInfoService {
	/*查询一条数据*/
	public ManagerInfo getManagerInfo(ManagerInfo info);
	/*查询所有数据*/
	public List<ManagerInfo> getAllManagerInfo();
	/*增加一条数据*/
	public boolean addManager(ManagerInfo info);
	/*删除一条数据*/
	public Boolean delManager(List<ManagerInfo> list);
	
	

	
	
	
	public List<ManagerInfo> getPageManagers(int nowpage, int rows);
	
	public int getManagersCount();
		
	public Boolean updateManager(ManagerInfo info);

}
