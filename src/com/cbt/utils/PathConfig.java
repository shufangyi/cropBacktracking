package com.cbt.utils;

/*
 * 配置数据，在beans.xml里面配置
 * 
 * 
 */
public class PathConfig {	
	private String  localPath;
	private String businessLogoPath;
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
