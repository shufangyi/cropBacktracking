package com.cbt.system.service;

import java.util.HashMap;
import java.util.List;

import com.cbt.business.po.SowRecordInfo;
import com.cbt.system.po.AdminInfo;
import com.cbt.system.po.AuthorityInfo;
import com.cbt.system.po.RoleInfo;



public interface RoleInfoService 
{
	public RoleInfo getRoleAuthority(Integer roleId);
	
	
	public Boolean addRole(RoleInfo info);	
	
	
	public List<RoleInfo> getPageRoles(int nowpage, int rows,String searchKey);
	
	public int getRecordsCount(int nowpage, int rows,String searchKey);
	
	
	public Boolean updateRole(RoleInfo info);
	
	//删除数据
	Boolean delRoleInfo(List<RoleInfo> list);
	
	//2017-07-18
	public List<RoleInfo> getRoles();
}
