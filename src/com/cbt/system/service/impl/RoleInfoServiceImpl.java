package com.cbt.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cbt.system.mapper.RoleInfoMapper;
import com.cbt.system.po.AuthorityInfo;
import com.cbt.system.po.RoleInfo;
import com.cbt.system.service.RoleInfoService;

@Service
public class RoleInfoServiceImpl implements RoleInfoService{
	@Resource(name="roleInfoMapper")
	private RoleInfoMapper roleInfoMapper;
	
	@Override
	public RoleInfo getRoleAuthority(Integer roleId) {
		// TODO Auto-generated method stub
		List<AuthorityInfo> list = new ArrayList<AuthorityInfo>();
		RoleInfo roleInfo = roleInfoMapper.getRoleAuthority(roleId); 
		
		
		
		System.out.println("��ȡȨ��"+roleInfo.toString());
		/*
		for(int i=0;i<lists.length;i++)
		{
			AuthorityInfo info = new AuthorityInfo();
		}
		*/	
		return roleInfo;
	}

}
