package com.cbt.system.service;

import java.util.List;

import com.cbt.system.po.AdminInfo;

/**
 * 用户信息管理的业务逻辑接口
 
 *
 */
public interface AdminInfoService {

	/**
	 * 添加用户信息
	 * @param user 用户信息
	 * @return
	 */
	//public boolean addAdminInfo(AdminInfo user);
	
	/**
	 * 根据条件查询用户信息
	 * @param user 查询条件
	 * @return
	 */
	public AdminInfo getAdminInfo(AdminInfo admin);
	
}
