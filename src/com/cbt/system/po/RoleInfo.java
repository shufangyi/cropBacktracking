package com.cbt.system.po;

import java.util.List;

/*
 * 2017 - 7 -11
 */
public class RoleInfo 
{
	private int roleId; 
	private String roleName;
	private String roleDesc;
	private String roleAuthority;
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleAuthority() {
		return roleAuthority;
	}
	public void setRoleAuthority(String roleAuthority) {
		this.roleAuthority = roleAuthority;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	public String toString()
	{
		return "    roleid:"+roleId+" lists:"+roleAuthority;
	}
} 
