package com.cbt.visitor.po;

public class ProductStatusInfo 
{
	private int id;
	private String product_btCode;
	private int publicStatus;
	private int queryTimes;
	
	
	public String getProduct_btCode() {
		return product_btCode;
	}
	public void setProduct_btCode(String product_btCode) {
		this.product_btCode = product_btCode;
	}
	public int getPublicStatus() {
		return publicStatus;
	}
	public void setPublicStatus(int publicStatus) {
		this.publicStatus = publicStatus;
	}
	public int getQueryTimes() {
		return queryTimes;
	}
	public void setQueryTimes(int queryTimes) {
		this.queryTimes = queryTimes;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}
