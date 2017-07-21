package com.cbt.system.mapper;

import java.util.List;
import java.util.Map;

import com.cbt.system.po.AdminInfo;

/**
 * 用户信息管理的mapper
 
 *
 */
public interface AdminInfoMapper {

	/**
	 * 添加用户信息
	 * @param user 用户信息
	 * @return
	 */
	//public int addUserInfo(UserInfo user);
	
	/**
	 * 查询用户信息
	 * @param user
	 * @return
	 */
	public AdminInfo getAdminInfo(AdminInfo user);
	
	
	public int updateAdminPwd(AdminInfo info);
	
	/**
	 * 修改用户信息
	 * @param user 用户信息
	 * @return
	 */
	//public int updateUserInfo(UserInfo user);
	
	/**
	 * 查询所有非专业用户
	 * 
	 */
	//public List<UserInfo> getGerenUserInfo(Map<String, Object> map);
	
	/**
	 * 查询总共有多少条User数据
	 * @return int
	 */
	//public int getGerenUserCount(Map<String,Object> map);
	
}
