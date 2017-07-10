package com.cbt.system.po;

public class AuthorityInfo 
{
	private int authorityId;
	private String authorityName;
	private String authorityUrl;
	public int getAuthorityId() {
		return authorityId;
	}
	public void setAuthorityId(int authorityId) {
		this.authorityId = authorityId;
	}
	public String getAuthorityName() {
		return authorityName;
	}
	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}
	public String getAuthorityUrl() {
		return authorityUrl;
	}
	public void setAuthorityUrl(String authorityUrl) {
		this.authorityUrl = authorityUrl;
	}
	public String toString()
	{
		return "id:"+authorityId+" name:"+authorityName+" url:"+authorityUrl;	
	}
}
