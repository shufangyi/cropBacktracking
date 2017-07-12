package com.cbt.business.po;

/*
 * 2017-7-11
 * 企业员工操作页面左侧菜单栏
 */

public class MenuInfo 
{
	private int menuId;
	private int menuPid;
	private String menuName;
	private String authorityId;
	private String menuUrl;
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getMenuPid() {
		return menuPid;
	}
	public void setMenuPid(int menuPid) {
		this.menuPid = menuPid;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getAuthorityId() {
		return authorityId;
	}
	public void setAuthorityId(String authorityId) {
		this.authorityId = authorityId;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	
	public String toString()
	{
		return "menuId:"+menuId+" menuPid:"+menuPid+" menuName:"+menuName+
				" menuUrl"+menuUrl+" authorityId:"
				+authorityId;
	}
}
