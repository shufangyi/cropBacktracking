package com.cbt.system.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
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

	@Override
	public Boolean addRole(RoleInfo info) {
		// TODO Auto-generated method stub
		int i = roleInfoMapper.addRole(info);
		if(i > 0 )
			return true;
		return false;
	}

	@Override
	public List<RoleInfo> getPageRoles(int nowpage, int rows) {
		// TODO Auto-generated method stub
		int startrow=(nowpage-1)*rows;
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("startrow",startrow);
		map.put("rows", rows);   
		return roleInfoMapper.getPageRoles(map);
	}

	@Override
	public int getRecordsCount() {
		// TODO Auto-generated method stub
		return roleInfoMapper.getRolesCount();
	}

	@Override
	public Boolean updateRole(RoleInfo info) {
		// TODO Auto-generated method stub
		try {
			int i = roleInfoMapper.updateRole(info);
			if(i>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	
	//删除数据
	@Override
	public Boolean delRoleInfo(List<RoleInfo> list) {
		// TODO Auto-generated method stub
		
		
		Boolean mark = true;
		for(int i=0;i<list.size();i++)
		{
			int k = roleInfoMapper.delRoleInfo(list.get(i));
			if(i<=0){
				return false;
			}
		}
		return true;
	}

}
