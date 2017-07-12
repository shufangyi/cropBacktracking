package com.cbt.business.mapper;

import java.util.List;

import com.cbt.business.po.MenuInfo;

public interface MenuInfoMapper {
	public List<MenuInfo> getMenuByAuthorityId(int authorityId);
}
