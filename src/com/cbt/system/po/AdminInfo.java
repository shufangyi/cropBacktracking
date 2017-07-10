package com.cbt.system.po;
/*
 * 
 * 系统管理员实体类
 */
public class AdminInfo{
	private String adminNum;//账号
	private String adminPwd;//密码
	
	public String getAdminNum() {
		return adminNum;
	}
	public void setAdminNum(String adminNum) {
		this.adminNum = adminNum;
	}
	public String getAdminPwd() {
		return adminPwd;
	}
	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}
	public String toString()
	{
		return "adminNum:"+adminNum+"	adminPwd:"+adminPwd;
	}
}
