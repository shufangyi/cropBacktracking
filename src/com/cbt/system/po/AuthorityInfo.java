package com.cbt.system.po;
/*
 * 2017-7-11
 */
public class AuthorityInfo 
{
	private int authorityId;
	private String authorityName;
	private String authorityDesc;
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
	public String getAuthorityDesc() {
		return authorityDesc;
	}
	public void setAuthorityDesc(String authorityDesc) {
		this.authorityDesc = authorityDesc;
	}
	
	public String toString()
	{
		return "id:"+authorityId+" name:"+authorityName+"	desc:"+authorityDesc;	
	}
	
}
