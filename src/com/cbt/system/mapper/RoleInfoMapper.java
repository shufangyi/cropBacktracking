package com.cbt.system.mapper;

import java.util.List;
import java.util.Map;

import com.cbt.business.po.SowRecordInfo;
import com.cbt.system.po.RoleInfo;

public interface RoleInfoMapper 
{
	public RoleInfo getRoleAuthority(Integer roleId);
	
	public int addRole(RoleInfo info);
	
	
	//2017 - 7 -16
	/*分页查询*/
	public List<RoleInfo> getPageRoles(Map<String,Object> map);
	/*分页记录*/
	public int getRolesCount();	
	//修改数据
	public int updateRole(RoleInfo info);
	
	//删除数据
	public int delRoleInfo(RoleInfo info);
	
}
