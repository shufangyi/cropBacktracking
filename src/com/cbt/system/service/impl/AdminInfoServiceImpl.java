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
		
		/*
		String password=user.getWorkPwd();
		try {
			//password=MD5Util.md5Encode(password);
			user.setWorkPwd(password);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		try {
			if(user!=null && user.getWorkNum()!=null&&user.getWorkPwd()!=null){
				System.out.println("hello user impl");
				System.out.println("hello user impl");
				user = userInfoMapper.getUserInfo(user);
				System.out.println("hello user impl");
				System.out.println("hello user impl");
				System.out.println(user.toString());
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
	}
}
