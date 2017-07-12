package com.cbt.business.service;

import java.util.List;

import com.cbt.business.po.MenuInfo;

public interface MenuInfoService 
{
	public List<MenuInfo> getMenuByAuthorityId(List<Integer> authorityIds);
}
