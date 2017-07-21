package com.cbt.system.service.impl;



import javax.annotation.Resource;

import org.springframework.stereotype.Service;

//import com.jit.po.UserInfoVo;
import com.cbt.system.mapper.AdminInfoMapper;
import com.cbt.system.po.AdminInfo;
import com.cbt.system.service.AdminInfoService;
//import com.cbt.utils.MD5Util;

@Service
public class AdminInfoServiceImpl implements AdminInfoService {

	@Resource(name="adminInfoMapper")
	private AdminInfoMapper adminInfoMapper;
	@Override
	public AdminInfo getAdminInfo(AdminInfo admin) {		
		admin = adminInfoMapper.getAdminInfo(admin);
		return admin;
	}
	@Override
	public Boolean updateAdminPwd(AdminInfo info) {
		// TODO Auto-generated method stub
		int i = adminInfoMapper.updateAdminPwd(info);
		if(i>0)
		{
			return true;
		}
		return false;
	}
}
