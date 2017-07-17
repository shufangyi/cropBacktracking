package com.cbt.system.mapper;

import java.util.List;

import com.cbt.system.po.AuthorityInfo;

public interface AuthorityInfoMapper {
	
	public AuthorityInfo getAuthority(Integer authorityId);
	
	public List<AuthorityInfo> getAllAuthority();
	
}
