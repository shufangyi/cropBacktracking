package com.cbt.system.po;

public class ManagerInfo {
	private int id;
	private String managerNum;
	private String managerPwd;
	private int businessId;
	private String managerPhone;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getManagerNum() {
		return managerNum;
	}
	public void setManagerNum(String managerNum) {
		this.managerNum = managerNum;
	}
	public String getManagerPwd() {
		return managerPwd;
	}
	public void setManagerPwd(String managerPwd) {
		this.managerPwd = managerPwd;
	}
	public int getBusinessId() {
		return businessId;
	}
	public void setBusinessId(int businessId) {
		this.businessId = businessId;
	}
	public String getManagerPhone() {
		return managerPhone;
	}
	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}
	public String toString()
	{
		return "id:"+id+"	managerNum:"+managerNum+"	managerPwd:"+managerPwd+"	businessId:"+businessId+" "
				+ "managerPhone:"+managerPhone;
	}
}
