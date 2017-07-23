package com.cbt.utils;

/*
 * 配置数据，在beans.xml里面配置
 * 
 * 
 */
public class PathConfig {	
	private String  localPath;
	private String businessLogoPath;
	private String emailNum;
	private String emailPwd;
	private String emailSubject;
	private String emailLink;
	
	
	
	public String getEmailNum() {
		return emailNum;
	}
	public void setEmailNum(String emailNum) {
		this.emailNum = emailNum;
	}
	public String getEmailPwd() {
		return emailPwd;
	}
	public void setEmailPwd(String emailPwd) {
		this.emailPwd = emailPwd;
	}
	public String getEmailSubject() {
		return emailSubject;
	}
	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}
	public String getEmailLink() {
		return emailLink;
	}
	public void setEmailLink(String emailLink) {
		this.emailLink = emailLink;
	}
	public String getLocalPath() 
	{
		return localPath;
	}
	public void setLocalPath(String localPath) {
		this.localPath = localPath;
	}
	public String getBusinessLogoPath() {
		return businessLogoPath;
	}
	public void setBusinessLogoPath(String businessLogoPath) {
		this.businessLogoPath = businessLogoPath;
	}
	

}
