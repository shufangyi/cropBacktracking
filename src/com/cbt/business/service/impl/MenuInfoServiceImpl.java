package com.cbt.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cbt.business.mapper.MenuInfoMapper;
import com.cbt.business.po.MenuInfo;
import com.cbt.business.service.MenuInfoService;


@Service
public class MenuInfoServiceImpl implements MenuInfoService{

	@Resource(name="menuInfoMapper")
	private MenuInfoMapper menuInfoMapper; 
	
	@Override
	public List<MenuInfo> getMenuByAuthorityId(List<Integer> authorityIds) {
		
		List<MenuInfo> lists = new ArrayList<MenuInfo>();
		for(int i=0;i<authorityIds.size();i++)
		{
			List<MenuInfo> list = new ArrayList<MenuInfo>();
			list=menuInfoMapper.getMenuByAuthorityId(authorityIds.get(i));
			for(int j=0;j<list.size();j++)
			{
				lists.add(list.get(j));
			}
		}
		// TODO Auto-generated method stub
		return lists;
	}

}
