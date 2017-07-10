package com.cbt.business.po;


public class UserInfo
{
	private String userNum;
	private String userPwd;
	private String userType;
	public String getUserNum() {
		return userNum;
	}
	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String toString()
	{
		return "userNum:"+userNum+" userPwd:"+userPwd+" userType:"+userType;
	}
	
}
