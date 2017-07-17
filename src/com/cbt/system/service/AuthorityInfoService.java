package com.cbt.system.service;

import java.util.List;

import com.cbt.system.po.AuthorityInfo;

public interface AuthorityInfoService 
{
	public AuthorityInfo getAuthority(Integer authorityId);
	
	
	public List<AuthorityInfo> getAllAuthority();
}
