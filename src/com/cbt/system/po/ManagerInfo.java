package com.cbt.system.po;

public class ManagerInfo {
	private int id;
	private String managerNum;
	private String managerPwd;
	private int businessId;
	private String managerPhone;
	private String managerName;
	private String managerEmail;
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	private String businessName;
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
	public String getManagerEmail() {
		return managerEmail;
	}
	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}
}
