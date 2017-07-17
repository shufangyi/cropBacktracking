package com.cbt.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cbt.system.mapper.AuthorityInfoMapper;
import com.cbt.system.po.AuthorityInfo;
import com.cbt.system.service.AuthorityInfoService;

@Service
public class AuthorityInfoServiceImpl implements AuthorityInfoService
{

	@Resource(name="authorityInfoMapper")
	private AuthorityInfoMapper authorityInfoMapper;
	@Override
	public AuthorityInfo getAuthority(Integer authorityId) {
		// TODO Auto-generated method stub
		System.out.println("hello serv");
		return authorityInfoMapper.getAuthority(authorityId);
	}
	
	@Override
	public List<AuthorityInfo> getAllAuthority() {
		// TODO Auto-generated method stub
		return authorityInfoMapper.getAllAuthority();
	}

}
