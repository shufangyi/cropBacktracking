package com.cbt.system.po;

import java.util.List;

public class RoleInfo 
{
	private int roleId;
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
	public String toString()
	{
		return "    roleid:"+roleId+" lists:"+roleAuthority;
	}
} 
