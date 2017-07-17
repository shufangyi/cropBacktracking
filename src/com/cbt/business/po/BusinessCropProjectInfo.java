package com.cbt.business.po;

/*
 * 对应的数据表business_crop_projectinfo
 * 
 */
public class BusinessCropProjectInfo {
	private int Id;
	private int workerId;
	private String project_btCode;
	public int getId()
	{
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getWorkerId() {
		return workerId;
	}
	public void setWorkerId(int workerId) {
		this.workerId = workerId;
	}
	public String getProject_btCode() {
		return project_btCode;
	}
	public void setProject_btCode(String project_btCode) {
		this.project_btCode = project_btCode;
	}

}
